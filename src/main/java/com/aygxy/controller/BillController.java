package com.aygxy.controller;

import com.alibaba.fastjson.JSON;
import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Bill;
import com.aygxy.service.BillService;
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
 * @Description: 订单管理控制类
 * @Author: xmf
 * @Date: 2019/4/8-0:07
 */
@RestController
@Api(value = "订单管理")
@RequestMapping("/bill")
public class BillController {
    private static Logger logger = LoggerFactory.getLogger(BillController.class);
    @Autowired
    BillService billService;

    @ApiOperation(value = "添加订单信息")
    @PostMapping()
    public Result addBill(@RequestBody Bill bill) {
        logger.info("bill.add parameter is [{}]",JSON.toJSON(bill));
        return billService.add(bill);
    }

    @ApiOperation(value = "删除订单信息", notes = "通过id删除用户")
    @DeleteMapping("/{id}")
    public Result deleteBill(@PathVariable String  id) {
        logger.info("bill.delete parameter is [{}]",JSON.toJSON(id));
        return billService.delete(id);
    }


    @ApiOperation(value = "编辑订单信息", notes = "通过id编辑订单")
    @PutMapping("/{id}")
    public Result updateBill(@PathVariable String id, @RequestBody Bill bill) {
        logger.info("bill.update parameter is [{}]",JSON.toJSON(bill));
        return billService.update(id, bill);
    }

    @ApiOperation(value = "查询订单", notes = "分页动态查询订单信息")
    @PostMapping("/pageQuery")
    public Result pageBill(@PageableDefault(value = 10, sort = {"createTime"}, direction = Sort.Direction.DESC) Pageable pageable, @RequestBody Bill bill) {
        return billService.dynamicQuery(pageable,bill);
    }

}
