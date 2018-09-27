package com.zyp.springboot.mybatis.mapper;

import com.zyp.springboot.mybatis.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Insert("INSERT INTO `user` (`name`,password) VALUES(#{name},#{password})")
    void addUser(User user);
    @Select("SELECT * FROM `user` WHERE id=#{id}")
    User getUserById(int id);
    @Select("SELECT * FROM `user`")
    List<User> findUsers(int num, int size);
}
