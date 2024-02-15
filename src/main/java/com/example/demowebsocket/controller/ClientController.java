package com.example.demowebsocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/chat")
    public String chat() {
        return "chat";
    }

    @RequestMapping("/app")
    public String app() {
        return "app";
    }
}
