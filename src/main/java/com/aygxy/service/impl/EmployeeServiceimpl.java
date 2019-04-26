package com.aygxy.service.impl;

import com.aygxy.base.PhysicalConstants;
import com.aygxy.base.Result;
import com.aygxy.exception.BusinessException;
import com.aygxy.jpa.entity.Employee;
import com.aygxy.jpa.entity.Employee;
import com.aygxy.jpa.entity.QEmployee;
import com.aygxy.jpa.repository.EmployeeRepository;
import com.aygxy.service.EmployeeService;
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
public class EmployeeServiceimpl implements EmployeeService {
    @Autowired
    JPAQueryFactory jpaQueryFactory;
    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public Result add(Employee employee) {
        try {
            return new Result<>(PhysicalConstants.ADD_SUCCESS,PhysicalConstants.ADD_SUCCESS_CN,employeeRepository.save(employee));
        }catch (BusinessException e){
            throw new BusinessException(PhysicalConstants.ADD_UNSUCCESS_CN);
        }
    }

    @Override
    public Result delete(String id) {
        try {
            employeeRepository.deleteById(id);
            return new Result<>(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
        }catch (Exception e){
            e.getStackTrace();
            throw new BusinessException(PhysicalConstants.DELETE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result deleteBatch(List<String> ids) {
        employeeRepository.deleteAll(ids);
        return new Result(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
    }

    @Override
    public Result update(String id, Employee employee) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()) {
            Employee entity = optional.get();
            BeanUtils.copyProperties(employee, entity);
            Employee employee1 = employeeRepository.save(entity);
            return new Result<>(PhysicalConstants.UPDATE_SUCCESS,PhysicalConstants.UPDATE_SUCCESS_CN,employee1);
        } else {
            throw new BusinessException(PhysicalConstants.UPDATE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result dynamicQuery(Pageable pageable, Employee employee) {
        QEmployee qEmployee = QEmployee.employee;
        Predicate predicate = qEmployee.isNotNull().or(qEmployee.isNull());
        predicate = StringUtils.isBlank(employee.getCode()) ? predicate:ExpressionUtils.and(predicate,qEmployee.code.eq(employee.getCode()));
        predicate = StringUtils.isBlank(employee.getAge())?predicate:ExpressionUtils.and(predicate,qEmployee.age.eq(employee.getAge()));
        List<Employee> list = jpaQueryFactory.selectFrom(qEmployee).where(predicate).offset(pageable.getOffset()).orderBy(qEmployee.createTime.desc())
                .limit(pageable.getPageSize()).fetch();
        //查询条数
        Long count = jpaQueryFactory
                .selectFrom(qEmployee)
                .where(predicate)
                .fetchCount();
        Page<Employee> page = new PageImpl<>(list, pageable, count);
        return new Result(PhysicalConstants.REQUE_SUCCESS,PhysicalConstants.REQUE_SUCCESS_CN,page);
    }
}
