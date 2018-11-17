package com.zyp.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.zyp.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderConterller {
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private RestTemplate restTemplate;//spring提供的一个用于访问rest接口的模板对象
    @Value("${user.url}")
    private String url;
    @GetMapping("/order/{id}")
    public User getOrder(@PathVariable Long id){
        //访问提供者，获取数据
        //  User user = restTemplate.getForObject(url + id, User.class);//通过访问 rest 获取到 json 数据,然后转换为 user 对象
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("provider-user", false);
        String homePageUrl = instanceInfo.getHomePageUrl();
        System.out.println(homePageUrl+"user/"+ id);
        User user = restTemplate.getForObject(homePageUrl+"user/"+ id, User.class);
        return user;
    }
}
