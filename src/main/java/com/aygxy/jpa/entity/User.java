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
    @NotEmpty(message = "用户名不能为空")
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

    @OneToOne(fetch = FetchType.LAZY)
    private Employee employee;

    //1、关系维护端，负责多对多关系的绑定和解除
    //2、@JoinTable注解的name属性指定关联表的名字，joinColumns指定外键的名字，关联到关系维护端(User)
    //3、inverseJoinColumns指定外键的名字，要关联的关系被维护端(authority)
    //4、其实可以不使用@JoinTable注解，默认生成的关联表名称为主表表名+下划线+从表表名，
    //关联到主表的外键名：主表名+下划线+主表中的主键列名,即user_id
    //关联到从表的外键名：主表中用于关联的属性名+下划线+从表的主键列名,即authority_id
    //主表就是关系维护端对应的表，从表就是关系被维护端对应的表
    @ManyToMany
    @JoinTable(name = "user_authority_info", joinColumns = @JoinColumn(name = "user_code"), inverseJoinColumns = @JoinColumn(name = "authority_code"))
    private List<Authority> authorityList;

}
