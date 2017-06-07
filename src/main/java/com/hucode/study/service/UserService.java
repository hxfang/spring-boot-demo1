package com.hucode.study.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageRowBounds;
import com.hucode.study.mapper.UserMapper;
import com.hucode.study.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2017/6/2.
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAll(User user) {
        PageRowBounds pageRowBounds = null;
        if (user.getPage() != null && user.getRows() != null) {
            PageHelper.startPage(user.getPage(), user.getRows());
        }
        return userMapper.selectAll();
    }

    public User getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Transactional(noRollbackFor={IllegalArgumentException.class})
    public void save(User user) {
        if (user.getId() != null && user.getId() != 0) {
            userMapper.updateByPrimaryKey(user);
        } else {
            userMapper.insert(user);
        }
        if(user.getPassword().length() < 6){
            throw new IllegalArgumentException("User'password is not short!");
        }
    }
}
