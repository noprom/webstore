package com.huntdreams.repository;

import com.huntdreams.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by noprom on 10/26/15.
 */
@Repository // 添加注解
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Modifying      // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    // 定义查询
    // @Param注解用于提取参数
    @Query("update UserEntity us set us.username=:qUsername,us.password=:qPassword where us.id=:qId")
    public void updateUser(@Param("qUsername") String username, @Param("qPassword") String password, @Param("qId") Integer id);
}