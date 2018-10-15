package com.zyp.p2p.commons.utils.code;


import java.util.Random;

public class StringUtils {
    /**
     * 生成指定长度的随机字符串
     * @param length 指定的长度
     * @return
     */
    public static String getRandomString(int length){
        String s="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        int num=0;
        for (int i = 0; i < length; i++) {
            num= random.nextInt(s.length());
            stringBuffer.append(s.charAt(num));
        }
        return stringBuffer.toString();
    }
}
