package com.zyp.p2p.user.service.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceConfig {
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("TTT");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        //registryConfig.setAddress("zookeeper://10.9.251.200:8091");
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
        return registryConfig;
    }

//    @Bean
//    public ConsumerConfig consumerConfig(){
//        ConsumerConfig consumerConfig=new ConsumerConfig();
//        consumerConfig.setTimeout(3000);
//        return consumerConfig();
//    }

    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(23488);
        return protocolConfig;
    }



}
