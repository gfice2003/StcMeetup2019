package com.speechpro.meetup.v3;

import java.util.UUID;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public class MessageHeader {
    public UUID    id;
    public boolean isOneWay;
    public String  source;
    public String  destination;
    public String  type;
}
