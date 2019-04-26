package com.aygxy.service.impl;

import com.aygxy.base.PhysicalConstants;
import com.aygxy.base.Result;
import com.aygxy.exception.BusinessException;
import com.aygxy.jpa.entity.DetailGoods;
import com.aygxy.jpa.entity.QDetailGoods;
import com.aygxy.jpa.repository.DetailGoodsRepository;
import com.aygxy.service.DetailGoodsService;
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
public class DetailGoodsServiceimpl implements DetailGoodsService {
    @Autowired
    JPAQueryFactory jpaQueryFactory;
    @Autowired
    DetailGoodsRepository detailGoodsRepository;

    @Override
    public Result add(DetailGoods detailGoods) {
        try {
            return new Result<>(PhysicalConstants.ADD_SUCCESS,PhysicalConstants.ADD_SUCCESS_CN,detailGoodsRepository.save(detailGoods));
        }catch (BusinessException e){
            throw new BusinessException(PhysicalConstants.ADD_UNSUCCESS_CN);
        }
    }

    @Override
    public Result delete(String id) {
        try {
            detailGoodsRepository.deleteById(id);
            return new Result<>(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
        }catch (Exception e){
            e.getStackTrace();
            throw new BusinessException(PhysicalConstants.DELETE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result deleteBatch(List<String> ids) {
        detailGoodsRepository.deleteAll(ids);
        return new Result(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
    }

    @Override
    public Result update(String id, DetailGoods detailGoods) {
        Optional<DetailGoods> optional = detailGoodsRepository.findById(id);
        if (optional.isPresent()) {
            DetailGoods entity = optional.get();
            BeanUtils.copyProperties(detailGoods, entity);
            DetailGoods detailGoods1 = detailGoodsRepository.save(entity);
            return new Result<>(PhysicalConstants.UPDATE_SUCCESS,PhysicalConstants.UPDATE_SUCCESS_CN,detailGoods1);
        } else {
            throw new BusinessException(PhysicalConstants.UPDATE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result dynamicQuery(Pageable pageable, DetailGoods detailGoods) {
        QDetailGoods qDetailGoods = QDetailGoods.detailGoods;
        Predicate predicate = qDetailGoods.isNotNull().or(qDetailGoods.isNull());
        predicate = StringUtils.isBlank(detailGoods.getType()) ? predicate:ExpressionUtils.and(predicate,qDetailGoods.type.eq(detailGoods.getType()));
        List<DetailGoods> list = jpaQueryFactory.selectFrom(qDetailGoods).where(predicate).offset(pageable.getOffset()).orderBy(qDetailGoods.createTime.desc())
                .limit(pageable.getPageSize()).fetch();
        //查询条数
        Long count = jpaQueryFactory
                .selectFrom(qDetailGoods)
                .where(predicate)
                .fetchCount();
        Page<DetailGoods> page = new PageImpl<>(list, pageable, count);
        return new Result(PhysicalConstants.REQUE_SUCCESS,PhysicalConstants.REQUE_SUCCESS_CN,page);
    }
}
