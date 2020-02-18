package be.controller;

import be.model.QService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class QController extends AbstractWebSocketHandler {

    @Autowired
    private QService service;

    private static final Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        System.out.println("New Text Message Received");
        if(message.getPayload().equals("open")){
            sessions.add(session);
        }
        if(message.getPayload().contains("-")){
            String[] messageDecoded = message.getPayload().split("-");
            String name = messageDecoded[0];
            long id = Long.parseLong(messageDecoded[1]);
            String action =  messageDecoded[2];

            if(action.equals("join")){
                service.joinRoom(name, id);
            }else if(action.equals("leave")){
                service.leaveRoom(name, id);
            }

            sendMessageToAll(new TextMessage(service.getQueue(id).toString() + "-" + id + "-" + service.getPosition(name,id)));
        }
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws IOException {
        System.out.println("New Binary Message Received");
        session.sendMessage(message);
    }

    private void sendMessageToAll(TextMessage message) {
        System.out.println(message);
        for (WebSocketSession session : sessions) {
            try {
                if(session.isOpen()){
                    session.sendMessage(message);
                }
            } catch (IOException ex) {
                try {
                    session.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}