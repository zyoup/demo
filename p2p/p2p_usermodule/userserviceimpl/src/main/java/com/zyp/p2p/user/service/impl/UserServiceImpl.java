package com.zyp.p2p.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zyp.p2p.commons.bean.result.ResultBean;
import com.zyp.p2p.user.dao.UserMapper;
import com.zyp.p2p.user.pojo.User;
import com.zyp.p2p.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import java.io.Serializable;
import java.util.Date;

//相当于<dubbo:service interface=com.zyp.p2p.user.service.Uservice ref=""/>
 @Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService,Serializable {
     @Autowired
     private UserMapper userMapper;
    @Override
    public ResultBean register(User user) throws Exception {

        try {
            user.setCreatData(new Date());
            //获取原始密码
            //定义盐值和次数
            //生成md5
//            String s=DigestUtils.md5DigestAsHex("123".getBytes());
//            user.setPassword();
//            user.setPasswordSalt();
            userMapper.insertUser(user);
            return ResultBean.setOk(null);

        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultBean.setError(null);
    }
}
