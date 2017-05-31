package com.hucode.study.dao.mapper;

import com.hucode.study.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by admin on 2017/5/31.
 */

@Mapper
public interface UserMapper {

    User select(@Param("id") long id);

    void update(User user);
}
