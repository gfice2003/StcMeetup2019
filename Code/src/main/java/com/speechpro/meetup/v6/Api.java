package com.speechpro.meetup.v6;

import java.util.UUID;

import static com.speechpro.meetup.JsonConverter.*;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public class Api {
    private final Communicator communicator;
    private final String       source;

    public Api(Communicator communicator, String source) {
        this.communicator = communicator;
        this.source = source;
    }

    protected <D, R> R send(String messageType, D data, String... points) {
        Message request = createMessage(points); //-- id, source, path

        request.header.isOneWay = false;
        request.header.type = messageType;

        request.data.type = data.getClass().getName();
        request.data.json = toJson(data);

        Message response  = communicator.send(request);
        Class   dataClass = classForName(response.data.type);

        return (R) fromJson(response.data.json, dataClass);
    }

    private Message createMessage(String... points) {
        Message result = new Message();

        result.header.id = UUID.randomUUID();
        result.header.source = source;
        result.header.path = createPath(points);

        return result;
    }

    private Path createPath(String... points) {
        //-- Path creation logic here
        return null;
    }
}
