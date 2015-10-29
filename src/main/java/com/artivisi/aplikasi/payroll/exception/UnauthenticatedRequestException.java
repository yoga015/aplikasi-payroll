package com.artivisi.aplikasi.payroll.exception;

public class UnauthenticatedRequestException extends RuntimeException {

    public UnauthenticatedRequestException() {
    }

    public UnauthenticatedRequestException(String message) {
        super(message);
    }

    public UnauthenticatedRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnauthenticatedRequestException(Throwable cause) {
        super(cause);
    }

    public UnauthenticatedRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
    
}
