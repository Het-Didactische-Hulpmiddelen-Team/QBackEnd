package be.model;


import be.db.RoomRepository;
import be.db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QService {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserRepository userRepository;

    public QService() {

    }

    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    public void joinRoom(String name, long roomid) {
        userRepository.save(new User(name));
        Room room = roomRepository.findById(roomid).get();
        User user = userRepository.findByName(name);
        room.addToQueue(user.getId());
        roomRepository.save(room);
    }

    public void leaveRoom(String name, long roomid) {
        Room room = roomRepository.findById(roomid).get();
        User user = userRepository.findByName(name);
        room.deleteFromQueue(user.getId());
        roomRepository.save(room);
    }

    public Room getRoom(long roomid){
        return roomRepository.findById(roomid).get();
    }

    public void createRoom(Room room){
        roomRepository.save(room);
    }

    public void deleteRoom(long id){
        roomRepository.deleteById(id);
    }
}
