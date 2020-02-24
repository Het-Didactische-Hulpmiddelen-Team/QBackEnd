package be.model;


import be.db.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QService {

    @Autowired
    private RoomRepository roomRepository;

    private boolean authenticated = false;

    public QService() {

    }

    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    public void joinRoom(String name, long roomid) {
        Room room = roomRepository.findById(roomid).get();
        if(!getQueue(roomid).contains(name)){
            room.addToQueue(name);
            roomRepository.save(room);
        }
    }

    public void leaveRoom(String name, long roomid) {
        Room room = roomRepository.findById(roomid).get();
        room.deleteFromQueue(name);
        roomRepository.save(room);
    }

    public void leaveRoom(Long userid, long roomid) {
        Room room = roomRepository.findById(roomid).get();
        room.deleteFromQueue(userid);
        roomRepository.save(room);
    }

    public Room getRoom(long roomid){
        return roomRepository.findById(roomid).get();
    }

    public void createRoom(Room room){
       if(authenticated){
           roomRepository.save(room);
       }
    }

    public void deleteRoom(long id){
        if(authenticated){
            roomRepository.deleteById(id);
        }
    }

    public List<String> getQueue(long roomid){
        return roomRepository.findById(roomid).get().getQueue();
    }

    public boolean authenticate(String name, String password) {
        authenticated = name.toUpperCase().equals("ROOT") && password.equals("qwerty");
        return isAuthenticated();
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public boolean unAuthenticate() {
        authenticated = false;
        return isAuthenticated();
    }

    public void clearRoom(long roomid) {
        Room room = roomRepository.findById(roomid).get();
        room.setQueue(new ArrayList<>());
        roomRepository.save(room);
    }
}
