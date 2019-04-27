package com.aygxy.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description: TODO
 * @Author: Guoyongzheng
 * @Date: 2019/4/27-20:03
 */
public class Test {

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
        System.out.println(encode.length());
    }
}
