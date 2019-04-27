package com.aygxy.jpa.repository;

import com.aygxy.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Description: user实体数据查询
 * @Author: xmf
 * @Date: 2019/4/7-12:53
 */
@Repository
public interface UserRepository extends JpaRepository<User,String>{

    @Modifying
    @Transactional
    @Query("delete from User s where s.id in (?1)")
    void deleteAll(List<String> ids);

    Optional<User> findByCode(String code);
}
