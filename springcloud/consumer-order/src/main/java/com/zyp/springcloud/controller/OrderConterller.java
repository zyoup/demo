package com.zyp.springcloud.controller;

import com.zyp.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderConterller {
//    @Autowired
//    private EurekaClient eurekaClient;
    @Autowired
    private RestTemplate restTemplate;//spring提供的一个用于访问rest接口的模板对象
    @Value("${user.url}")
    private String url;
    @GetMapping("/order/{id}")
    public User getOrder(@PathVariable Long id){
        //访问提供者，获取数据
        User user = restTemplate.getForObject(url + id, User.class);
        return user;
    }
}
