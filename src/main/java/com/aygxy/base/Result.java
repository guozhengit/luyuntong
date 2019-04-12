package com.aygxy.base;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 统一API响应结果封装
 */
@Getter
@Setter
public class Result<T> {
    private String code;
    private Boolean success;
    private String message;
    private String origin;
    private Date timestamp;
    private String path;
    private T data;



    public Result() {
    }

    public Result(String code) {
        this.success =true;
        this.code = code;
        switch (code) {
            case PhysicalConstants.OPERATER_SUCCESS:
                this.message = PhysicalConstants.OPERATER_SUCCESS_CN;
                break;
            case PhysicalConstants.REQUE_SUCCESS:
                this.message = PhysicalConstants.REQUE_SUCCESS_CN;
                break;
            case PhysicalConstants.DELETE_SUCCESS:
                this.message = PhysicalConstants.DELETE_SUCCESS_CN;
                break;
            case PhysicalConstants.UPDATE_SUCCESS:
                this.message = PhysicalConstants.UPDATE_SUCCESS_CN;
                break;
        }
        this.timestamp = new Date();
    }

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = new Date();
    }

    public Result(String path, T data) {
        this.code = PhysicalConstants.OPERATER_SUCCESS;
        this.message = PhysicalConstants.OPERATER_SUCCESS_CN;
        this.timestamp = new Date();
        this.path = path;
        this.data = data;
    }

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.timestamp = new Date();
        this.data = data;
    }

    public Result(String code, String message, Date timestamp, String path, T data) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
        this.path = path;
        this.data = data;
    }

    public Result(String code, String message, String origin, Date timestamp, String path, T data) {
        this.code = code;
        this.message = message;
        this.origin = origin;
        this.timestamp = timestamp;
        this.path = path;
        this.data = data;
    }

    public Result(String code, Boolean success, String message, String origin, Date timestamp, String path, T data) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.origin = origin;
        this.timestamp = timestamp;
        this.path = path;
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
