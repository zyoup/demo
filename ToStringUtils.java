package com.zyp.util;

import java.lang.reflect.Field;
public class ToStringUtils {

    /**
     * 该类中所有变量的toString打印显示（利用反射，动态获取该类中所有变量）
     * @return
     *
     * 注意：在使用时可去掉static
     */

    public String toString(){
        Class<? extends ToStringUtils> aClass = this.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Field declaredField : declaredFields) {
                String name = declaredField.getName();
                stringBuffer.append(name+"=");
                Object o = declaredField.get(this);
                stringBuffer.append(o+",  ");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
