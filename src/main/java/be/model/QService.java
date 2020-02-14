package be.model;


import be.db.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.List;

@Service
public class QService {

    @Autowired
    private RoomRepository roomRepository;

    @PersistenceContext
    EntityManager entityManager;

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
        Room room = roomRepository.findById(roomid).get();
        return room.getQueue();
    }

    public boolean authenticate(String name, String password) {
        authenticated = true;
        return isAuthenticated(name);
    }

    public boolean isAuthenticated(String name) {
        return authenticated;
    }

    public boolean unAuthenticate(String name) {
        authenticated = false;
        return isAuthenticated(name);
    }

    public long getIdByName(String name){
        String query = "select id from user where name='"+name+"'order by id desc limit 1";
        return ((BigInteger)entityManager.createNativeQuery(query).getSingleResult()).longValue();
    }
}
