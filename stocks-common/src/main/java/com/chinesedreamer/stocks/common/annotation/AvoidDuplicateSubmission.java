package com.chinesedreamer.stocks.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 避免重复提交Annotation
 * 提交页面或者表单进入时增加 needSaveToken=true，表单提交后增加 needRemoveToken=true
 * @author Paris
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AvoidDuplicateSubmission {
	 boolean needSaveToken() default false;
	 boolean needRemoveToken() default false;
}
