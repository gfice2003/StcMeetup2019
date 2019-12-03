package com.speechpro.meetup.v5;

import java.util.UUID;

import static com.speechpro.meetup.JsonConverter.*;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public class Api {
    private final Communicator communicator;
    private final String       source;
    private final String       destination;

    public Api(Communicator communicator, String source, String destination) {
        this.communicator = communicator;
        this.source = source;
        this.destination = destination;
    }

    protected <D, R> R send(String messageType, D data) {
        Message request = createMessage(); //-- id, source, destination

        request.header.isOneWay = false;
        request.header.type = messageType;

        request.data.type = data.getClass().getName();
        request.data.json = toJson(data);

        Message response  = communicator.send(request);
        Class   dataClass = classForName(response.data.type);

        return (R) fromJson(response.data.json, dataClass);
    }

    private Message createMessage() {
        Message result = new Message();

        result.header.id = UUID.randomUUID();
        result.header.source = source;
        result.header.destination = destination;

        return result;
    }
}
