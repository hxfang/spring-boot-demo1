package com.hucode.study.controller;

import com.hucode.study.exception.UserNotFoundException;
import com.hucode.study.dao.mapper.UserMapper;
import com.hucode.study.domain.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by admin on 2017/5/31.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value="查找用户", notes="根据id查找User对象")
    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable("id") Long userId) {
        User user = userMapper.select(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        return user;
    }

    @ApiOperation(value="更新用户", notes="更新对应的User对象")
    @PutMapping("/{id}")
    public User updateUserInfo(
            @PathVariable("id")
                    Long userId,
            @RequestBody
                    User newUser) {
        User user = userMapper.select(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        user.setPhone(newUser.getPhone());
        user.setEmail(newUser.getEmail());
        userMapper.update(user);
        return user;
    }
}
