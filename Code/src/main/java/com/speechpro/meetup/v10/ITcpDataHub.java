package com.speechpro.meetup.v10;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public interface ITcpDataHub {

    TransmissionDescriptor transmit(byte[] data);

    byte[] receive(TransmissionDescriptor descriptor);
}
