package be.controller;

import be.model.QService;
import be.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class QCRUDController {
    @Autowired
    QService service;

    public QCRUDController() {

    }

    @GetMapping("/room/all")
    public Object getRooms(){
        return service.getRooms();
    }

    @GetMapping("/room/queue/{roomid}")
    public Object getQueue(@PathVariable(value = "roomid") long roomid){
        return service.getQueue(roomid);
    }

    @GetMapping("room/join/{roomid}/{name}")
    public Object joinRoom(@PathVariable(value = "name") String name,@PathVariable(value = "roomid") long roomid) {
        service.joinRoom(name,roomid);
        return service.getQueue(roomid);
    }

    @GetMapping("room/leave/{roomid}/{name}")
    public Object leaveRoom(@PathVariable(value = "name") String name,@PathVariable(value = "roomid") long roomid) {
        service.leaveRoom(name,roomid);
        return service.getQueue(roomid);
    }

    @GetMapping("room/delete/{roomid}")
    public Object deleteRoom(@PathVariable(value = "roomid") long roomid){
        try {
            service.deleteRoom(roomid);
            return getRooms();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping("room/create")
    public void createRoom(@RequestBody Room room){
        try {
            service.createRoom(room);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    @GetMapping("authenticate")
    public boolean authenticate(String name,String password){
        return service.authenticate(name,password);
    }

    @GetMapping("isAuthenticated")
    public boolean isAuthenticated(String name){
        return service.isAuthenticated(name);
    }

    @GetMapping("unAuthenticate")
    public boolean unAuthenticate(String name){
        return service.unAuthenticate(name);
    }




}
