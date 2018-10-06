package com.zyp.p2p.commons.bean.result;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ResultBean implements Serializable {
    private String code;
    private String message;
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toString(){
        Class<? extends ResultBean> aClass = this.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Field declaredField : declaredFields) {
                String name = declaredField.getName();
                stringBuffer.append(name+"=");
                Object o = declaredField.get(this);//该方法破坏封装性
               // PropertyDescriptor propertyDescriptor = new PropertyDescriptor(declaredField.getName(),aClass);
               // Method readMethod = propertyDescriptor.getReadMethod();
                //Object o = readMethod.invoke(this, null);

                stringBuffer.append(o+",  ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
