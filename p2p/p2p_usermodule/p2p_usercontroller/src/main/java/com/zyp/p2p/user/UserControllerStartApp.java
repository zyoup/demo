package com.zyp.p2p.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.zyp.p2p.user","com.zyp.p2p.commons"})
public class UserControllerStartApp {
    public static void main(String[] args) {
        SpringApplication.run(UserControllerStartApp.class, args);
    }
}
