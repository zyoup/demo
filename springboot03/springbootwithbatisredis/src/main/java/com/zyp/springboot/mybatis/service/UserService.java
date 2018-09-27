package com.zyp.springboot.mybatis.service;

import com.zyp.springboot.mybatis.pojo.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    User getUserById(int id);

    List<User> findUsers(int num, int size);
    public void clearAll(int id);
}
