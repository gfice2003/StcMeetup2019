package com.speechpro.meetup;

/**
 * Author : Alex Moshkov
 * Date   : 21.11.2019
 */
public class JsonConverter {
    public static <T> String toJson(T instance) {
        return "json";
    }

    public static <T> T fromJson(String json, Class<T> instanceClass) {
        return null;
    }

    public static byte[] jsonToBytes(String json) {
        return null;
    }

    public static Class classForName(String className) {
        return null;
    }
}
