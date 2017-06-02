package com.hucode.study.controller;

import com.hucode.study.exception.UserNotFoundException;
import com.hucode.study.model.User;
import com.hucode.study.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by admin on 2017/5/31.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value="查找用户", notes="根据id查找User对象")
    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable("id") Integer userId) {
        User user = userService.getById(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        return user;
    }

    @ApiOperation(value="查找用户", notes="根据分页查找User对象")
    @PutMapping("/all")
    public List<User> getUserInfos(
            @RequestBody
                    User user) {
        List<User> list = userService.getAll(user);
        if (list.size() == 0) {
        }

        return list;
    }

    @ApiOperation(value="更新用户", notes="更新对应的User对象")
    @PutMapping("/{id}")
    public User updateUserInfo(
            @PathVariable("id")
                    Integer userId,
            @RequestBody
                    User newUser) {
        User user = userService.getById(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        user.setPhone(newUser.getPhone());
        user.setEmail(newUser.getEmail());
        userService.save(user);
        return user;
    }
}
