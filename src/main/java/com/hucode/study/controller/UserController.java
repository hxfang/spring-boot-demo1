package com.hucode.study.controller;

import com.hucode.study.UserNotFoundException;
import com.hucode.study.dao.mapper.UserMapper;
import com.hucode.study.domain.User;
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

    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable("id") Long userId) {
        User user = userMapper.select(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        return user;
    }

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
