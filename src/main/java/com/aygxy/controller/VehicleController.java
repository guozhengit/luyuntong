package com.aygxy.controller;

import com.alibaba.fastjson.JSON;
import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Vehicle;
import com.aygxy.service.VehicleService;
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

import java.util.List;


/**
 * @Description: 车辆控制类
 * @Author: xmf
 * @Date: 2019/4/8-0:07
 */
@RestController
@Api(value = "车辆管理")
@RequestMapping("/car")
public class VehicleController {
    private static Logger logger = LoggerFactory.getLogger(VehicleController.class);

    @Autowired
    VehicleService vehicleService;

    @ApiOperation(value = "添加车辆信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id必填", required = true, dataType = "String"),
            @ApiImplicitParam(name = "code", value = "车牌号必填", required = true, dataType = "String")})
    @PostMapping()
    public Result addVehicle(@RequestBody Vehicle vehicle) {
        logger.info("vehicle.add parameter is [{}]",JSON.toJSON(vehicle));
        return vehicleService.add(vehicle);
    }

    @ApiOperation(value = "删除车辆信息", notes = "通过id删除用户")
    @ApiImplicitParam(name = "id", value = "id必填", required = true, dataType = "String")
    @DeleteMapping("/{id}")
    public Result deleteVehicle(@PathVariable String  id) {
        logger.info("vehicle.delete parameter is [{}]",JSON.toJSON(id));
        return vehicleService.delete(id);
    }

    @ApiOperation(value = "删除车辆信息", notes = "批量删除")
    @ApiImplicitParam(name = "vid", required = true, dataType = "String[]")
    @PostMapping("/deleteBatch")
    public Result deleteUser(@RequestBody List<String> ids) {
        logger.info("vehicle.delete parameter is [{}]",JSON.toJSON(ids));
        return vehicleService.deleteBatch(ids);
    }

    @ApiOperation(value = "编辑车辆信息", notes = "通过id编辑车辆")
    @PutMapping("/{id}")
    public Result updateVehicle(@PathVariable String id, @RequestBody Vehicle vehicle) {
        logger.info("vehicle.update parameter is [{}]",JSON.toJSON(vehicle));
        return vehicleService.update(id, vehicle);
    }

    @ApiOperation(value = "查询车辆", notes = "分页动态查询车辆信息")
    @PostMapping("/pageQuery")
    public Result pageVehicle(@PageableDefault(value = 10, sort = {"createTime"}, direction = Sort.Direction.DESC) Pageable pageable,@RequestBody Vehicle vehicle) {
        return vehicleService.dynamicQuery(pageable,vehicle);
    }

}
