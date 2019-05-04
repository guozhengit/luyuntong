package com.aygxy.controller;

import com.alibaba.fastjson.JSON;
import com.aygxy.base.Result;
import com.aygxy.jpa.entity.DetailGoods;
import com.aygxy.service.DetailGoodsService;
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
 * @Description: 货物管理控制类
 * @Author: xmf
 * @Date: 2019/4/8-0:07
 */
@RestController
@Api(value = "货物管理")
@RequestMapping("/goods")
public class DetailGoodsController {
    private static Logger logger = LoggerFactory.getLogger(DetailGoodsController.class);
    @Autowired
    DetailGoodsService detailGoodsService;

    @ApiOperation(value = "添加货物信息")
    @PostMapping()
    public Result addDetailGoods(@RequestBody DetailGoods detailGoods) {
        logger.info("detailGoods.add parameter is [{}]",JSON.toJSON(detailGoods));
        return detailGoodsService.add(detailGoods);
    }

    @ApiOperation(value = "删除货物信息", notes = "通过id删除用户")
    @DeleteMapping("/{id}")
    public Result deleteDetailGoods(@PathVariable String  id) {
        logger.info("detailGoods.delete parameter is [{}]",JSON.toJSON(id));
        return detailGoodsService.delete(id);
    }

    @ApiOperation(value = "删除货物信息", notes = "批量删除")
    @ApiImplicitParam(name = "dgid", required = true, dataType = "String[]")
    @PostMapping("/deleteBatch")
    public Result deleteUser(@RequestBody List<String> ids) {
        logger.info("detailGoods.delete parameter is [{}]",JSON.toJSON(ids));
        return detailGoodsService.deleteBatch(ids);
    }

    @ApiOperation(value = "编辑货物信息", notes = "通过id编辑货物")
    @PutMapping("/{id}")
    public Result updateDetailGoods(@PathVariable String id, @RequestBody DetailGoods detailGoods) {
        logger.info("detailGoods.update parameter is [{}]",JSON.toJSON(detailGoods));
        return detailGoodsService.update(id, detailGoods);
    }

    @ApiOperation(value = "查询货物", notes = "分页动态查询货物信息")
    @PostMapping("/pageQuery")
    public Result pageDetailGoods(@PageableDefault(value = 10, sort = {"createTime"}, direction = Sort.Direction.DESC) Pageable pageable, @RequestBody DetailGoods detailGoods) {
        return detailGoodsService.dynamicQuery(pageable,detailGoods);
    }

}
