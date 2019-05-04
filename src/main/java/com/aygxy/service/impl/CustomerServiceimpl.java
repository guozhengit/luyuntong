package com.aygxy.service.impl;

import com.aygxy.base.PhysicalConstants;
import com.aygxy.base.Result;
import com.aygxy.exception.BusinessException;
import com.aygxy.jpa.entity.Customer;
import com.aygxy.jpa.entity.Customer;
import com.aygxy.jpa.entity.QCustomer;
import com.aygxy.jpa.repository.CustomerRepository;
import com.aygxy.service.CustomerService;
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

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Description: 业务实现层接口
 * @Author: xmf
 * @Date: 2019/4/11-18:37
 */
@Service
public class CustomerServiceimpl implements CustomerService {
    @Autowired
    JPAQueryFactory jpaQueryFactory;
    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Result add(Customer customer) {
        try {
            customer.setCreateTime(new Date());
            return new Result<>(PhysicalConstants.ADD_SUCCESS,PhysicalConstants.ADD_SUCCESS_CN,customerRepository.save(customer));
        }catch (BusinessException e){
            throw new BusinessException(PhysicalConstants.ADD_UNSUCCESS_CN);
        }
    }

    @Override
    public Result delete(String id) {
        try {
            customerRepository.deleteById(id);
            return new Result<>(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
        }catch (Exception e){
            e.getStackTrace();
            throw new BusinessException(PhysicalConstants.DELETE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result deleteBatch(List<String> ids) {
        customerRepository.deleteAll(ids);
        return new Result(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
    }

    @Override
    public Result update(String id, Customer customer) {
        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isPresent()) {
            Customer entity = optional.get();
            BeanUtils.copyProperties(customer, entity);
            entity.setUpdateTime(new Date());
            Customer customer1 = customerRepository.save(entity);
            return new Result<>(PhysicalConstants.UPDATE_SUCCESS,PhysicalConstants.UPDATE_SUCCESS_CN,customer1);
        } else {
            throw new BusinessException(PhysicalConstants.UPDATE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result dynamicQuery(Pageable pageable, Customer customer) {
        QCustomer qCustomer = QCustomer.customer;
        Predicate predicate = qCustomer.isNotNull().or(qCustomer.isNull());
        predicate = StringUtils.isBlank(customer.getCode()) ? predicate:ExpressionUtils.and(predicate,qCustomer.code.eq(customer.getCode()));
        predicate = StringUtils.isBlank(customer.getPostCode())?predicate:ExpressionUtils.and(predicate,qCustomer.postCode.eq(customer.getPostCode()));
        List<Customer> list = jpaQueryFactory.selectFrom(qCustomer).where(predicate).offset(pageable.getOffset()).orderBy(qCustomer.createTime.desc())
                .limit(pageable.getPageSize()).fetch();
        //查询条数
        Long count = jpaQueryFactory
                .selectFrom(qCustomer)
                .where(predicate)
                .fetchCount();
        Page<Customer> page = new PageImpl<>(list, pageable, count);
        return new Result(PhysicalConstants.REQUE_SUCCESS,PhysicalConstants.REQUE_SUCCESS_CN,page);
    }
}
