package com.aygxy.controller;

import com.alibaba.fastjson.JSON;
import com.aygxy.base.Result;
import com.aygxy.jpa.entity.City;
import com.aygxy.service.CityService;
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
 * @Description: 城市管理控制类
 * @Author: xmf
 * @Date: 2019/4/8-0:07
 */
@RestController
@Api(value = "城市管理")
@RequestMapping("/city")
public class CityController {
    private static Logger logger = LoggerFactory.getLogger(CityController.class);
    @Autowired
    CityService cityService;

    @ApiOperation(value = "添加城市信息")
    @PostMapping()
    public Result addCity(@RequestBody City city) {
        logger.info("city.add parameter is [{}]",JSON.toJSON(city));
        return cityService.add(city);
    }

    @ApiOperation(value = "删除城市信息", notes = "通过id删除用户")
    @DeleteMapping("/{id}")
    public Result deleteCity(@PathVariable String  id) {
        logger.info("city.delete parameter is [{}]",JSON.toJSON(id));
        return cityService.delete(id);
    }


    @ApiOperation(value = "编辑城市信息", notes = "通过id编辑城市")
    @PutMapping("/{id}")
    public Result updateCity(@PathVariable String id, @RequestBody City city) {
        logger.info("city.update parameter is [{}]",JSON.toJSON(city));
        return cityService.update(id, city);
    }

    @ApiOperation(value = "查询城市", notes = "分页动态查询城市信息")
    @PostMapping("/pageQuery")
    public Result pageCity(@PageableDefault(value = 10, sort = {"createTime"}, direction = Sort.Direction.DESC) Pageable pageable, @RequestBody City city) {
        return cityService.dynamicQuery(pageable,city);
    }

}
