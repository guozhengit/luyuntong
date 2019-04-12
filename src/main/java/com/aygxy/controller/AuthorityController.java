package com.aygxy.controller;

import com.alibaba.fastjson.JSON;
import com.aygxy.service.UserService;
import com.aygxy.base.Result;
import com.aygxy.jpa.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


/**
 * @Description: 用户控制类
 * @Author: xmf
 * @Date: 2019/4/8-0:07
 */
@RestController
@Api(value = "权限管理")
@RequestMapping("/auth")
public class AuthorityController {
    private static Logger logger = LoggerFactory.getLogger(AuthorityController.class);


}
