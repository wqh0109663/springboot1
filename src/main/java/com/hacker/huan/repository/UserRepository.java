package com.hacker.huan.repository;

import com.hacker.huan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wqh
 * @date 18-5-6
 */
public interface UserRepository extends JpaRepository<User,Long> {
    /**
     * 根据年龄查询所有用户
     * @param age 用户年龄
     * @return 用户集合
     */
    List<User> findByAge(Integer age);
//413889
}
