package com.zyp.springboot.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.zyp.springboot.mybatis.mapper")
@EnableCaching
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
