package com.speechpro.meetup.v3;

import com.speechpro.meetup.Model;

import java.util.UUID;

import static com.speechpro.meetup.JsonConverter.classForName;
import static com.speechpro.meetup.JsonConverter.fromJson;
import static com.speechpro.meetup.JsonConverter.toJson;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public class Example {

    public Model enroll(Communicator communicator, byte[] image) {

        Message request = new Message();

        request.header.id          = UUID.randomUUID();
        request.header.destination = "PROCESSOR_QUEUE";
        request.header.isOneWay    = false;
        request.header.source      = "API_QUEUE";
        request.header.type        = "ENROLL_MESSAGE";

        request.data.type          = image.getClass().getName();
        request.data.json          = toJson(image);

        Message response  = communicator.send(request);
        Class   dataClass = classForName(response.data.type);

        return (Model)fromJson(response.data.json, dataClass);
    }

}
