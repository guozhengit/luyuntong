package com.aygxy.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author
 */
public class SimpleAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public SimpleAuthenticationFilter() {
        super.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/auth/login", "POST"));
    }

    /**
     * 是否开启验证码功能
     */
    private boolean openValidateCode = true;

    /**
     * Request中验证码字段名称
     */
    private final static String REQUEST_VALIDATE_CODE = "captcha";

    /**
     * Session中验证码字段名称
     */
    private final static String SESSION_VALIDATE_CODE = "SpringSecurityCaptcha";

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (openValidateCode) {
            checkValidateCode(request);
        }
        return super.attemptAuthentication(request, response);
    }

    private void checkValidateCode(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionValidateCode = obtainSessionValidateCode(session);
        session.setAttribute(SESSION_VALIDATE_CODE, null);
        String requestValidateCode = obtainValidateCodeParameter(request);
        if (StringUtils.isEmpty(requestValidateCode) || !sessionValidateCode.equalsIgnoreCase(requestValidateCode)) {
            throw new ValidateCodeException("验证码错误");
        }
    }

    private String obtainValidateCodeParameter(HttpServletRequest request) {
        Object obj = request.getParameter(REQUEST_VALIDATE_CODE);
        return null == obj ? "" : obj.toString();
    }

    private String obtainSessionValidateCode(HttpSession session) {
        Object obj = session.getAttribute(SESSION_VALIDATE_CODE);
        return null == obj ? "" : obj.toString();
    }

    public void setOpenValidateCode(boolean openValidateCode) {
        this.openValidateCode = openValidateCode;
    }
}
