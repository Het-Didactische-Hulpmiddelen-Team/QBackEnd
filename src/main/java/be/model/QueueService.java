package be.model;


import be.db.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class QueueService {

    String key = "qwerty";
    boolean authenticated = false;

    AtomicInteger priority = new AtomicInteger();
    @Autowired
    private QueueRepository queueRepository;

    public QueueService() {

    }

}
