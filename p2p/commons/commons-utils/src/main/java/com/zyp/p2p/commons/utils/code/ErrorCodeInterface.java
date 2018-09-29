package com.zyp.p2p.commons.utils.code;
//
//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                            O\ = /O
//                        ____/`---'\____
//                      .   ' \\| |// `.
//                       / \\||| : |||// \
//                     / _||||| -:- |||||- \
//                       | | \\\ - /// | |
//                     | \_| ''\---/'' | |
//                      \ .-\__ `-` ___/-. /
//                   ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                 \ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//
//         .............................................
//                  佛祖镇楼                  BUG辟易

/**
 * 老师那傻逼使用interface写的，我是使用枚举实验的
 */
public enum ErrorCodeInterface {
    USERNAMENULL("10000"),PASSWORDNULL("10001"),USERNAMEORPASSWORDWRONG("10002"),
    LENGTHSUIBIAN("10003"),PHONENUMERNOTMATCH("10004");

    private final String value;

    ErrorCodeInterface(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
