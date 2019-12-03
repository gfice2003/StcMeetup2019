package com.speechpro.meetup.v6;

import com.speechpro.meetup.Model;

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


