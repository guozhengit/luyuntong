package com.aygxy.controller;

import com.alibaba.fastjson.JSON;
import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Customer;
import com.aygxy.service.CustomerService;
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
 * @Description: 客户管理控制类
 * @Author: xmf
 * @Date: 2019/4/8-0:07
 */
@RestController
@Api(value = "客户管理")
@RequestMapping("/custom")
public class CustomerController {
    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @ApiOperation(value = "添加客户信息")
    @PostMapping()
    public Result addCustomer(@RequestBody Customer customer) {
        logger.info("customer.add parameter is [{}]",JSON.toJSON(customer));
        return customerService.add(customer);
    }

    @ApiOperation(value = "删除客户信息", notes = "通过id删除用户")
    @DeleteMapping("/{id}")
    public Result deleteCustomer(@PathVariable String  id) {
        logger.info("customer.delete parameter is [{}]",JSON.toJSON(id));
        return customerService.delete(id);
    }

    @ApiOperation(value = "删除客户信息", notes = "批量删除")
    @ApiImplicitParam(name = "cid", required = true, dataType = "String[]")
    @PostMapping("/deleteBatch")
    public Result deleteUser(@RequestBody List<String> ids) {
        logger.info("department.delete parameter is [{}]",JSON.toJSON(ids));
        return customerService.deleteBatch(ids);
    }

    @ApiOperation(value = "编辑客户信息", notes = "通过id编辑客户")
    @PutMapping("/{id}")
    public Result updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        logger.info("customer.update parameter is [{}]",JSON.toJSON(customer));
        return customerService.update(id, customer);
    }

    @ApiOperation(value = "查询客户", notes = "分页动态查询客户信息")
    @PostMapping("/pageQuery")
    public Result pageCustomer(@PageableDefault(value = 10, sort = {"createTime"}, direction = Sort.Direction.DESC) Pageable pageable, @RequestBody Customer customer) {
        return customerService.dynamicQuery(pageable,customer);
    }

}
