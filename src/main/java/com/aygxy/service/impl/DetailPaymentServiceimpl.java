package com.aygxy.service.impl;

import com.aygxy.base.PhysicalConstants;
import com.aygxy.base.Result;
import com.aygxy.exception.BusinessException;
import com.aygxy.jpa.entity.DetailPayment;
import com.aygxy.jpa.entity.DetailPayment;
import com.aygxy.jpa.repository.DetailPaymentRepository;
import com.aygxy.service.DetailPaymentService;
import com.aygxy.util.BeanUtils;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DetailPaymentServiceimpl implements DetailPaymentService {
    @Autowired
    JPAQueryFactory jpaQueryFactory;
    @Autowired
    DetailPaymentRepository detailPaymentRepository;


    @Override
    public Result add(DetailPayment detailPayment) {
        try {
            return new Result<>(PhysicalConstants.ADD_SUCCESS,PhysicalConstants.ADD_SUCCESS_CN,detailPaymentRepository.save(detailPayment));
        }catch (BusinessException e){
            throw new BusinessException(PhysicalConstants.ADD_UNSUCCESS_CN);
        }
    }

    @Override
    public Result delete(String id) {
        try {
            detailPaymentRepository.deleteById(id);
            return new Result<>(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
        }catch (Exception e){
            e.getStackTrace();
            throw new BusinessException(PhysicalConstants.DELETE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result deleteBatch(List<String> ids) {
        detailPaymentRepository.deleteAll(ids);
        return new Result(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
    }

    @Override
    public Result update(String id, DetailPayment detailPayment) {
        Optional<DetailPayment> optional = detailPaymentRepository.findById(id);
        if (optional.isPresent()) {
            DetailPayment entity = optional.get();
            BeanUtils.copyProperties(detailPayment, entity);
            DetailPayment detailPayment1 = detailPaymentRepository.save(entity);
            return new Result<>(PhysicalConstants.UPDATE_SUCCESS,PhysicalConstants.UPDATE_SUCCESS_CN,detailPayment1);
        } else {
            throw new BusinessException(PhysicalConstants.UPDATE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result dynamicQuery(Pageable pageable, DetailPayment detailPayment) {
        return null;
    }
}
