package com.aygxy.controller;

import com.alibaba.fastjson.JSON;
import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Authority;
import com.aygxy.service.AuthorityService;
import io.swagger.annotations.Api;
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
    @Autowired
    AuthorityService authorityService;

    @ApiOperation(value = "添加权限信息")
    @PostMapping()
    public Result addAuthority(@RequestBody Authority authority) {
        logger.info("authority.add parameter is [{}]",JSON.toJSON(authority));
        return authorityService.add(authority);
    }

    @ApiOperation(value = "删除权限信息", notes = "通过id删除用户")
    @DeleteMapping("/{id}")
    public Result deleteAuthority(@PathVariable String  id) {
        logger.info("authority.delete parameter is [{}]",JSON.toJSON(id));
        return authorityService.delete(id);
    }


    @ApiOperation(value = "编辑权限信息", notes = "通过id编辑权限")
    @PutMapping("/{id}")
    public Result updateAuthority(@PathVariable String id, @RequestBody Authority authority) {
        logger.info("authority.update parameter is [{}]",JSON.toJSON(authority));
        return authorityService.update(id, authority);
    }

    @ApiOperation(value = "查询权限", notes = "分页动态查询权限信息")
    @PostMapping("/pageQuery")
    public Result pageAuthority(@PageableDefault(value = 10, sort = {"createTime"}, direction = Sort.Direction.DESC) Pageable pageable, @RequestBody Authority authority) {
        return authorityService.dynamicQuery(pageable,authority);
    }


}
