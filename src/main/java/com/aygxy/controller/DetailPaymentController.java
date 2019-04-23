package com.aygxy.controller;

import com.alibaba.fastjson.JSON;
import com.aygxy.base.Result;
import com.aygxy.jpa.entity.DetailPayment;
import com.aygxy.service.DetailPaymentService;
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
 * @Description: 收支费用控制类
 * @Author: xmf
 * @Date: 2019/4/8-0:07
 */
@RestController
@Api(value = "收支费用管理")
@RequestMapping("/payment")
public class DetailPaymentController {
    private static Logger logger = LoggerFactory.getLogger(DetailPaymentController.class);
    @Autowired
    DetailPaymentService detailPaymentService;

    @ApiOperation(value = "添加收支费用信息")
    @PostMapping()
    public Result addDetailPayment(@RequestBody DetailPayment detailPayment) {
        logger.info("detailPayment.add parameter is [{}]",JSON.toJSON(detailPayment));
        return detailPaymentService.add(detailPayment);
    }

    @ApiOperation(value = "删除收支费用信息", notes = "通过id删除用户")
    @DeleteMapping("/{id}")
    public Result deleteDetailPayment(@PathVariable String  id) {
        logger.info("detailPayment.delete parameter is [{}]",JSON.toJSON(id));
        return detailPaymentService.delete(id);
    }


    @ApiOperation(value = "编辑收支费用信息", notes = "通过id编辑收支费用")
    @PutMapping("/{id}")
    public Result updateDetailPayment(@PathVariable String id, @RequestBody DetailPayment detailPayment) {
        logger.info("detailPayment.update parameter is [{}]",JSON.toJSON(detailPayment));
        return detailPaymentService.update(id, detailPayment);
    }

    @ApiOperation(value = "查询收支费用", notes = "分页动态查询收支费用信息")
    @PostMapping("/pageQuery")
    public Result pageDetailPayment(@PageableDefault(value = 10, sort = {"createTime"}, direction = Sort.Direction.DESC) Pageable pageable, @RequestBody DetailPayment detailPayment) {
        return detailPaymentService.dynamicQuery(pageable,detailPayment);
    }
}
