package com.aygxy.controller;

import com.alibaba.fastjson.JSON;
import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Department;
import com.aygxy.service.DepartmentService;
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
 * @Description: 部门管理控制类
 * @Author: xmf
 * @Date: 2019/4/8-0:07
 */
@RestController
@Api(value = "部门管理")
@RequestMapping("/dpt")
public class DepartmentController {
    private static Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    DepartmentService departmentService;

    @ApiOperation(value = "添加部门信息")
    @PostMapping()
    public Result addDepartment(@RequestBody Department department) {
        logger.info("department.add parameter is [{}]",JSON.toJSON(department));
        return departmentService.add(department);
    }

    @ApiOperation(value = "删除部门信息", notes = "通过id删除用户")
    @DeleteMapping("/{id}")
    public Result deleteDepartment(@PathVariable String  id) {
        logger.info("department.delete parameter is [{}]",JSON.toJSON(id));
        return departmentService.delete(id);
    }

    @ApiOperation(value = "删除部门信息", notes = "批量删除")
    @ApiImplicitParam(name = "dgid", required = true, dataType = "String[]")
    @PostMapping("/deleteBatch")
    public Result deleteUser(@RequestBody List<String> ids) {
        logger.info("department.delete parameter is [{}]",JSON.toJSON(ids));
        return departmentService.deleteBatch(ids);
    }

    @ApiOperation(value = "编辑部门信息", notes = "通过id编辑部门")
    @PutMapping("/{id}")
    public Result updateDepartment(@PathVariable String id, @RequestBody Department department) {
        logger.info("department.update parameter is [{}]",JSON.toJSON(department));
        return departmentService.update(id, department);
    }

    @ApiOperation(value = "查询部门", notes = "分页动态查询部门信息")
    @PostMapping("/pageQuery")
    public Result pageDepartment(@PageableDefault(value = 10, sort = {"createTime"}, direction = Sort.Direction.DESC) Pageable pageable, @RequestBody Department department) {
        return departmentService.dynamicQuery(pageable,department);
    }

}
