package com.aygxy.security;



import org.springframework.security.core.AuthenticationException;

/**
 * @author
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
