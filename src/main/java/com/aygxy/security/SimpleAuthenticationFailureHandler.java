package com.aygxy.security;



import com.aygxy.base.PhysicalConstants;
import com.aygxy.base.Result;
import com.aygxy.util.HttpUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author
 */
public class SimpleAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (HttpUtil.isAjaxRequest(request)) {
            String exName = exception.getClass().getSimpleName();
            String message;
            switch (exName){
                case "ValidateCodeException": {
                    message = "验证码错误";
                    break;
                }
                case "UsernameNotFoundException": {
                    message = "用户不存在";
                    break;
                }
                case "BadCredentialsException": {
                    message = "用户名或密码错误";
                    break;
                }
                case "AuthenticationException": {
                    message = "认证错误";
                    break;
                }
                default:{
                    message = "未知错误";
                    break;
                }
            }
            HttpUtil.responseAsJson(
                    response,
                    new Result(PhysicalConstants.AUTH_ERROR, message)
            );
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
