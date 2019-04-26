package com.aygxy.service.impl;

import com.aygxy.base.PhysicalConstants;
import com.aygxy.base.Result;
import com.aygxy.exception.BusinessException;
import com.aygxy.jpa.entity.QStation;
import com.aygxy.jpa.entity.Station;
import com.aygxy.jpa.entity.Station;
import com.aygxy.jpa.entity.Vehicle;
import com.aygxy.jpa.repository.StationRepository;
import com.aygxy.service.StationService;
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
public class StationServiceimpl implements StationService {

    @Autowired
    StationRepository stationRepository;

    @Autowired
    JPAQueryFactory jpaQueryFactory;


    @Override
    public Result add(Station station) {
        try {
            return new Result<>(PhysicalConstants.ADD_SUCCESS,PhysicalConstants.ADD_SUCCESS_CN,stationRepository.save(station));
        }catch (BusinessException e){
            throw new BusinessException(PhysicalConstants.ADD_UNSUCCESS_CN);
        }
    }

    @Override
    public Result delete(String id) {
        try {
            stationRepository.deleteById(id);
            return new Result<>(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
        }catch (Exception e){
            e.getStackTrace();
            throw new BusinessException(PhysicalConstants.DELETE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result deleteBatch(List<String> ids) {
        stationRepository.deleteAll(ids);
        return new Result(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
    }

    @Override
    public Result update(String id, Station station) {
        Optional<Station> optional = stationRepository.findById(id);
        if (optional.isPresent()) {
            Station entity = optional.get();
            BeanUtils.copyProperties(station, entity);
            Station station1 = stationRepository.save(entity);
            return new Result<>(PhysicalConstants.UPDATE_SUCCESS,PhysicalConstants.UPDATE_SUCCESS_CN,station1);
        } else {
            throw new BusinessException(PhysicalConstants.UPDATE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result dynamicQuery(Pageable pageable, Station station) {
        QStation qStation = QStation.station;
        Predicate predicate = qStation.isNotNull().or(qStation.isNull());
        predicate = StringUtils.isBlank(station.getCode()) ? predicate:ExpressionUtils.and(predicate,qStation.code.eq(station.getCode()));
        predicate = StringUtils.isBlank(station.getPostCode())?predicate:ExpressionUtils.and(predicate,qStation.postCode.eq(station.getPostCode()));
        List<Station> list = jpaQueryFactory.selectFrom(qStation).where(predicate).offset(pageable.getOffset()).orderBy(qStation.createTime.desc())
                .limit(pageable.getPageSize()).fetch();
        //查询条数
        Long count = jpaQueryFactory
                .selectFrom(qStation)
                .where(predicate)
                .fetchCount();
        Page<Station> page = new PageImpl<>(list, pageable, count);
        return new Result(PhysicalConstants.REQUE_SUCCESS,PhysicalConstants.REQUE_SUCCESS_CN,page);
    }
}
