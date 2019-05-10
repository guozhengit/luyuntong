package com.aygxy.jpa.entity;

import com.aygxy.jpa.BaseJpaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @Description: 用户实体
 * @Author: xmf
 * @Date: 2019/4/6-15:05
 */
@Getter
@Setter
@Entity
@Table(name = "physical_user_info")
public  class User extends BaseJpaEntity {
    //主键id
    //用户编号
    @Column(name = "user_code",columnDefinition = "varchar(200)")
    private String code;
    // 用户名
    @NotEmpty(message = "不能为空")
    @Size(min=3, max=20)
    @Column(name = "user_name",columnDefinition = "varchar(200)")
    private String name;

    //用户密码
    @NotEmpty(message = "密码不能为空")
    @Size(max=100)
    @Column(name = "password",columnDefinition = "varchar(200)")
    private String password;
    //年龄
    @Column(name = "age",columnDefinition = "varchar(200)")
    private String age;
    //性别
    @Column(name = "gender",columnDefinition = "varchar(200)")
    private String gender;
    //生日
    @Column(name = "birthDay",columnDefinition = "varchar(200)")
    private String birthDay;
    //电话
    @Column(name = "phone",columnDefinition = "varchar(200)")
    private String phone;
    //邮箱
    @Column(name = "email",columnDefinition = "varchar(200)")
    private String email;
    //邮箱
    @Column(name = "employeeCode",columnDefinition = "varchar(200)")
    private String employeeCode;

}
