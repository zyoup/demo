package com.zyp.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.zyp.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        return new User(id);
    }

    @GetMapping("/eurekainfo")
    public String info(){
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("provider-user", false);
        return instanceInfo.getHomePageUrl();
    }
//暂时未用到的代码
//    @GetMapping("/get-user")
//    public User getUser(User user){
//        //相当于我们传递的是一个复杂的参数会被封装成user对象，然后我们将封装的对象返回，也就是你传递什么我返回什么
//        return user;
//    }
}
