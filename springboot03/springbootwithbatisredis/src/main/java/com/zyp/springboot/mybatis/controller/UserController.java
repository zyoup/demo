package com.zyp.springboot.mybatis.controller;


import com.zyp.springboot.mybatis.pojo.User;
import com.zyp.springboot.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/adduser")
    public String adduser(){
        User user = new User();
        user.setName("嘟嘟");
        user.setPassword("爱啦啦");
        userService.addUser(user);
        return "success";
    }


    @RequestMapping("/finduserbyid/{id}")
    public User getById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @RequestMapping("/finduser/{num}/{size}")
    public List<User> findUsers(@PathVariable int num,@PathVariable int size){
        List<User> users = userService.findUsers(num, size);
        return users;
    }

    @RequestMapping("/clear/{id}")
    public String clear(@PathVariable int id){
        userService.clearAll(id);
        return "hukaka";
    }
}
