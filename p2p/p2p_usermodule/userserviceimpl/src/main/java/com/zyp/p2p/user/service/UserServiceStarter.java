package com.zyp.p2p.user.service;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@DubboComponentScan(basePackages = {"com.zyp.p2p.user.service.impl"})
//如果不在里面添加包的名字，默认会扫描本类所在包以及子包下面的内容
@DubboComponentScan
@ImportResource(value = {"classpath:mybatis.xml"})
@MapperScan(basePackages ={"com.zyp.p2p.user.dao"} )
public class UserServiceStarter {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceStarter.class,args);
    }
}
