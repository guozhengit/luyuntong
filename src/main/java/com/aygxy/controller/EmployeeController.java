package com.aygxy.controller;

import com.alibaba.fastjson.JSON;
import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Employee;
import com.aygxy.service.EmployeeService;
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
 * @Description: 职员管理控制类
 * @Author: xmf
 * @Date: 2019/4/8-0:07
 */
@RestController
@Api(value = "职员管理")
@RequestMapping("/emp")
public class EmployeeController {
    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @ApiOperation(value = "添加职工信息")
    @PostMapping()
    public Result addEmployee(@RequestBody Employee employee) {
        logger.info("employee.add parameter is [{}]",JSON.toJSON(employee));
        return employeeService.add(employee);
    }

    @ApiOperation(value = "删除职工信息", notes = "通过id删除用户")
    @DeleteMapping("/{id}")
    public Result deleteEmployee(@PathVariable String  id) {
        logger.info("employee.delete parameter is [{}]",JSON.toJSON(id));
        return employeeService.delete(id);
    }


    @ApiOperation(value = "编辑职工信息", notes = "通过id编辑职工")
    @PutMapping("/{id}")
    public Result updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        logger.info("employee.update parameter is [{}]",JSON.toJSON(employee));
        return employeeService.update(id, employee);
    }

    @ApiOperation(value = "查询职工", notes = "分页动态查询职工信息")
    @PostMapping("/pageQuery")
    public Result pageEmployee(@PageableDefault(value = 10, sort = {"createTime"}, direction = Sort.Direction.DESC) Pageable pageable, @RequestBody Employee employee) {
        return employeeService.dynamicQuery(pageable,employee);
    }

}
