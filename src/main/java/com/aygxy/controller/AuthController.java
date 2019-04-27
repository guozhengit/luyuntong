package com.aygxy.controller;

import com.aygxy.base.PhysicalConstants;
import com.aygxy.base.Result;
import com.aygxy.exception.BusinessException;
import com.aygxy.util.HttpUtil;
import com.aygxy.util.captcha.Captcha;
import com.aygxy.util.captcha.SpecCaptcha;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;


/**
 * @Description: 验证码
 * @Author: xmf
 * @Date: 2019/4/8-0:07
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private static Logger logger = LoggerFactory.getLogger(AuthController.class);

    /**
     * Session中验证码字段名称
     */
    private final static String SESSION_VALIDATE_CODE = "SpringSecurityCaptcha";

    @GetMapping
    public void showAuthPage(HttpServletResponse response){
        HttpUtil.responseAsJson(response, new Result(PhysicalConstants.AUTH_ERROR,"用户未登录"));
    }

    @GetMapping("captcha")
    public String getGifCode(@RequestParam(defaultValue = "120") Integer width,
                             @RequestParam(defaultValue = "32") Integer height,
                             @RequestParam(defaultValue = "4") Integer length,
                             HttpServletRequest request){
        HttpSession session = request.getSession();
        Captcha captcha = new SpecCaptcha(width, height, length);
        String base64Captcha;
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            captcha.out(outputStream);
            outputStream.toByteArray();
            base64Captcha = Base64.getEncoder().encodeToString(outputStream.toByteArray());
            String text = captcha.text();
            session.setAttribute(SESSION_VALIDATE_CODE, text);
            logger.debug("生成验证码：{}", text);
        } catch (IOException e) {
            throw new BusinessException(e);
        }
        return base64Captcha;
    }

}
