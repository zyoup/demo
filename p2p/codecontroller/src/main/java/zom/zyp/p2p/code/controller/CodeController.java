package zom.zyp.p2p.code.controller;

import cn.dsna.util.images.ValidateCode;
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
public class CodeController {
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

    @GetMapping("/phonecode/{phonenum}")
    public String getPhoneCode(@PathVariable(name = "phonenum") String num){
        ValidateCode validateCode = new ValidateCode(160,40,5,100);
        String code = validateCode.getCode();
        return code;
    }

}
