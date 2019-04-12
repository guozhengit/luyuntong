package com.aygxy.base;

import com.alibaba.fastjson.JSON;
import com.aygxy.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


/**
 * @Description: 全局异常处理
 * @Author: Guoyongzheng
 * @Date: 2019/4/9-22:03
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private static final String UNKNOWN_MESSAGE = "未知错误";
    private static final String UNKNOWN_CODE = "-1";

    /**
     * 全局异常处理
     *
     * @param exception 异常信息
     * @param request 请求
     * @param response 响应
     * @return Result
     */
    @ResponseBody
    @ExceptionHandler
    public Result exceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) {
        Result<String> result = new Result<>();
        result.setCode(UNKNOWN_CODE);
        result.setPath(request.getRequestURI());
        result.setTimestamp(new Date());
        if (exception instanceof BusinessException) {
            result.setMessage(exception.getMessage());
        } else {
            LOGGER.error("Unknown Exception: ", exception);
            result.setMessage(UNKNOWN_MESSAGE);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        LOGGER.debug("custom exception is [{}]",JSON.toJSON(result));
        return result;
    }

}
