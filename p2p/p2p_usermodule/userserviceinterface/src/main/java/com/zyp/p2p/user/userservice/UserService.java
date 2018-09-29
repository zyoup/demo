package com.zyp.p2p.user.userservice;

import com.zyp.p2p.commons.bean.result.ResultBean;
import com.zyp.p2p.user.pojo.User;


public interface UserService {
    ResultBean register(User user)throws Exception;
}
