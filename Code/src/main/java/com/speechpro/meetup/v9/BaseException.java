package com.speechpro.meetup.v9;

/**
 * Author : moshkov
 * Date   : 25/11/2019
 */
public class BaseException extends RuntimeException {

    public final ErrorCode errorCode;
    public final String    reason;

    public BaseException(ErrorCode errorCode, String reason, String message) {
        super(message);

        this.errorCode = errorCode;
        this.reason = reason;
    }
}
