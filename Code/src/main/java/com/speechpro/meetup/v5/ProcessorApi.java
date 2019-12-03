package com.speechpro.meetup.v5;

import com.speechpro.meetup.Model;
import com.speechpro.meetup.Score;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public class ProcessorApi extends Api {

    public ProcessorApi(Communicator communicator, String source) {
        super(communicator, source, "PROCESSOR_QUEUE");
    }

    public Model enroll(byte[] image) {
        return send("ENROLL_MESSAGE", image);
    }

    public Score verify(String personId, byte[] image) {
        return send("VERIFY_MESSAGE", toDto(personId, image));
    }

    private Object toDto(String personId, byte[] image) {
        //-- Verification DTO creation logic here
        return null;
    }
}
