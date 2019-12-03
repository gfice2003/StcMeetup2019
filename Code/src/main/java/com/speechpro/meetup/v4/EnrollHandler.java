package com.speechpro.meetup.v4;

import com.speechpro.meetup.Model;

import static com.speechpro.meetup.JsonConverter.jsonToBytes;
import static com.speechpro.meetup.JsonConverter.toJson;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public class EnrollHandler extends Handler {

    @Override
    public Message handle(Message message) {
        byte[] image = jsonToBytes(message.data.json);
        Model  model = imageToModel(image);

        message.data.type = model.getClass().getName();
        message.data.json = toJson(model);

        return message;
    }

    private Model imageToModel(byte[] image) {
        //-- Image to model transformation logic here
        return null;
    }
}


