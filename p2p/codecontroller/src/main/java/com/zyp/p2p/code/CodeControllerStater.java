package com.zyp.p2p.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages ={"com.zyp.p2p.code","com.zyp.p2p.commons"} )
public class CodeControllerStater {
    public static void main(String[] args) {
        SpringApplication.run(CodeControllerStater.class,args);
    }
}
