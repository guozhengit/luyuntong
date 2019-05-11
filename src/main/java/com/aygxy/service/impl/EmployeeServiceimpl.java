package com.aygxy.service.impl;

import com.aygxy.base.PhysicalConstants;
import com.aygxy.base.Result;
import com.aygxy.exception.BusinessException;
import com.aygxy.jpa.entity.*;
import com.aygxy.jpa.entity.Employee;
import com.aygxy.jpa.repository.*;
import com.aygxy.service.EmployeeService;
import com.aygxy.util.BeanUtils;
import com.aygxy.util.RandomUtil;
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
public class EmployeeServiceimpl implements EmployeeService {
    @Autowired
    JPAQueryFactory jpaQueryFactory;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    BillRepository billRepository;
    @Autowired
    StationRepository stationRepository;
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    RouteReposity routeReposity;
    @Autowired
    MockDataService mockDataService;


    @Override
    public Result add(Employee employee) {
        try {
            employee.setCreateTime(new Date());
            //***********添加数据*************
            for (int i=0;i<500;i++){
                String stationCode = "ST".concat(RandomUtil.generateZeroString(4))+i;
                String cityCode = "CY".concat(RandomUtil.generateZeroString(4))+i;
                String vehicleCode = "VC".concat(RandomUtil.generateZeroString(4))+i;
                String routeCode = "RU".concat(RandomUtil.generateZeroString(4))+i;
                String employeeCode = "EP".concat(RandomUtil.generateZeroString(4))+i;
                String driverCode = "DV".concat(RandomUtil.generateZeroString(4))+i;

                billRepository.save(mockDataService.setMockBill(new Bill()));
                routeReposity.save(mockDataService.mockRoute(new Route(routeCode,cityCode)));
                vehicleRepository.save(mockDataService.mockVehicle(new Vehicle(vehicleCode,routeCode,driverCode)));
                cityRepository.save(mockDataService.mockCity(new City(cityCode,stationCode,routeCode)));
                driverRepository.save(mockDataService.mockDriver(new Driver(driverCode,stationCode,routeCode)));
                stationRepository.save(mockDataService.mockStation(new Station(stationCode,cityCode)));
                employeeRepository.save(mockDataService.mockEmployee(new Employee(employeeCode,stationCode,"00"+i)));

            }
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
            entity.setUpdateTime(new Date());
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
