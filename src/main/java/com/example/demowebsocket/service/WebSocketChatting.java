package com.example.demowebsocket.service;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * https://ssjeong.tistory.com/entry/JAVA-Spring-Boot%EC%97%90%EC%84%9C-WebSocket-%EA%B5%AC%EC%B6%95-%EB%B0%8F-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0
 */
@Log4j2
@ServerEndpoint(value = "/web-socket-chat")
@Service
public class WebSocketChatting {
    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void onOpen(Session session) {
        log.info(session.toString());

        if (clients.contains(session)) {
            log.info("이미 연결된 세션입니다. > {}", session);
        } else {
            clients.add(session);
            log.info("새로운 세션입니다. > {}", session);
        }
    }

    @OnClose
    public void onClose(Session session) throws Exception {
        clients.remove(session);
        log.info("세션을 닫습니다. : {}", session);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws Exception {
        log.info("입력된 메세지입니다. > {}", message);

        for (Session client : clients) {
            log.info("메세지를 전달합니다. > {}", message);
            client.getBasicRemote().sendText(message);
        }
    }
}
