package com.zyp.test.dubbo.service.impl;

import com.zyp.test.dubbo.service.TestService;
import org.springframework.stereotype.Service;

@Service("TestServiceImpl")
public class TestServiceImpl implements TestService {
    @Override
    public String test(String name) {
        return "test name ====>"+name;
    }
}
