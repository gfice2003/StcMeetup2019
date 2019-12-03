package com.speechpro.meetup.v7;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.UUID;

import static com.speechpro.meetup.JsonConverter.*;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public class Api {
    private final Communicator communicator;
    private final String       source;

    private final Map<String, Path> paths = Maps.newConcurrentMap();

    public Api(Communicator communicator, String source) {
        this.communicator = communicator;
        this.source = source;
    }

    protected <D, R> R send(String messageType, D data, String... points) {
        Message request = createMessage(messageType, points); //-- id, source, path

        request.header.isOneWay = false;

        request.data.type = data.getClass().getName();
        request.data.json = toJson(data);

        Message response  = communicator.send(request);
        Class   dataClass = classForName(response.data.type);

        return (R) fromJson(response.data.json, dataClass);
    }

    private Message createMessage(String messageType, String... points) {
        Message result = new Message();

        result.header.id = UUID.randomUUID();
        result.header.source = source;
        result.header.path = paths.computeIfAbsent(messageType, t -> createPath(t, points));

        return result;
    }

    private Path createPath(String messageType, String... steps) {
        Message request  = createRouterMessage(messageType, steps);
        Message response = communicator.send(request);

        return extractPath(response);
    }

    private Message createRouterMessage(String messageType, String... steps) {
        //-- Router message creation logic here
        return null;
    }

    private Path extractPath(Message response) {
        //-- Path instance extraction logic here
        return null;
    }
}
