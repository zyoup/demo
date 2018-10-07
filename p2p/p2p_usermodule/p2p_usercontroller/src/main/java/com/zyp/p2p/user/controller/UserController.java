package com.zyp.p2p.user.controller;

import com.zyp.p2p.commons.bean.result.ResultBean;
import com.zyp.p2p.user.pojo.User;
import com.zyp.p2p.user.userservice.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 *　　　　　　　　┏┓　　　┏┓+ +
 *　　　　　　　┏┛┻━━━┛┻┓ + +
 *　　　　　　　┃　　　　　　　┃
 *　　　　　　　┃　　　━　　　┃ ++ + + +
 *　　　　　　 ████━████ ┃+
 *　　　　　　　┃　　　　　　　┃ +
 *　　　　　　　┃　　　┻　　　┃
 *　　　　　　　┃　　　　　　　┃ + +
 *　　　　　　　┗━┓　　　┏━┛
 *　　　　　　　　　┃　　　┃
 *　　　　　　　　　┃　　　┃ + + + +
 *　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 *　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 *　　　　　　　　　┃　　　┃
 *　　　　　　　　　┃　　　┃　　+
 *　　　　　　　　　┃　 　　┗━━━┓ + +
 *　　　　　　　　　┃ 　　　　　　　┣┓
 *　　　　　　　　　┃ 　　　　　　　┏┛
 *　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 *　　　　　　　　　　┃┫┫　┃┫┫
 *　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 */
@RestController
@RequestMapping("/user")
public class UserController {
    //@Autowired
    //private UserService userService;

    @ApiOperation(value = "用户注册",response = ResultBean.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "name",required = true,value = "用户名",example = "嘟嘟"),
            @ApiImplicitParam(name = "password",required = true,value = "密码",example = "123"),
            @ApiImplicitParam(name = "userId",required = true,value = "用户ID",example = "001"),
            @ApiImplicitParam(name = "phone",required = true,value = "手机号",example = "15212247890"),
            @ApiImplicitParam(name = "imagecdoe",required = true,value = "图片验证码",example = "asgfs"),
            @ApiImplicitParam(name = "phonecode",required = true,value = "手机验证码",example = "vndjk"),
            @ApiImplicitParam(name = "confirmPassword",required = true,value = "确认密码",example = "123")})
    @RequestMapping("/register")
    public ResultBean register(@ApiIgnore User user,String imagecdoe,String phonecode,String confirmPassword){
        ResultBean resultBean = null;
        try {
            //resultBean = userService.register(user);
            String password = user.getPassword();
            if(password!=null||password!=confirmPassword){
                //密码有问题
            }
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultBean;
    }
}
