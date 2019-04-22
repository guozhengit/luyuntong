package com.aygxy.service.impl;

import com.aygxy.base.PhysicalConstants;
import com.aygxy.base.Result;
import com.aygxy.exception.BusinessException;
import com.aygxy.jpa.entity.QVehicle;
import com.aygxy.jpa.entity.Vehicle;
import com.aygxy.jpa.repository.VehicleRepository;
import com.aygxy.service.VehicleService;
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
public class VehicleServiceimpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Override
    public Result add(Vehicle vehicle) {
        try {
            return new Result<>(PhysicalConstants.ADD_SUCCESS,PhysicalConstants.ADD_SUCCESS_CN,vehicleRepository.save(vehicle));
        }catch (BusinessException e){
            throw new BusinessException(PhysicalConstants.ADD_UNSUCCESS_CN);
        }
    }

    @Override
    public Result delete(String id) {
        try {
            vehicleRepository.deleteById(id);
            return new Result<>(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
        }catch (Exception e){
            throw new BusinessException(PhysicalConstants.DELETE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result update(String uid, Vehicle vehicle) {
        Optional<Vehicle> optional = vehicleRepository.findById(uid);
        if (optional.isPresent()) {
            Vehicle entity = optional.get();
            BeanUtils.copyProperties(vehicle, entity);
            Vehicle vehicle1 = vehicleRepository.save(entity);
            return new Result<>(PhysicalConstants.UPDATE_SUCCESS,PhysicalConstants.UPDATE_SUCCESS_CN,vehicle1);
        } else {
            throw new BusinessException(PhysicalConstants.UPDATE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result deleteBatch(List<String> ids) {
        vehicleRepository.deleteAll(ids);
        return new Result(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
    }

    @Override
    public Result dynamicQuery(Pageable pageable, Vehicle vehicle) {
        QVehicle qVehicle = QVehicle.vehicle;
        Predicate predicate =  qVehicle.isNotNull().or(qVehicle.isNull());
        predicate = StringUtils.isBlank(vehicle.getName()) ? predicate :  ExpressionUtils.and( predicate,qVehicle.name.eq(vehicle.getName()));
        predicate = StringUtils.isBlank(vehicle.getCode()) ? predicate :  ExpressionUtils.and( predicate,qVehicle.code.eq(vehicle.getCode()));
        predicate = StringUtils.isBlank(vehicle.getAllowCarryVolume()) ? predicate :  ExpressionUtils.and( predicate,qVehicle.allowCarryVolume.eq(vehicle.getAllowCarryVolume()));
        List<Vehicle>  list = jpaQueryFactory.selectFrom(qVehicle).where(predicate)
                .offset(pageable.getOffset())
                .orderBy(qVehicle.createTime.desc())
                .limit(pageable.getPageSize()).fetch();
        //查询条数
        Long count = jpaQueryFactory
                .selectFrom(qVehicle)
                .where(predicate)
                .fetchCount();
        Page<Vehicle> pageVehicle = new PageImpl<>(list, pageable, count);
        return new Result(PhysicalConstants.REQUE_SUCCESS,PhysicalConstants.REQUE_SUCCESS_CN,pageVehicle);
    }
}
