package com.speechpro.meetup.v6;

import com.speechpro.meetup.Model;
import com.speechpro.meetup.Score;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public class ProcessorApi extends Api {

    private final String pQueue = "PROCESSOR_QUEUE";
    private final String sQueue = "SECURITY_QUEUE";

    public ProcessorApi(Communicator communicator, String source) {
        super(communicator, source);
    }

    public Model enroll(byte[] image) {
        return send("ENROLL_MESSAGE", image, pQueue, sQueue);
    }

    public Score verify(String personId, byte[] image) {
        return send("VERIFY_MESSAGE", toDto(personId, image), pQueue, sQueue);
    }

    private Object toDto(String personId, byte[] image) {
        //-- Verification DTO creation logic here
        return null;
    }
}
