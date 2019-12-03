package com.speechpro.meetup.v6;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.SettableFuture;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public class Communicator implements IReceiver {

    private final ITransport transport;
    private final Dispatcher dispatcher;

    private final Map<UUID, SettableFuture<Message>> awaitingResponse = Maps.newConcurrentMap();

    public Communicator(ITransport transport, Dispatcher dispatcher) {
        this.transport = transport;
        this.dispatcher = dispatcher;
    }

    public Message send(Message message) {
        SettableFuture<Message> future = SettableFuture.create();

        awaitingResponse.put(message.header.id, future);
        transport.post(message);

        return getMessage(future);
    }

    private Message getMessage(SettableFuture<Message> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    public void receive(Message message) {
        if (awaitingResponse.containsKey(message.header.id)) {
            awaitingResponse.get(message.header.id).set(message);
        } else {
            dispatcher.receive(message);
        }
    }
}
