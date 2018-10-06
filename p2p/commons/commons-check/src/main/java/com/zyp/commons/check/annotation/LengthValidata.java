package com.zyp.commons.check.annotation;

import com.zyp.p2p.commons.utils.code.ErrorCodeEnmu;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LengthValidata {
    int min() default 0;
    int max() default Integer.MAX_VALUE;
    //String code();//错误码
    ErrorCodeEnmu name();

}
