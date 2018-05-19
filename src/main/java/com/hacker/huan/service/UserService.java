package com.hacker.huan.service;

import com.hacker.huan.entity.Result;
import com.hacker.huan.entity.User;
import com.hacker.huan.enumeration.ResultEnum;
import com.hacker.huan.exception.UserException;
import com.hacker.huan.repository.UserRepository;
import com.hacker.huan.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wqh
 * @date 18-5-6
 */

@Service
public class UserService {
    @Resource
    private UserRepository repository;
    private final static Integer AGE_MIN = 12;
    private final static Integer AGE_OK = 18;

    /**
     * @param id 用户ID
     * @throws UserException 异常
     */
    public void getAgeService(Long id) throws UserException {
        User user = repository.getOne(id);
        Integer age = user.getAge();
        if (age < AGE_MIN) {
            throw new UserException(ResultEnum.TOO_YOUNG);
        } else if (age > AGE_MIN && age < AGE_OK) {
            throw new UserException(ResultEnum.READ_BOOK);
        }

    }

    /**
     * @param id       用户ID
     * @param username 用户名
     * @param password 密码
     * @param age      年龄
     * @return Result
     */

    public Result addUserService(Long id, String username, String password, Integer age) {
        User user = new User();
        user.setUserId(id);
        user.setAge(age);
        user.setUsername(username);
        user.setPassword(password);
        return ResultUtil.success(repository.saveAndFlush(user));
    }

    /**
     * @param useId    用户ID
     * @param username 用户名
     * @param password 密码
     * @param age      年龄
     * @return User
     */
    public User updateUserService(Long useId, String username, String password, Integer age) {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        user.setUserId(useId);
        user.setAge(age);
        return repository.saveAndFlush(user);
    }

}
