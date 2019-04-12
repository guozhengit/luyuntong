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
@Api(value = "部门管理")
@RequestMapping("/dpt")
public class DepartmentController {
    private static Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加用户", notes = "根据User对象创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id(必填)", required = true, dataType = "String"),
            @ApiImplicitParam(name = "name", value = "用户账号(必填)", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码(必填)", required = true, dataType = "String")})
    @PostMapping()
    public Result addUser(@RequestBody User user) {
        logger.info("user.add parameter is [{}]",JSON.toJSON(user));

        return userService.addByOne(user);
    }

    @ApiOperation(value = "删除用户", notes = "通过id删除用户")
    @ApiImplicitParam(name = "uid", value = "用户id(必填)", required = true, dataType = "String")
    @DeleteMapping("/{uid}")
    public Result deleteUser(@PathVariable String  uid) {
        logger.info("user.delete parameter is [{}]",JSON.toJSON(uid));
        return userService.queryById(uid);
    }

    @ApiOperation(value = "修改用户", notes = "通过id修改用户")
    @ApiImplicitParam(name = "uid", value = "用户id(必填)", required = true, dataType = "String")
    @PutMapping("/{uid}")
    public Result updateUser(@PathVariable String uid, @RequestBody User user) {
        logger.info("user.update parameter is [{}]",JSON.toJSON(user));
        return userService.update(uid, user);
    }

    @ApiOperation(value = "通过id查询用户", notes = "通过id添加用户")
    @GetMapping(value = "/{uid}")
    public Result queryUser(@PathVariable String uid) {
        logger.info("user.add parameter is [{}]",JSON.toJSON(uid));
        return  userService.queryById(uid);
    }

    @ApiOperation(value = "查询用户", notes = "分页查询部分用户")
    @GetMapping()
    public Result pageUser(@PageableDefault(value = 10, sort = {"createTime"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return userService.findAllUserDto(pageable);
    }


    @ApiOperation(value = "查询用户", notes = "分页查询部分用户")
    @PostMapping("/pageQuery")
    public Result pageUser(@PageableDefault(value = 10, sort = {"createTime"}, direction = Sort.Direction.ASC) Pageable pageable,@RequestBody User user) {
        return userService.dynamicQueryUser(pageable,user);
    }



}
