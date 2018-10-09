package com.zyp.p2p.user.pojo;



import com.zyp.commons.check.annotation.NotNull;
import com.zyp.commons.check.annotation.RegValidata;
import com.zyp.p2p.commons.redis.utils.SkipRedis;

import java.io.Serializable;

public class User implements Serializable {
    private String id;//主键
    private String name;//用户名
    @SkipRedis
    private String password;//密码
    private String passwordSalt;//密码的盐
    private int userId;//用户ID
    private String phone;//手机号
    private String creatData;//创建日期

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreatData() {
        return creatData;
    }

    public void setCreatData(String creatData) {
        this.creatData = creatData;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", passwordSalt='" + passwordSalt + '\'' +
                ", userId=" + userId +
                ", phone='" + phone + '\'' +
                ", creatData='" + creatData + '\'' +
                '}';
    }
}
