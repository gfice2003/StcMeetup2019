package com.speechpro.meetup.v10;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public class SecurityHandler extends Handler {

    protected String getStep() {
        return "SECURITY";
    }

    public Message handle(Message message) {
        if (checkPrivilege(message.header)) {
            return message;
        } else throw new SecurityException();
    }

    private boolean checkPrivilege(MessageHeader header) {
        //-- Privilege check logic here
        return false;
    }
}

