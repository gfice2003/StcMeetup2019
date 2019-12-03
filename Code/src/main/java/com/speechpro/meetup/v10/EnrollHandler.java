package com.speechpro.meetup.v10;

import com.speechpro.meetup.Model;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public class EnrollHandler extends BaseHandler<byte[], Model> {

    public EnrollHandler(ITcpDataHub dataHub) {
        super(dataHub);
    }

    @Override
    protected String getStep() {
        return "PROCESS";
    }

    @Override
    protected Model processData(byte[] image) {
        return imageToModel(image);
    }

    private Model imageToModel(byte[] image) {
        //-- Image to model transformation logic here
        return null;
    }
}


