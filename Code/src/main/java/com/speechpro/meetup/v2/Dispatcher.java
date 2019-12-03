package com.speechpro.meetup.v2;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public class Dispatcher implements IReceiver {

    private final Map<String, Handler> handlers = Maps.newHashMap();
    private final ExecutorService      executor = Executors.newFixedThreadPool(10);

    @Override
    public void receive(Message message) {
        String  messageType = message.header.type;
        Handler handler     = handlers.get(messageType);

        executor.submit(() -> handler.receive(message));
    }

    public void register(String messageType, Handler handler) {
        handlers.put(messageType, handler);
    }
}

