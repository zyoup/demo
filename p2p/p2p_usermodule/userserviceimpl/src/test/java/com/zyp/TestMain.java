package com.zyp;

import com.zyp.p2p.user.pojo.User;
import com.zyp.p2p.user.service.UserService;
import com.zyp.p2p.user.service.UserServiceStarter;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    //TODO错误的，，无法使用
    @Test
    public void test1() throws Exception {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(UserServiceStarter.class);
        UserService bean = annotationConfigApplicationContext.getBean(UserService.class);
        bean.register(new User());
    }
}
