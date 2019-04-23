package com.aygxy.controller;

import com.alibaba.fastjson.JSON;
import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Route;
import com.aygxy.service.RouteService;
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
 * @Description: 路线管理控制类
 * @Author: xmf
 * @Date: 2019/4/8-0:07
 */
@RestController
@Api(value = "路线管理")
@RequestMapping("/route")
public class RouteController {
    private static Logger logger = LoggerFactory.getLogger(RouteController.class);
    @Autowired
    RouteService routeService;
    
    @ApiOperation(value = "添加路线信息")
    @PostMapping()
    public Result addRoute(@RequestBody Route route) {
        logger.info("route.add parameter is [{}]",JSON.toJSON(route));
        return routeService.add(route);
    }

    @ApiOperation(value = "删除路线信息", notes = "通过id删除用户")
    @DeleteMapping("/{id}")
    public Result deleteRoute(@PathVariable String  id) {
        logger.info("route.delete parameter is [{}]",JSON.toJSON(id));
        return routeService.delete(id);
    }


    @ApiOperation(value = "编辑路线信息", notes = "通过id编辑路线")
    @PutMapping("/{id}")
    public Result updateRoute(@PathVariable String id, @RequestBody Route route) {
        logger.info("route.update parameter is [{}]",JSON.toJSON(route));
        return routeService.update(id, route);
    }

    @ApiOperation(value = "查询路线", notes = "分页动态查询路线信息")
    @PostMapping("/pageQuery")
    public Result pageRoute(@PageableDefault(value = 10, sort = {"createTime"}, direction = Sort.Direction.DESC) Pageable pageable,@RequestBody Route route) {
        return routeService.dynamicQuery(pageable,route);
    }

}
