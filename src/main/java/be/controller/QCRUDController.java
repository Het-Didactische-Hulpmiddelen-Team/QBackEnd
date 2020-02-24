package be.controller;

import be.model.QService;
import be.model.Room;
import org.json.JSONObject;
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

    @GetMapping("/room/get/{roomid}")
    public Object getRoom(@PathVariable(value = "roomid") long roomid){
        return service.getRoom(roomid);
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

    @GetMapping("room/deleteat/{roomid}/{userid}")
    public Object deleteAt(@PathVariable(value = "userid") long userid,@PathVariable(value = "roomid") long roomid) {
        service.leaveRoom(userid,roomid);
        return service.getQueue(roomid);
    }

    @GetMapping("room/clear/{roomid}")
    public Object clearRoom(@PathVariable(value = "roomid") long roomid) {
        service.clearRoom(roomid);
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

    @PostMapping("authenticate")
    public boolean authenticate(@RequestBody String json){
        JSONObject temp = new JSONObject(json);
        return service.authenticate(temp.getString("name"),temp.getString("password"));
    }

    @GetMapping("isAuthenticated")
    public boolean isAuthenticated(){
        return service.isAuthenticated();
    }

    @GetMapping("unAuthenticate")
    public boolean unAuthenticate(){
        return service.unAuthenticate();
    }


}
