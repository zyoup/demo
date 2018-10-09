package com.zyp.p2p.commons.redis.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 声明该注解的作用是忽略redis,凡是被此注解修饰的属性,都不会被放到redis中
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SkipRedis {
}
