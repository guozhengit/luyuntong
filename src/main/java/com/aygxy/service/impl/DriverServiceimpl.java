package com.aygxy.service.impl;

import com.aygxy.base.PhysicalConstants;
import com.aygxy.base.Result;
import com.aygxy.exception.BusinessException;
import com.aygxy.jpa.entity.Driver;
import com.aygxy.jpa.entity.Driver;
import com.aygxy.jpa.entity.QDriver;
import com.aygxy.jpa.repository.DriverRepository;
import com.aygxy.service.DriverService;
import com.aygxy.util.BeanUtils;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Description: 业务实现层接口
 * @Author: xmf
 * @Date: 2019/4/11-18:37
 */
@Service
public class DriverServiceimpl  implements DriverService {

    @Autowired
    JPAQueryFactory jpaQueryFactory;
    @Autowired
    DriverRepository driverRepository;


    @Override
    public Result add(Driver driver) {
        try {
            return new Result<>(PhysicalConstants.ADD_SUCCESS, PhysicalConstants.ADD_SUCCESS_CN, driverRepository.save(driver));
        } catch (BusinessException e) {
            throw new BusinessException(PhysicalConstants.ADD_UNSUCCESS_CN);
        }
    }

    @Override
    public Result delete(String id) {
        try {
            driverRepository.deleteById(id);
            return new Result<>(PhysicalConstants.DELETE_SUCCESS, PhysicalConstants.DELETE_SUCCESS_CN);
        } catch (Exception e) {
            e.getStackTrace();
            throw new BusinessException(PhysicalConstants.DELETE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result deleteBatch(List<String> ids) {
        driverRepository.deleteAll(ids);
        return new Result(PhysicalConstants.DELETE_SUCCESS, PhysicalConstants.DELETE_SUCCESS_CN);
    }

    @Override
    public Result update(String id, Driver driver) {
        Optional<Driver> optional = driverRepository.findById(id);
        if (optional.isPresent()) {
            Driver entity = optional.get();
            BeanUtils.copyProperties(driver, entity);
            Driver driver1 = driverRepository.save(entity);
            return new Result<>(PhysicalConstants.UPDATE_SUCCESS, PhysicalConstants.UPDATE_SUCCESS_CN, driver1);
        } else {
            throw new BusinessException(PhysicalConstants.UPDATE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result dynamicQuery(Pageable pageable, Driver driver) {
        QDriver qDriver = QDriver.driver;
        Predicate predicate = qDriver.isNotNull().or(qDriver.isNull());
        predicate = StringUtils.isBlank(driver.getIdCard()) ? predicate : ExpressionUtils.and(predicate, qDriver.idCard.eq(driver.getIdCard()));
        predicate = StringUtils.isBlank(driver.getAddress()) ? predicate : ExpressionUtils.and(predicate, qDriver.address.eq(driver.getAddress()));
        List<Driver> list = jpaQueryFactory.selectFrom(qDriver).where(predicate).offset(pageable.getOffset()).orderBy(qDriver.createTime.desc())
                .limit(pageable.getPageSize()).fetch();
        //查询条数
        Long count = jpaQueryFactory
                .selectFrom(qDriver)
                .where(predicate)
                .fetchCount();
        Page<Driver> page = new PageImpl<>(list, pageable, count);
        return new Result(PhysicalConstants.REQUE_SUCCESS, PhysicalConstants.REQUE_SUCCESS_CN, page);
    }
}
