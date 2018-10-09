package com.zyp.p2p.commons.utils.code;
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

/**
 * 老师使用interface写的，我是使用枚举实验的
 */
public enum ErrorCodeEnmu {
    USERNAME_NULL("10000"),//用户名为空
    PASSWORD_NULL("10001"),//密码为空
    USERNAME_OR_PASSWORD_WRONG("10002"),//用户名和密码错误
    LENGTH_EORR("10003"),//用户传递的长度不对
    PHONE_NUM_ERNOTMATCH("10004"),//手机格式不对
    PASSWORD_NOT_MATCH("10005"),//两次密码不一致
    IMAGECODE_NOT_MATCH("10006"),//图片验证码不一致
    PHONECODE_NOT_MATCH("10007"),//手机验证码不一致
    UNKNOWN_ERROR("0"),//未知错误，或者是不需要告诉用户具体错误内容的错误
    SUCCESS("1");//成功

    private final String value;

    ErrorCodeEnmu(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
