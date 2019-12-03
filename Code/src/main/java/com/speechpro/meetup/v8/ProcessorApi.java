package com.speechpro.meetup.v8;

import com.speechpro.meetup.Model;
import com.speechpro.meetup.Score;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public class ProcessorApi extends Api {

    private final String[] steps = {"SECURITY", "PROCESS"};

    public ProcessorApi(Communicator communicator, String source) {
        super(communicator, source);
    }

    public Model enroll(byte[] image) {
        return send("ENROLL_MESSAGE", image, steps);
    }

    public Score verify(String personId, byte[] image) {
        return send("VERIFY_MESSAGE", toDto(personId, image), steps);
    }

    private Object toDto(String personId, byte[] image) {
        //-- Dto logic creation here
        return null;
    }
}
