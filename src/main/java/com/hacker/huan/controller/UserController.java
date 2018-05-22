package com.hacker.huan.controller;

import com.hacker.huan.entity.Result;
import com.hacker.huan.entity.User;
import com.hacker.huan.exception.UserException;
import com.hacker.huan.repository.UserRepository;
import com.hacker.huan.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wqh
 * @date 18-5-6
 */
@RestController
public class UserController {
    @Resource
    private UserRepository userRepository;
    @Resource
    private UserService userService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String sayHello() {
        return "hello   666666 ";
    }

    /**
     * 查找所有用户信息
     *
     * @return listUsers
     */
    @GetMapping("/users")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    /**
     * 添加一个用户
     *
     * @param id       用户id
     * @param username 用户名
     * @param password 用户密码
     * @param age      年龄
     * @return 用户对象
     */
    @PostMapping("/users")
    public Result addUser(@RequestParam("user_id") Long id,
                          @RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("age") Integer age) {
        return userService.addUserService(id, username, password, age);

    }

    /**
     * 根据id查找用户
     *
     * @param userId 用户id
     * @return user对象
     */
    @GetMapping("/users/{user_id}")
    public User getOneUser(@PathVariable("user_id") Long userId) {
        return userRepository.findById(userId).get();
    }

    /**
     * 修改用户信息
     *
     * @param useId    用户id
     * @param username 用户名
     * @param password 密码
     * @return 修改后的对象
     */

    @PutMapping("/users/{user_id}")
    public User updateUser(@PathVariable("user_id") Long useId, @RequestParam("username") String username,
                           @RequestParam("password") String password, @RequestParam("age") Integer age) {
        return userService.updateUserService(useId, username, password, age);
    }

    /**
     * 删除一个用户
     *
     * @param userId 用户ID
     */
    @DeleteMapping("/users/{user_id}")
    public void deleteUserById(@PathVariable("user_id") Long userId) {
        userRepository.deleteById(userId);
    }

    /**
     * 根据年龄查询
     *
     * @param age 用户年龄
     * @return 返回查询到的所有用户信息
     */
    @GetMapping("/users/age/{age}")
    public List<User> findByAge(@PathVariable("age") Integer age) {
        return userRepository.findByAge(age);
    }

    /**
     * 根据id查询年龄的信息
     * @param id 用户id
     * @throws UserException 异常
     */

    @GetMapping("/users/getAge/{id}")
    public void getAge(@PathVariable("id") Long id) throws UserException {
        userService.getAgeService(id);
    }


}
