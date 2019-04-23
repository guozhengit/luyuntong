package com.aygxy.controller;

import com.alibaba.fastjson.JSON;
import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Driver;
import com.aygxy.service.DriverService;
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
 * @Description: 司机管理控制类
 * @Author: xmf
 * @Date: 2019/4/8-0:07
 */
@RestController
@Api(value = "司机管理")
@RequestMapping("/driver")
public class DriverController {
    private static Logger logger = LoggerFactory.getLogger(DriverController.class);

    @Autowired
    DriverService driverService;
    
    @ApiOperation(value = "添加司机信息")
    @PostMapping()
    public Result addDriver(@RequestBody Driver driver) {
        logger.info("driver.add parameter is [{}]",JSON.toJSON(driver));
        return driverService.add(driver);
    }

    @ApiOperation(value = "删除司机信息", notes = "通过id删除用户")
    @DeleteMapping("/{id}")
    public Result deleteDriver(@PathVariable String  id) {
        logger.info("driver.delete parameter is [{}]",JSON.toJSON(id));
        return driverService.delete(id);
    }


    @ApiOperation(value = "编辑司机信息", notes = "通过id编辑司机")
    @PutMapping("/{id}")
    public Result updateDriver(@PathVariable String id, @RequestBody Driver driver) {
        logger.info("driver.update parameter is [{}]",JSON.toJSON(driver));
        return driverService.update(id, driver);
    }

    @ApiOperation(value = "查询司机", notes = "分页动态查询司机信息")
    @PostMapping("/pageQuery")
    public Result pageDriver(@PageableDefault(value = 10, sort = {"createTime"}, direction = Sort.Direction.DESC) Pageable pageable, @RequestBody Driver driver) {
        return driverService.dynamicQuery(pageable,driver);
    }



}
