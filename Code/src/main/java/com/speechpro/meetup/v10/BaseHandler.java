package com.speechpro.meetup.v10;

import static com.speechpro.meetup.JsonConverter.*;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public abstract class BaseHandler<D, R> extends Handler {

    protected final ITcpDataHub dataHub;

    public BaseHandler(ITcpDataHub dataHub) {
        this.dataHub = dataHub;
    }

    @Override
    public Message handle(Message message) {
        D data   = extractData(message.data);
        R result = processData(data);

        message.data.type = result.getClass().getName();
        message.data.json = toJson(result);

        return message;
    }

    private D extractData(MessageData messageData) {
        if (messageData.type.equals(TransmissionDescriptor.class.getName())) {
            return (D) dataHub.receive(extractDescriptor(messageData));
        } else {
            return (D) fromJson(messageData.json, classForName(messageData.type));
        }
    }

    private TransmissionDescriptor extractDescriptor(MessageData messageData) {
        //-- Descriptor extraction logic here
        return null;
    }

    protected abstract String getStep();

    protected abstract R processData(D data);
}

