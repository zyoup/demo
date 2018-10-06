package com.zyp.p2p.commons;

import com.zyp.commons.check.annotation.CheckAnnotation;
import com.zyp.p2p.commons.bean.result.ResultBean;
import org.junit.Test;

import java.util.Map;

public class TestDemo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.setName("a");
        demo.setPassword("1234567");
        demo.setPhonecode("15212247890");
        //Map<String, String> check = CheckAnnotation.check(demo);
        Bcd bcd = new Bcd();
        bcd.setName("a");
        bcd.setPassword("ad");
        demo.setBcd(bcd);


        ResultBean check = CheckAnnotation.check(demo);
        System.out.println(check);
    }
}
