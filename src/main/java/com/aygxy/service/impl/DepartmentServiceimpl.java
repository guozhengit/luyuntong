package com.aygxy.service.impl;

import com.aygxy.base.PhysicalConstants;
import com.aygxy.base.Result;
import com.aygxy.exception.BusinessException;
import com.aygxy.jpa.entity.Department;
import com.aygxy.jpa.entity.QDepartment;
import com.aygxy.jpa.repository.DepartmentRepository;
import com.aygxy.service.DepartmentService;
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
public class DepartmentServiceimpl implements DepartmentService {
    @Autowired
    JPAQueryFactory jpaQueryFactory;
    @Autowired
    DepartmentRepository departmentRepository;


    @Override
    public Result add(Department department) {
        try {
            return new Result<>(PhysicalConstants.ADD_SUCCESS,PhysicalConstants.ADD_SUCCESS_CN,departmentRepository.save(department));
        }catch (BusinessException e){
            throw new BusinessException(PhysicalConstants.ADD_UNSUCCESS_CN);
        }
    }

    @Override
    public Result delete(String id) {
        try {
            departmentRepository.deleteById(id);
            return new Result<>(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
        }catch (Exception e){
            e.getStackTrace();
            throw new BusinessException(PhysicalConstants.DELETE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result deleteBatch(List<String> ids) {
        departmentRepository.deleteAll(ids);
        return new Result(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
    }

    @Override
    public Result update(String id, Department department) {
        Optional<Department> optional = departmentRepository.findById(id);
        if (optional.isPresent()) {
            Department entity = optional.get();
            BeanUtils.copyProperties(department, entity);
            Department department1 = departmentRepository.save(entity);
            return new Result<>(PhysicalConstants.UPDATE_SUCCESS,PhysicalConstants.UPDATE_SUCCESS_CN,department1);
        } else {
            throw new BusinessException(PhysicalConstants.UPDATE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result dynamicQuery(Pageable pageable, Department department) {
        QDepartment qDepartment = QDepartment.department;
        Predicate predicate = qDepartment.isNotNull().or(qDepartment.isNull());
        predicate = StringUtils.isBlank(department.getDescrition()) ? predicate:ExpressionUtils.and(predicate,qDepartment.descrition.eq(department.getDescrition()));
        List<Department> list = jpaQueryFactory.selectFrom(qDepartment).where(predicate).offset(pageable.getOffset()).orderBy(qDepartment.createTime.desc())
                .limit(pageable.getPageSize()).fetch();
        //查询条数
        Long count = jpaQueryFactory
                .selectFrom(qDepartment)
                .where(predicate)
                .fetchCount();
        Page<Department> page = new PageImpl<>(list, pageable, count);
        return new Result(PhysicalConstants.REQUE_SUCCESS,PhysicalConstants.REQUE_SUCCESS_CN,page);
    }
}
