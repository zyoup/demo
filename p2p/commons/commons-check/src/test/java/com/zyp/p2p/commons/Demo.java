package com.zyp.p2p.commons;

import com.zyp.commons.check.annotation.CaseCade;
import com.zyp.commons.check.annotation.LengthValidata;
import com.zyp.commons.check.annotation.NotNull;
import com.zyp.commons.check.annotation.RegValidata;
import com.zyp.p2p.commons.utils.code.ErrorCodeEnmu;


public class Demo {
    @NotNull(name = ErrorCodeEnmu.USERNAME_NULL)
    private String name;
    //密码长度在6到18位之间
    @LengthValidata(min = 6,max = 18,name = ErrorCodeEnmu.LENGTH_EORR)
    private String password;

    @RegValidata(value = "^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\\d{8}$",name = ErrorCodeEnmu.PHONE_NUM_ERNOTMATCH)
    private String phonecode;

    @CaseCade
    private Bcd bcd;

    public Bcd getBcd() {
        return bcd;
    }

    public void setBcd(Bcd bcd) {
        this.bcd = bcd;
    }

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
