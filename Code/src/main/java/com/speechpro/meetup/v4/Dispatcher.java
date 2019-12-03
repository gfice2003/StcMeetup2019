package com.speechpro.meetup.v4;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public class Dispatcher implements IReceiver {

    private final ITransport transport;

    private final Map<String, Handler> handlers = Maps.newHashMap();
    private final ExecutorService      executor = Executors.newFixedThreadPool(10);

    public Dispatcher(ITransport transport) {
        this.transport = transport;
    }

    @Override
    public void receive(Message message) {
        String  messageType = message.header.type;
        Handler handler     = handlers.get(messageType);

        executor.submit(() -> handle(handler, message));
    }

    private void handle(Handler handler, Message message) {
        Message response = handler.handle(message);

        if (!message.header.isOneWay) {
            transport.post(response);
        }
    }

    public void register(String messageType, Handler handler) {
        handlers.put(messageType, handler);
    }
}

