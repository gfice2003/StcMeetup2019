package com.speechpro.meetup.v5;

import com.speechpro.meetup.Model;

import static com.speechpro.meetup.JsonConverter.jsonToBytes;
import static com.speechpro.meetup.JsonConverter.toJson;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public class EnrollHandler extends BaseHandler<byte[], Model> {

    @Override
    protected Model processData(byte[] image) {
        return imageToModel(image);
    }

    private Model imageToModel(byte[] image) {
        //-- Image to model transformation logic here
        return null;
    }
}


