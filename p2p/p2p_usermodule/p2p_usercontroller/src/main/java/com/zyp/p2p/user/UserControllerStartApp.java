package com.zyp.p2p.user;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.zyp.p2p.user","com.zyp.p2p.commons"})
@DubboComponentScan
public class UserControllerStartApp {
    public static void main(String[] args) {
        SpringApplication.run(UserControllerStartApp.class, args);
    }

    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("XXX");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
//        registryConfig.setAddress("10.9.251.200:8091");
//        registryConfig.setProtocol("zookeeper");
        //上面两行等于以下写法
        registryConfig.setAddress("zookeeper://10.9.251.200:8091");
        return registryConfig;
    }

}
