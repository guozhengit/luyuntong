package com.aygxy.service.impl;

import com.aygxy.base.PhysicalConstants;
import com.aygxy.base.Result;
import com.aygxy.exception.BusinessException;
import com.aygxy.jpa.entity.Menu;
import com.aygxy.jpa.entity.QMenu;
import com.aygxy.jpa.repository.MenuRepository;
import com.aygxy.service.MenuService;
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
public class MenuServiceimpl implements MenuService {
    @Autowired
    JPAQueryFactory jpaQueryFactory;
    @Autowired
    MenuRepository menuRepository;


    @Override
    public Result add(Menu menu) {
        try {
            return new Result<>(PhysicalConstants.ADD_SUCCESS,PhysicalConstants.ADD_SUCCESS_CN,menuRepository.save(menu));
        }catch (BusinessException e){
            throw new BusinessException(PhysicalConstants.ADD_UNSUCCESS_CN);
        }
    }

    @Override
    public Result delete(String id) {
        try {
            menuRepository.deleteById(id);
            return new Result<>(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
        }catch (Exception e){
            e.getStackTrace();
            throw new BusinessException(PhysicalConstants.DELETE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result deleteBatch(List<String> ids) {
        menuRepository.deleteAll(ids);
        return new Result(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
    }

    @Override
    public Result update(String id, Menu menu) {
        Optional<Menu> optional = menuRepository.findById(id);
        if (optional.isPresent()) {
            Menu entity = optional.get();
            BeanUtils.copyProperties(menu, entity);
            Menu menu1 = menuRepository.save(entity);
            return new Result<>(PhysicalConstants.UPDATE_SUCCESS,PhysicalConstants.UPDATE_SUCCESS_CN,menu1);
        } else {
            throw new BusinessException(PhysicalConstants.UPDATE_UNSUCCESS_CN);
        }
    }

    @Override
    public Result dynamicQuery(Pageable pageable, Menu menu) {
        QMenu qMenu = QMenu.menu;
        Predicate predicate = qMenu.isNotNull().or(qMenu.isNull());
        predicate = StringUtils.isBlank(menu.getId()) ? predicate:ExpressionUtils.and(predicate,qMenu.id.eq(menu.getId()));
        predicate = StringUtils.isBlank(menu.getName())?predicate:ExpressionUtils.and(predicate,qMenu.name.eq(menu.getName()));
        List<Menu> list = jpaQueryFactory.selectFrom(qMenu).where(predicate).offset(pageable.getOffset()).orderBy(qMenu.createTime.desc())
                .limit(pageable.getPageSize()).fetch();
        //查询条数
        Long count = jpaQueryFactory
                .selectFrom(qMenu)
                .where(predicate)
                .fetchCount();
        Page<Menu> page = new PageImpl<>(list, pageable, count);
        return new Result(PhysicalConstants.REQUE_SUCCESS,PhysicalConstants.REQUE_SUCCESS_CN,page);
    }
}
