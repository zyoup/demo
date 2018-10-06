package com.zyp.commons.check.annotation;

import com.zyp.p2p.commons.bean.result.ResultBean;
import com.zyp.p2p.commons.utils.code.ErrorCodeEnmu;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CheckAnnotation {
    /**
     * 传递一个对象给我，我帮你把里面的数据校验注解处理一下
     *
     */

    public static ResultBean check(Object object) {
        //Map<String,String> checkMap=new ConcurrentHashMap<>();
        ResultBean resultBean = new ResultBean();
        //我们如何知道对象中有什么对象
        Class aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println(field);
//        }
        //检查是否符合规范
        Boolean isCheck=false;
        //我们如何知道这个变量上有什么注释
        for (Field field : fields) {
            //field是每个变量
            NotNull notNull = field.getAnnotation(NotNull.class);//获取变量上有没有不为空的注解
            if (notNull != null) {
                try {
                    //从aClass上面找field.getName（）这个名字的属性
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), aClass);
                    if(propertyDescriptor!=null){
                        Method readMethod = propertyDescriptor.getReadMethod();
                        if(readMethod!=null){
                            Object invoke = readMethod.invoke(object, null);//获取变量的值
                            boolean empty = isEmpty(invoke);
                            if(empty){
                                //String code = notNull.code();//错误码
                                ErrorCodeEnmu value = notNull.name();
                                String code = value.getValue();
                                resultBean.setCode(code);
                                //checkMap.put(field.getName(),"不能为空");
                                isCheck=true;
                                break;
                            }
                        }
                    }
                    //以下方法会破坏代码的封装性
//                    Object obj = field.get(object);
//                    boolean empty = isEmpty(obj);
//                    if(empty){
//                        checkMap.put(field.getName(),"不能为空");
//                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(!isCheck){
                LengthValidata lengthValidata = field.getAnnotation(LengthValidata.class);
                if(lengthValidata!=null){
                    try {
                        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), aClass);
                        if(propertyDescriptor!=null){
                            Method readMethod = propertyDescriptor.getReadMethod();
                            if(readMethod!=null){
                                Object invoke = readMethod.invoke(object);//获取变量的值
                                int min = lengthValidata.min();
                                int max = lengthValidata.max();
                                boolean b = checkLength(invoke, min, max);
                                if(!b){
                                    ErrorCodeEnmu value = lengthValidata.name();
                                    String code = value.getValue();
                                    resultBean.setCode(code);
                                    //checkMap.put(field.getName(),"长度不符合要求");
                                    isCheck=true;
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if(!isCheck){
                RegValidata regValidata = field.getAnnotation(RegValidata.class);
                if(regValidata!=null){
                    try {
                        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), aClass);
                        if(propertyDescriptor!=null){
                            Method readMethod = propertyDescriptor.getReadMethod();
                            if(readMethod!=null){
                                Object invoke = readMethod.invoke(object, null);
                                boolean b=checkReg(invoke,regValidata.value());
                                if(!b){
                                    resultBean.setCode(regValidata.name().getValue());
                                    //checkMap.put(field.getName(),"内容不符合规范");
									isCheck=true;
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if(!isCheck){
                CaseCade caseCade = field.getAnnotation(CaseCade.class);
                if (caseCade != null) {
                    try {
                        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), aClass);
                        if(propertyDescriptor!=null){
                            Method readMethod = propertyDescriptor.getReadMethod();
                            if(readMethod!=null){
                                Object invoke = readMethod.invoke(object,null);
                                if(invoke!=null){
                                    resultBean=check(invoke);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return resultBean;
    }










    @Deprecated
    public static Map<String,String> check1(Object object) {
        Map<String,String> checkMap=new ConcurrentHashMap<>();
        //我们如何知道对象中有什么对象
        Class aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println(field);
//        }
        //检查是否符合规范
        Boolean isCheck=false;
        //我们如何知道这个变量上有什么注释
        for (Field field : fields) {
            //field是每个变量
            NotNull notNull = field.getAnnotation(NotNull.class);//获取变量上有没有不为空的注解
            if (notNull != null) {
                try {
                    //从aClass上面找field.getName（）这个名字的属性
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), aClass);
                    if(propertyDescriptor!=null){
                        Method readMethod = propertyDescriptor.getReadMethod();
                        if(readMethod!=null){
                            Object invoke = readMethod.invoke(object, null);//获取变量的值
                            boolean empty = isEmpty(invoke);
                            if(empty){
                                checkMap.put(field.getName(),"不能为空");
                                isCheck=true;
                                break;
                            }
                        }
                    }
                    //以下方法会破坏代码的封装性
//                    Object obj = field.get(object);
//                    boolean empty = isEmpty(obj);
//                    if(empty){
//                        checkMap.put(field.getName(),"不能为空");
//                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(!isCheck){
                LengthValidata lengthValidata = field.getAnnotation(LengthValidata.class);
                if(lengthValidata!=null){
                    try {
                        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), aClass);
                        if(propertyDescriptor!=null){
                            Method readMethod = propertyDescriptor.getReadMethod();
                            if(readMethod!=null){
                                Object invoke = readMethod.invoke(object);//获取变量的值
                                int min = lengthValidata.min();
                                int max = lengthValidata.max();
                                boolean b = checkLength(invoke, min, max);
                                if(!b){
                                    checkMap.put(field.getName(),"长度不符合要求");
                                    isCheck=true;
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if(!isCheck){
                RegValidata regValidata = field.getAnnotation(RegValidata.class);
                if(regValidata!=null){
                    try {
                        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), aClass);
                        if(propertyDescriptor!=null){
                            Method readMethod = propertyDescriptor.getReadMethod();
                            if(readMethod!=null){
                                Object invoke = readMethod.invoke(object, null);
                                boolean b=checkReg(invoke,regValidata.value());
                                if(!b){
                                    checkMap.put(field.getName(),"内容不符合规范");
                                }
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return checkMap;
    }

    /**
     * 验证正则表达式
     * @param invoke
     * @param value
     * @return 满足正则表达式条件则返回true，否则返回false
     */
    private static boolean checkReg(Object invoke, String value) {
        if(invoke==null){
            return false;
        }else {
            return invoke.toString().matches(value);
        }
    }

    /**
     * 判断是否为空
     * @param obj
     * @return obj为null或都是空格组成的字符串都返回true，否则犯规true
     */
    private static boolean isEmpty(Object obj){
        if(obj==null){
            return true;
        }else {
            String s = obj.toString();
            return "".equals(s.trim());
        }
    }

    /**
     * 校验长度
     * @param obj
     * @param min
     * @param max
     * @return 当obj的长度大于等于规定最小值并且小于等于最大值，才返回true，其他条件都返回false
     */
    private static boolean checkLength(Object obj,int min,int max){
        if(obj==null){
            return false;
        }else{
            String s = obj.toString();
            int length = s.length();
            return length>=min && length<=max;
        }
    }
}
