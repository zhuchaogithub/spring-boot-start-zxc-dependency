package com.zxc.ratelimit.annotation;

import com.zxc.ratelimit.interceptor.AccessLimitInterceptor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Inherited
@Documented
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Import(AccessLimitInterceptor.class)
public @interface AccessLimit {
	//标识 指定sec时间段内的访问次数限制
	int limit() default 5;
	//标识 时间段
	int sec()  default 5;

}
