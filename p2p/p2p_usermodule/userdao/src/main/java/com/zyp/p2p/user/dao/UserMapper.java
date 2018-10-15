package com.zyp.p2p.user.dao;

import com.zyp.p2p.user.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    @Insert("insert into member_user (name,password,passwordSalt,userTypeId,phone,createAt) values (#{name},#{password},#{passwordSalt},#{userId},#{phone},#{creatData})")
    void insertUser(User user);

//    @Update("update XXX set name =#abc and password=#123")
//    void update(@Param("abc")String name,@Param("123")String password);
}
