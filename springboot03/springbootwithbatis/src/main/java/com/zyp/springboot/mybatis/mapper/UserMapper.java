package com.zyp.springboot.mybatis.mapper;

import com.zyp.springboot.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    void addUser(User user);

    User getUserById(int id);

    List<User> findUsers(int num, int size);
}
