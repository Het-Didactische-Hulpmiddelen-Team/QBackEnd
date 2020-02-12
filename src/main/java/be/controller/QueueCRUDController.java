package be.controller;

import be.model.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class QueueCRUDController {
    @Autowired
    QueueService service;

    public QueueCRUDController() {

    }


}
