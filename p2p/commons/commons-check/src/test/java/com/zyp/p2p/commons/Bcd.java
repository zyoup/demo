package com.zyp.p2p.commons;

import com.zyp.commons.check.annotation.NotNull;
import com.zyp.p2p.commons.utils.code.ErrorCodeEnmu;

public class Bcd {
    @NotNull(name = ErrorCodeEnmu.USERNAME_NULL)
    private String name;

    @NotNull(name = ErrorCodeEnmu.PASSWORD_NULL)
    private String password;

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
}
