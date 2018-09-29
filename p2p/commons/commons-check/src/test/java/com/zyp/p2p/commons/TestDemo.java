package com.zyp.p2p.commons;

import com.zyp.commons.check.annotation.CheckAnnotation;
import org.junit.Test;

import java.util.Map;

public class TestDemo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.setName("a");
        demo.setPassword("123456789");
        demo.setPhonecode("15212247890");
        Map<String, String> check = CheckAnnotation.check(demo);
        System.out.println(check);
    }
}
