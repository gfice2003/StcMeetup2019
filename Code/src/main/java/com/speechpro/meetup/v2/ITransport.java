package com.speechpro.meetup.v2;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public interface ITransport {

    void post(Message message);

    void register(IReceiver receiver);
}
