package com.aygxy.service.impl;

import com.aygxy.base.Result;
import com.aygxy.exception.BusinessException;
import com.aygxy.jpa.entity.Driver;
import com.aygxy.jpa.repository.DriverRepository;
import com.aygxy.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 业务实现层接口
 * @Author: xmf
 * @Date: 2019/4/11-18:37
 */
@Service
public class DriverServiceimpl  implements DriverService {

    @Autowired
    DriverRepository driverRepository;

    @Override
    public Driver addDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Result deleteByUid(String uid) {
        try {
            //deleteById方法返回为void 所有不需要任何返回值
            driverRepository.deleteById(uid);
          //  调用Result的构造方法，编辑返回信息
          return new Result("0","删除成功");
        //  如果出现程序异常，进入catch 俘获异常
        }catch (BusinessException e){
            throw new BusinessException("删除失败");
        }
    }
}
