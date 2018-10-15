package com.zyp;

import com.zyp.p2p.user.pojo.User;
import com.zyp.p2p.user.service.UserService;
import com.zyp.p2p.user.service.UserServiceStarter;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.DigestUtils;

public class TestMain {
    //TODO错误的，，无法使用
    @Test
    public void test1() throws Exception {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(UserServiceStarter.class);
        UserService bean = annotationConfigApplicationContext.getBean(UserService.class);
        bean.register(new User());
    }

    @Test
    public void test2(){
        String s = DigestUtils.md5DigestAsHex("123".getBytes());
        System.out.println(s);
    }

    @Test
    public void test3(){
        ByteSource bytes = ByteSource.Util.bytes("123");
        SimpleHash md5 = new SimpleHash("MD5", "123", bytes, 1024);
        System.out.println(md5);
    }
}
