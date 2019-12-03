package com.speechpro.meetup.v5;

import static com.speechpro.meetup.JsonConverter.classForName;
import static com.speechpro.meetup.JsonConverter.fromJson;
import static com.speechpro.meetup.JsonConverter.toJson;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public abstract class BaseHandler<D, R> extends Handler {

    @Override
    public Message handle(Message message) {
        Class<D> type   = classForName(message.data.type);
        D        data   = fromJson(message.data.json, type);
        R        result = processData(data);

        message.data.type = result.getClass().getName();
        message.data.json = toJson(result);

        return message;
    }

    protected abstract R processData(D data);
}

