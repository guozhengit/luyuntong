package com.aygxy.service.impl;

import com.aygxy.base.PhysicalConstants;
import com.aygxy.base.Result;
import com.aygxy.exception.BusinessException;
import com.aygxy.jpa.entity.QRoute;
import com.aygxy.jpa.entity.Route;
import com.aygxy.jpa.entity.Route;
import com.aygxy.jpa.repository.RouteReposity;
import com.aygxy.service.RouteService;
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
public class RouteServiceimpl implements RouteService {

    @Autowired
    JPAQueryFactory jpaQueryFactory;
    @Autowired
    RouteReposity routeReposity;


    @Override
    public Result add(Route route) {
        try {
            return new Result<>(PhysicalConstants.ADD_SUCCESS,PhysicalConstants.ADD_SUCCESS_CN,routeReposity.save(route));
        }catch (BusinessException e){
            throw new BusinessException(PhysicalConstants.ADD_UNSUCCESS_CN);
        }
    }

    @Override
    public Result delete(String id) {
        try {
            routeReposity.deleteById(id);
            return new Result<>(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
        }catch (Exception e){
            e.getStackTrace();
            throw new BusinessException(PhysicalConstants.DELETE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result deleteBatch(List<String> ids) {
        routeReposity.deleteAll(ids);
        return new Result(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
    }

    @Override
    public Result update(String id, Route route) {
        Optional<Route> optional = routeReposity.findById(id);
        if (optional.isPresent()) {
            Route entity = optional.get();
            BeanUtils.copyProperties(route, entity);
            Route route1 = routeReposity.save(entity);
            return new Result<>(PhysicalConstants.UPDATE_SUCCESS,PhysicalConstants.UPDATE_SUCCESS_CN,route1);
        } else {
            throw new BusinessException(PhysicalConstants.UPDATE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result dynamicQuery(Pageable pageable, Route route) {
        QRoute qRoute = QRoute.route;
        Predicate predicate = qRoute.isNotNull().or(qRoute.isNull());
        predicate = StringUtils.isBlank(route.getStartCity()) ? predicate:ExpressionUtils.and(predicate,qRoute.startCity.eq(route.getStartCity()));
        predicate = StringUtils.isBlank(route.getTargetCity())?predicate:ExpressionUtils.and(predicate,qRoute.targetCity.eq(route.getTargetCity()));
        List<Route> list = jpaQueryFactory.selectFrom(qRoute).where(predicate).offset(pageable.getOffset()).orderBy(qRoute.createTime.desc())
                .limit(pageable.getPageSize()).fetch();
        //查询条数
        Long count = jpaQueryFactory
                .selectFrom(qRoute)
                .where(predicate)
                .fetchCount();
        Page<Route> page = new PageImpl<>(list, pageable, count);
        return new Result(PhysicalConstants.REQUE_SUCCESS,PhysicalConstants.REQUE_SUCCESS_CN,page);
    }
}
