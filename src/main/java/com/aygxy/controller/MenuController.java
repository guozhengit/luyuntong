package com.aygxy.controller;

import com.alibaba.fastjson.JSON;
import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Menu;
import com.aygxy.service.MenuService;
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
 * @Description: 菜单管理控制类
 * @Author: xmf
 * @Date: 2019/4/8-0:07
 */
@RestController
@Api(value = "菜单管理")
@RequestMapping("/menu")
public class MenuController {
    private static Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    MenuService menuService;

    @ApiOperation(value = "添加路线信息")
    @PostMapping()
    public Result addMenu(@RequestBody Menu menu) {
        logger.info("Menu.add parameter is [{}]",JSON.toJSON(menu));
        return menuService.add(menu);
    }

    @ApiOperation(value = "删除路线信息", notes = "通过id删除用户")
    @DeleteMapping("/{id}")
    public Result deleteMenu(@PathVariable String id) {
        logger.info("Menu.delete parameter is [{}]",JSON.toJSON(id));
        return menuService.delete(id);
    }


    @ApiOperation(value = "编辑路线信息", notes = "通过id编辑路线")
    @PutMapping("/{id}")
    public Result updateMenu(@PathVariable String id, @RequestBody Menu menu) {
        logger.info("Menu.update parameter is [{}]",JSON.toJSON(menu));
        return menuService.update(id, menu);
    }

    @ApiOperation(value = "查询路线", notes = "分页动态查询路线信息")
    @PostMapping("/pageQuery")
    public Result pageMenu(@PageableDefault(value = 10, sort = {"createTime"}, direction = Sort.Direction.DESC) Pageable pageable,@RequestBody Menu menu) {
        return menuService.dynamicQuery(pageable,menu);
    }

}
