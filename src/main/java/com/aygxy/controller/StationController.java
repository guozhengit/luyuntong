package com.aygxy.controller;

import com.alibaba.fastjson.JSON;
import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Station;
import com.aygxy.service.StationService;
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
 * @Description: 站点管理控制类
 * @Author: xmf
 * @Date: 2019/4/8-0:07
 */
@RestController
@Api(value = "站点管理")
@RequestMapping("/station")
public class StationController {
    private static Logger logger = LoggerFactory.getLogger(StationController.class);
    
    @Autowired
    StationService stationService;
    
    @ApiOperation(value = "添加站点信息")
    @PostMapping()
    public Result addStation(@RequestBody Station station) {
        logger.info("station.add parameter is [{}]",JSON.toJSON(station));
        return stationService.add(station);
    }

    @ApiOperation(value = "删除站点信息", notes = "通过id删除用户")
    @DeleteMapping("/{id}")
    public Result deleteStation(@PathVariable String  id) {
        logger.info("station.delete parameter is [{}]",JSON.toJSON(id));
        return stationService.delete(id);
    }


    @ApiOperation(value = "编辑站点信息", notes = "通过id编辑站点")
    @PutMapping("/{id}")
    public Result updateStation(@PathVariable String id, @RequestBody Station station) {
        logger.info("station.update parameter is [{}]",JSON.toJSON(station));
        return stationService.update(id, station);
    }

    @ApiOperation(value = "查询站点", notes = "分页动态查询站点信息")
    @PostMapping("/pageQuery")
    public Result pageStation(@PageableDefault(value = 10, sort = {"createTime"}, direction = Sort.Direction.DESC) Pageable pageable,@RequestBody Station station) {
        return stationService.dynamicQuery(pageable,station);
    }
}
