package com.zyp.p2p.weixin.payment.controller.utils;

public class PayConfigUtil {
    public static String APP_ID = "wx632c8f211f8122c6";//微信公众id
    public static String MCH_ID = "1497984412";//微信商户id
    public static String API_KEY = "sbNCm1JnevqI36LrEaxFwcaT0hkGxFnC";//签名用的key,微信给的
    public static String UFDOOER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";//统一下单地址
    public static String NOTIFY_URL = "http://pic.chenjunbo.xin/payment/result";//回调url,支付成功后微信会在他们服务器内部请求该地址,将结果告诉我们,所以该地址必须是公网可访问地址
    public static String CREATE_IP = "114.242.26.51";//发起支付的ip,此ip正常来说可以使用用户手机ip或者其他ip,取决于公司自己的决定
}
