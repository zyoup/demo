package com.zyp.p2p.code.controller;

import cn.dsna.util.images.ValidateCode;
import com.zyp.p2p.commons.redis.utils.RedisClientInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;


import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/code")
@Api("验证码相关的api")
public class CodeController {
    @Autowired
    private RedisClientInterface redisClient;

    @ApiOperation(value = "图片验证码")
    @GetMapping("/imagecode")
    public void getImageCode(HttpServletRequest request, HttpServletResponse response){
        ValidateCode validateCode = new ValidateCode();
        String code = validateCode.getCode();//验证码的字符串
        String key=null;//设置验证码的key值
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if("yanzhengma".equals(cookie.getName())){
                    key=cookie.getValue();
                }
            }
        }
        if(key==null){
            key=UUID.randomUUID().toString();
            Cookie cookie = new Cookie("yanzhengma", key);
            cookie.setPath("/");//设置cookie的有效路径为当前项目下所有地址
            response.addCookie(cookie);
        }
        Jedis jedis = redisClient.getJedis();
        redisClient.set(key,code,jedis);
        redisClient.expire(key,1200,jedis);//设置有效期为1分钟
        if(jedis!=null){
            jedis.close();
        }
        BufferedImage buffImg = validateCode.getBuffImg();
        try {
            ImageIO.write(buffImg,"jpeg",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @ApiOperation(value = "手机验证码")
    @ApiImplicitParam(name = "phonenum",value = "手机号",required =true,example = "15212247890",type = "String")
    @GetMapping("/phonecode/{phonenum}")
    public String getPhoneCode(@PathVariable(name = "phonenum") String num){
        ValidateCode validateCode = new ValidateCode(160,40,5,100);
        String code = validateCode.getCode();
        Jedis jedis = redisClient.getJedis();
        redisClient.set(num,code,jedis);
        System.out.println("+++++++++++++++++++++++"+num);
        System.out.println(redisClient.get(num,jedis));
        redisClient.expire(num,1200,jedis);
        if (jedis != null) {
            jedis.close();
        }
        return code;
    }

}
