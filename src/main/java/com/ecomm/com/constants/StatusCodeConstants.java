package com.ecomm.com.constants;

import org.springframework.http.HttpStatus;

public class StatusCodeConstants {
    private StatusCodeConstants(){}
    public static final HttpStatus STATUS_SUCCESS = HttpStatus.OK;
    public static final HttpStatus STATUS_CREATED = HttpStatus.CREATED;
    public static final HttpStatus STATUS_BAD_REQUEST = HttpStatus.BAD_REQUEST;
    public static final HttpStatus STATUS_NOT_FOUND = HttpStatus.NOT_FOUND;
    public static final HttpStatus STATUS_UNAUTHORIZED = HttpStatus.UNAUTHORIZED;
    public static final HttpStatus STATUS_INTERNAL_ERROR = HttpStatus.INTERNAL_SERVER_ERROR;
}
