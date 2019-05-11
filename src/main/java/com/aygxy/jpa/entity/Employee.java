package com.aygxy.jpa.entity;

import com.aygxy.jpa.BaseNamedJpaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Description: 职员信息表实体
 * @Author: xmf
 * @Date: 2019/4/6-23:01
 */

@Setter
@Getter
@Entity
@Table(name = "physical_employee_info")
public class Employee extends BaseNamedJpaEntity {
    //职员id //职员姓名
    //职员编号
    @Column(name = "employee_code",columnDefinition = "varchar(200)")
    private String code;

    @Column(name = "employee_name",columnDefinition = "varchar(200)")
    private String employeeName;
    //生日
    @Column(name = "birthday",columnDefinition = "varchar(200)")
    private String birthday;
    //年龄
    @Column(name = "age",columnDefinition = "varchar(200)")
    private String age;
    //职位
    @Column(name = "position",columnDefinition = "varchar(200)")
    private String position;
    //性别
    @Column(name = "gender",columnDefinition = "varchar(200)")
    private String gender;
    //薪资
    @Column(name = "salary",nullable = true, precision=12, scale=2)
    private BigDecimal salary;
    //奖金
    @Column(name = "bonus",nullable = true, precision=12, scale=2)
    private BigDecimal bonus;
    //站点编号 --StationEntity
    @Column(name = "station_code",columnDefinition = "varchar(200)")
    private String stationCode;

    @Column(name = "department_code",columnDefinition = "varchar(200)")
    private String departmentCode;

    public Employee(String code, String stationCode, String departmentCode) {
        this.code = code;
        this.stationCode = stationCode;
        this.departmentCode = departmentCode;
    }

    public Employee() {
    }
}
