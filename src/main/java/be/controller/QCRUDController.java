package be.controller;

import be.model.QService;
import be.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class QCRUDController {
    @Autowired
    QService service;

    public QCRUDController() {

    }

    @GetMapping("/room/all")
    public List<Room> getRooms(){
        return service.getRooms();
    }

    @GetMapping("room/join/{roomid}/{name}")
    public Room joinRoom(@PathVariable(value = "name") String name,@PathVariable(value = "roomid") long roomid) {
        service.joinRoom(name,roomid);
        return service.getRoom(roomid);
    }

    @GetMapping("room/leave/{roomid}/{name}")
    public Room leaveRoom(@PathVariable(value = "name") String name,@PathVariable(value = "roomid") long roomid) {
        service.leaveRoom(name,roomid);
        return service.getRoom(roomid);
    }


}
