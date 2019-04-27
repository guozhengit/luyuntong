package com.aygxy.security;



import com.aygxy.base.PhysicalConstants;
import com.aygxy.base.Result;
import com.aygxy.util.HttpUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author
 */
public class SimpleAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (HttpUtil.isAjaxRequest(request)) {
            HttpUtil.responseAsJson(
                    response,
                    new Result(PhysicalConstants.AUTH_SUCCESS,"登录成功")
            );
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
