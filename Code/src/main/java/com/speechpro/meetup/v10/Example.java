package com.speechpro.meetup.v10;

import com.speechpro.meetup.Model;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public class Example {

    public Model enroll(Communicator communicator, ITcpDataHub dataHub, byte[] image) {
        ProcessorApi api   = new ProcessorApi(communicator, dataHub,"API_QUEUE");
        Model        model = api.enroll(image);

        return model;
    }
}
