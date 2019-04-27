package com.aygxy.jpa.entity;

import com.aygxy.jpa.BaseNamedJpaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @Description: 权限类设置
 * @Author: xmf
 * @Date: 2019/4/8-23:34
 */
@Getter
@Setter
@Entity
@Table(name = "physical_authority_info")
public class Authority extends BaseNamedJpaEntity {

    @Column(name = "authority_code",columnDefinition = "varchar(200)")
    private String code;

    @ManyToMany
    @JoinTable(name="authority_menu_info", joinColumns=@JoinColumn(name="menu_code"), inverseJoinColumns=@JoinColumn(name="authority_code"))
    private List<Menu> menus;

    @ManyToMany(mappedBy = "authorityList")
    private List<User> userList;
}
