package com.zyp.p2p.commons;

import com.zyp.commons.check.annotation.LengthValidata;
import com.zyp.commons.check.annotation.NotNull;
import com.zyp.commons.check.annotation.RegValidata;

public class Demo {
    @NotNull
    private String name;
    //密码长度在6到18位之间
    @LengthValidata(min = 6,max = 18)
    private String password;

    @RegValidata(value = "^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\\d{8}$")
    private String phonecode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonecode() {
        return phonecode;
    }

    public void setPhonecode(String phonecode) {
        this.phonecode = phonecode;
    }
}
