package com.zyp.p2p.weixin.payment.controller;

import com.zyp.p2p.weixin.payment.controller.utils.PayCommonUtil;
import com.zyp.p2p.weixin.payment.controller.utils.ZxingUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

@RestController
public class PayMentController {
    @RequestMapping("/chongzhi")
    public void chongzhi(HttpServletResponse response)throws Exception{
        String orderId="wakaka";//订单号
        String body="嘟嘟爱啦啦";//正文
        String price="100";//金额，单位 分
        String urlcode = PayCommonUtil.weixin_pay(price, body, orderId);

        //跳转到支付页面
        BufferedImage image = ZxingUtil.createImage(urlcode, 300, 300);
        ImageIO.write(image,"jpeg",response.getOutputStream());
    }
}
