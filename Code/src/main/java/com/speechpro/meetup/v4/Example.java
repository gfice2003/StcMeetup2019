package com.speechpro.meetup.v4;

import com.speechpro.meetup.Model;

import java.util.UUID;

import static com.speechpro.meetup.JsonConverter.*;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public class Example {

    public Model enroll(Communicator communicator, byte[] image) {
        ProcessorApi api   = new ProcessorApi(communicator,"API_QUEUE");
        Model        model = api.enroll(image);

        return model;
    }
}
