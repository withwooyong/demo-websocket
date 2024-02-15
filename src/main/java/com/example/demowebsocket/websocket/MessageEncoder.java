package com.example.demowebsocket.websocket;

import com.example.demowebsocket.model.Message;
import com.google.gson.Gson;
import jakarta.websocket.Encoder;
import jakarta.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<Message> {
    private static Gson gson = new Gson();

    @Override
    public String encode(Message object) {
        return gson.toJson(object);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        Text.super.init(endpointConfig);
    }

    @Override
    public void destroy() {
        Text.super.destroy();
    }
}
