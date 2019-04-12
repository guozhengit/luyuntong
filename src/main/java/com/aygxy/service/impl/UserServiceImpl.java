package com.aygxy.service.impl;

import com.aygxy.exception.BusinessException;
import com.aygxy.jpa.entity.QUser;
import com.aygxy.service.UserService;
import com.aygxy.base.PhysicalConstants;
import com.aygxy.base.Result;
import com.aygxy.jpa.bean.UserDTO;
import com.aygxy.jpa.entity.User;
import com.aygxy.jpa.repository.UserRepository;
import com.aygxy.util.BeanUtils;
import com.aygxy.util.SingleTonUtil;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Description: user服务实现类
 * @Author: xmf
 * @Date: 2019/4/8-0:13
 */
@Service
public class  UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    JPAQueryFactory jpaQueryFactory;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Result addByOne( User userEntity) {
        try {
            userEntity.setCreateTime(new Date());
            User user = userRepository.save(userEntity);
            return new Result<>(PhysicalConstants.ADD_SUCCESS,PhysicalConstants.ADD_SUCCESS_CN,user);
        }catch (BusinessException e){
            throw new BusinessException(PhysicalConstants.ADD_UNSUCCESS_CN);
        }
    }

    @Override
    public Result deleteByOne(String uid) {
        try {
            userRepository.deleteById(uid);
            return new Result<>(PhysicalConstants.DELETE_SUCCESS,PhysicalConstants.DELETE_SUCCESS_CN);
        }catch (Exception e){
            e.getStackTrace();
            throw new BusinessException(PhysicalConstants.DELETE_UNSUCCESS_CN);
        }

    }

    @Override
    public Result queryById(String uid)  {
        Optional<User> optional = userRepository.findById(uid);
        User user = optional.orElse(null);
        if (StringUtils.isEmpty(user)){
            throw new BusinessException(PhysicalConstants.REQUE_UNSUCCESS_CN);
        }else {
            return new Result<>(PhysicalConstants.REQUE_SUCCESS,PhysicalConstants.REQUE_SUCCESS_CN,user);
        }
    }

    @Override
    public Result update(String uid, User user) {
        SingleTonUtil.INSTANCE.test();
        Optional<User> optional = userRepository.findById(uid);
        if (optional.isPresent()) {
            user.setUpdateTime(new Date());
            User entity = optional.get();
            BeanUtils.copyProperties(user, entity);
            User user1 = userRepository.save(entity);
            return new Result<>(PhysicalConstants.UPDATE_SUCCESS,PhysicalConstants.UPDATE_SUCCESS_CN,user1);
        } else {
            throw new BusinessException(PhysicalConstants.UPDATE_UNSUCCESS_CN);
        }
    }

    /**
     * 部分字段映射查询
     * 投影为UserRes,lambda方式(灵活，类型可以在lambda中修改)
     * birthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tuple.get(user.birthday)))
     * @return Result
     */
    @Override
    public Result findAll(Pageable pageable) {
        QUser user = QUser.user;
        List<UserDTO> dtoList = jpaQueryFactory
                .select(
                        user.name,
                        user.password,
                        user.id,
                        user.age,
                        user.createTime
                )
                .from(user)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch()
                .stream()
                .map(tuple -> UserDTO.builder()
                        .id(tuple.get(user.id))
                        .createTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tuple.get(user.createTime)))
                        .age(tuple.get(user.age))
                        .name(tuple.get(user.name))
                        .password(tuple.get(user.password))
                        .build()
                )
                .collect(Collectors.toList());
        if (dtoList.isEmpty()) {
            throw new BusinessException(PhysicalConstants.REQUE_UNSUCCESS_CN);
        } else {
            return new Result<>(PhysicalConstants.REQUE_SUCCESS, PhysicalConstants.REQUE_SUCCESS_CN, dtoList);
        }
    }

    @Override
    public Result dynamicQuery(Pageable pageable, User user) {
        QUser qUser = QUser.user;
        //初始化组装条件(类似where 1=1)
        Predicate predicate =  qUser.isNotNull().or(qUser.isNull());
        //执行动态条件拼装
        predicate = user.getName() == null ? predicate :  ExpressionUtils.and( predicate,qUser.name.eq(user.getName()));
        predicate = user.getId() == null ? predicate :  ExpressionUtils.and( predicate,qUser.id.eq(user.getId()));
        predicate = user.getAge() == null ? predicate :  ExpressionUtils.and( predicate,qUser.age.eq(user.getAge()));
        predicate = user.getGender() == null ? predicate :  ExpressionUtils.and( predicate,qUser.gender.eq(user.getGender()));
        predicate = user.getBirthDay() == null ? predicate :  ExpressionUtils.and( predicate,qUser.birthDay.eq(user.getBirthDay()));
        predicate = user.getCreateTime() == null ? predicate :  ExpressionUtils.and( predicate,qUser.createTime.eq(user.getCreateTime()));
        List<User> list = jpaQueryFactory
                .selectFrom(qUser)
                .where(predicate)               //执行条件
                .groupBy(qUser.age)           //执行分组
                .having(qUser.age.between("10","50"))//10-50间
                .fetch();
        return new  Result<>(PhysicalConstants.REQUE_SUCCESS,PhysicalConstants.REQUE_SUCCESS_CN,list);
    }
}
