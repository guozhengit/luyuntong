package com.aygxy.controller;

import com.alibaba.fastjson.JSON;
import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Bill;
import com.aygxy.service.BillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
 * @Description: 单据管理控制类
 * @Author: xmf
 * @Date: 2019/4/8-0:07
 */
@RestController
@Api(value = "单据管理")
@RequestMapping("/bill")
public class BillController {
    private static Logger logger = LoggerFactory.getLogger(BillController.class);
    @Autowired
    BillService billService;

    @ApiOperation(value = "添加单据信息")
    @PostMapping()
    public Result addBill(@RequestBody Bill bill) {
        logger.info("bill.add parameter is [{}]",JSON.toJSON(bill));
        return billService.add(bill);
    }

    @ApiOperation(value = "删除单据信息", notes = "通过id删除用户")
    @DeleteMapping("/{id}")
    public Result deleteBill(@PathVariable String  id) {
        logger.info("bill.delete parameter is [{}]",JSON.toJSON(id));
        return billService.delete(id);
    }

    @ApiOperation(value = "删除单据信息", notes = "批量删除")
    @ApiImplicitParam(name = "bid", required = true, dataType = "String[]")
    @PostMapping("/deleteBatch")
    public Result deleteUser(@RequestBody List<String> ids) {
        logger.info("driver.delete parameter is [{}]",JSON.toJSON(ids));
        return billService.deleteBatch(ids);
    }

    @ApiOperation(value = "编辑单据信息", notes = "通过id编辑单据")
    @PutMapping("/{id}")
    public Result updateBill(@PathVariable String id, @RequestBody Bill bill) {
        logger.info("bill.update parameter is [{}]",JSON.toJSON(bill));
        return billService.update(id, bill);
    }

    @ApiOperation(value = "查询单据", notes = "分页动态查询单据信息")
    @PostMapping("/pageQuery")
    public Result pageBill(@PageableDefault(direction = Sort.Direction.DESC) Pageable pageable, @RequestBody Bill bill) {
        return billService.dynamicQuery(pageable,bill);
    }

}
