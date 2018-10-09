package com.zyp.p2p.user.controller;

import com.zyp.commons.check.annotation.CheckAnnotation;
import com.zyp.p2p.commons.bean.result.ResultBean;
import com.zyp.p2p.commons.redis.utils.RedisClientInterface;
import com.zyp.p2p.commons.utils.code.ErrorCodeEnmu;
import com.zyp.p2p.user.pojo.User;
import com.zyp.p2p.user.userservice.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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
    @Autowired
    private RedisClientInterface redisClient;

    //@Autowired
    //private UserService userService;

    @ApiOperation(value = "用户注册",response = ResultBean.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "name",required = true,value = "用户名",example = "嘟嘟"),
            @ApiImplicitParam(name = "password",required = true,value = "密码",example = "123"),
            @ApiImplicitParam(name = "userId",required = true,value = "用户ID",example = "001"),
            @ApiImplicitParam(name = "phone",required = true,value = "手机号",example = "15212247890"),
            @ApiImplicitParam(name = "imagecode",required = true,value = "图片验证码",example = "asgfs"),
            @ApiImplicitParam(name = "phonecode",required = true,value = "手机验证码",example = "vndjk"),
            @ApiImplicitParam(name = "confirmPassword",required = true,value = "确认密码",example = "123")})
    @RequestMapping("/register")
    public ResultBean register(@ApiIgnore User user, @ApiIgnore HttpServletRequest request, String imagecode, String phonecode, String confirmPassword){
        ResultBean resultBean = null;
        try {
            //resultBean = userService.register(user);
            String password = user.getPassword();
            Jedis jedis = redisClient.getJedis();
            //该验证码具有一次有效性，如果输入错了，需重新获取验证码
            String phone1 = user.getPhone();
            System.out.println(phone1);
            String phoneCodeRedis = redisClient.get(user.getPhone(), jedis);//获取在redis中存放的手机验证码
            //因为设置了一次有效性，所以在获取验证码之后需要删除数据
            redisClient.del(jedis,user.getPhone());
            String imageCodeRedis ="";
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if("yanzhengma".equals(cookie.getName())){
                        imageCodeRedis = redisClient.get(cookie.getValue(), jedis);
                        redisClient.del(jedis,cookie.getValue());
                    }
                }
            }
            jedis.close();


            if(password==null||!password.equals(confirmPassword)){
                //密码有问题
                resultBean = ResultBean.setError(ErrorCodeEnmu.PASSWORD_NOT_MATCH.getValue(), "两次密码不一致", null);
            }else if(imageCodeRedis==null||"".equals(imageCodeRedis.trim())||!imageCodeRedis.equalsIgnoreCase(imagecode)){
                resultBean=ResultBean.setError(ErrorCodeEnmu.IMAGECODE_NOT_MATCH.getValue(),"图片验证码错误",null);
            }else if(phoneCodeRedis==null||!phoneCodeRedis.equalsIgnoreCase(phonecode)){
                resultBean=ResultBean.setError(ErrorCodeEnmu.PHONE_NUM_ERNOTMATCH.getValue(),"手机验证码错误",null);
            }
//            resultBean=CheckAnnotation.check(user);
//            if(resultBean.getCode()==null){
//
//            }
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultBean;
    }
}
