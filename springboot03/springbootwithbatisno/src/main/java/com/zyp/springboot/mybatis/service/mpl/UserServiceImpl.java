package com.zyp.springboot.mybatis.service.mpl;

import com.github.pagehelper.PageHelper;
import com.zyp.springboot.mybatis.mapper.UserMapper;
import com.zyp.springboot.mybatis.pojo.User;
import com.zyp.springboot.mybatis.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
   @Autowired
   private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> findUsers(int num, int size) {
        PageHelper.startPage(num,size);
        return userMapper.findUsers(num,size);
    }

    //public User findUserByNameAndPasseord(@Param("name") String name,@Param("password") String password);
}
