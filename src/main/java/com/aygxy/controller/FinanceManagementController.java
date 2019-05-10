package com.aygxy.controller;

import com.alibaba.fastjson.JSON;
import com.aygxy.base.PhysicalConstants;
import com.aygxy.base.Result;
import com.aygxy.mybatis.entity.CustomerModel;
import com.aygxy.mybatis.entity.OperationModel;
import com.aygxy.mybatis.entity.ProfitModel;
import com.aygxy.mybatis.entity.SalaryMode;
import com.aygxy.service.FinanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.spring.web.json.Json;

/**
 * @Description: 财务报表管理
 * @Author: Guoyongzheng
 * @Date: 2019/5/9-0:14
 */
@Controller
@RequestMapping("/finaceManage")
public class FinanceManagementController {
    private static Logger logger = LoggerFactory.getLogger(FinanceManagementController.class);

    @Autowired
    private FinanceService financeService;

    @PostMapping("/salary")
    @ResponseBody
    public Result salaryManage(@PageableDefault(direction = Sort.Direction.DESC) Pageable pageable,@RequestBody SalaryMode salaryMode){
        logger.info("统计信息参数:[{}],[{}]",JSON.toJSON(pageable),JSON.toJSON(salaryMode));
        Page returnPage = financeService.salaryManage(pageable,salaryMode);
        return new Result(PhysicalConstants.REQUE_SUCCESS,PhysicalConstants.REQUE_SUCCESS_CN,returnPage);
    }
    @PostMapping("/operation")
    @ResponseBody
    public Result operationManage(@PageableDefault(direction = Sort.Direction.DESC) Pageable pageable,@RequestBody OperationModel operationModel){
        logger.info("统计信息参数:[{}],[{}]",JSON.toJSON(pageable),JSON.toJSON(operationModel));
        Page returnPage = financeService.operationManage(pageable,operationModel);
        return new Result(PhysicalConstants.REQUE_SUCCESS,PhysicalConstants.REQUE_SUCCESS_CN,returnPage);
    };
    /*客户管理*/
    @PostMapping("/customer")
    @ResponseBody
    public Result  customerManage (@PageableDefault(direction = Sort.Direction.DESC) Pageable pageable,@RequestBody CustomerModel customerModel){
        logger.info("统计信息参数:[{}],[{}]",JSON.toJSON(pageable),JSON.toJSON(customerModel));
        Page returnPage =  financeService.customerManage(pageable,customerModel);
        return new Result(PhysicalConstants.REQUE_SUCCESS,PhysicalConstants.REQUE_SUCCESS_CN,returnPage);
    };
    /*盈利统计*/
    @PostMapping("/profit")
    @ResponseBody
    public Result profitManage (@PageableDefault(direction = Sort.Direction.DESC) Pageable pageable, @RequestBody ProfitModel profitModel){
        logger.info("统计信息参数:[{}],[{}]",JSON.toJSON(pageable),JSON.toJSON(profitModel));
        Page returnPage = financeService.profitManage(pageable,profitModel);
        return new Result(PhysicalConstants.REQUE_SUCCESS,PhysicalConstants.REQUE_SUCCESS_CN,returnPage);
    };
}
