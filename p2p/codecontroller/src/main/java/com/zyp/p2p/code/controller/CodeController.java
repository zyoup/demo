package com.zyp.p2p.code.controller;

import cn.dsna.util.images.ValidateCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/code")
@Api("验证码相关的api")
public class CodeController {
    @ApiOperation(value = "图片验证码")
    @GetMapping("/imagecode")
    public void getImageCode(HttpServletResponse response){
        ValidateCode validateCode = new ValidateCode();
        String code = validateCode.getCode();//验证码的字符串
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
        return code;
    }

}
