package com.aygxy.jpa.entity;

import com.aygxy.jpa.BaseNamedJpaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @Description: 公司部门实体
 * @Author: xmf
 * @Date: 2019/4/6-15:13
 */

@Getter
@Setter
@Entity
@Table(name = "physical_department_info")
public class Department extends BaseNamedJpaEntity {
    //部门id //部门名称

    //部门编号
    @Column(name = "department_code",columnDefinition = "varchar(100)")
    private String code;
    //部门描述
    @Column(name = "descrition",columnDefinition = "varchar(200)")
    private String descrition;

    @Column(name = "employee_code",columnDefinition = "varchar(200)")
    private String employeeCode;

}
