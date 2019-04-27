package com.aygxy.util;

import com.alibaba.fastjson.JSONObject;
import com.aygxy.base.Result;
import com.aygxy.exception.BusinessException;
import org.springframework.lang.NonNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author
 */
public class HttpUtil {

    private HttpUtil() {
    }

    public static void responseAsJson(HttpServletResponse response, Result result)  {
        response.setStatus(200);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            String json = JSONObject.toJSONString(result);
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            throw new BusinessException(e);
        }
    }

    public static boolean isAjaxRequest(@NonNull HttpServletRequest request){
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }
}
