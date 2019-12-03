package com.speechpro.meetup.v6;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public class PathPoint {
    public final String  queue;
    public       boolean visited;

    public PathPoint(String queue) {
        this.queue = queue;
        this.visited = false;
    }
}
