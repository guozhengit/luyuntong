package com.aygxy.exception;

/**
 * @Description: 业务异常
 * @Author: xmf
 * @Date: 2019/4/9-22:09
 */
public class BusinessException extends RuntimeException {

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
