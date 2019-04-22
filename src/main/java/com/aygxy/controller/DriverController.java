package com.aygxy.controller;

import com.aygxy.base.Result;
import com.aygxy.jpa.entity.Driver;
import com.aygxy.service.DriverService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Description: 用户控制类
 * @Author: xmf
 * @Date: 2019/4/8-0:07
 */
@RestController
@Api(value = "司机管理")
@RequestMapping("/driver")
public class DriverController {
    private static Logger logger = LoggerFactory.getLogger(DriverController.class);

    @Autowired
    DriverService driverService;
    //http://127.0.0.1:8080/driver/
    @PostMapping("/")
    public Result addDriver(@RequestBody Driver driver){
        //调用业务层
        return driverService.add(driver);
    }

    @DeleteMapping()
    /*@PathVariable 可以来映射 URL 中的占位符到目标方法的参数中.
       uid = XXXXXXXXXXXXXXXXXXX
    * 例：http//localhost:8080?uid
    * */
    public Result deleteDriverById(@PathVariable String uid){
            return driverService.delete(uid);
    }


}
