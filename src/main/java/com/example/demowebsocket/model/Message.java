package com.example.demowebsocket.model;

import lombok.Data;

@Data
public class Message {
    private String from;
    private String to;
    private String content;
}
