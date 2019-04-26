package com.aygxy.service.impl;

import com.aygxy.base.PhysicalConstants;
import com.aygxy.base.Result;
import com.aygxy.exception.BusinessException;
import com.aygxy.jpa.entity.Authority;
import com.aygxy.jpa.entity.QAuthority;
import com.aygxy.jpa.entity.User;
import com.aygxy.jpa.repository.AuthorityRepository;
import com.aygxy.service.AuthorityService;
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
public class AuthorityServiceimpl implements AuthorityService {
    @Autowired
    JPAQueryFactory jpaQueryFactory;
    @Autowired
    AuthorityRepository authorityRepository;


    @Override
    public Result add(Authority authority) {
        try {
            return new Result<>(PhysicalConstants.ADD_SUCCESS,PhysicalConstants.ADD_SUCCESS_CN,authorityRepository.save(authority));
        }catch (BusinessException e){
            throw new BusinessException(PhysicalConstants.ADD_UNSUCCESS_CN);
        }
    }

    @Override
    public Result delete(String id) {
        try {
            authorityRepository.deleteById(id);
            return new Result<>(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
        }catch (Exception e){
            e.getStackTrace();
            throw new BusinessException(PhysicalConstants.DELETE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result deleteBatch(List<String> ids) {
        authorityRepository.deleteAll(ids);
        return new Result(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
    }

    @Override
    public Result update(String id, Authority authority) {
        Optional<Authority> optional = authorityRepository.findById(id);
        if (optional.isPresent()) {
            Authority entity = optional.get();
            BeanUtils.copyProperties(authority, entity);
            Authority authority1 = authorityRepository.save(entity);
            return new Result<>(PhysicalConstants.UPDATE_SUCCESS,PhysicalConstants.UPDATE_SUCCESS_CN,authority1);
        } else {
            throw new BusinessException(PhysicalConstants.UPDATE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result dynamicQuery(Pageable pageable, Authority authority) {
        QAuthority qAuthority = QAuthority.authority;
        Predicate predicate = qAuthority.isNotNull().or(qAuthority.isNull());
        predicate = StringUtils.isBlank(authority.getName()) ? predicate:ExpressionUtils.and(predicate,qAuthority.name.eq(authority.getName()));
        List<Authority> list = jpaQueryFactory.selectFrom(qAuthority).where(predicate).offset(pageable.getOffset()).orderBy(qAuthority.createTime.desc())
                .limit(pageable.getPageSize()).fetch();
        //查询条数
        Long count = jpaQueryFactory
                .selectFrom(qAuthority)
                .where(predicate)
                .fetchCount();
        Page<Authority> page = new PageImpl<>(list, pageable, count);
        return new Result(PhysicalConstants.REQUE_SUCCESS,PhysicalConstants.REQUE_SUCCESS_CN,page);
    }
}
