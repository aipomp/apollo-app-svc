package com.apollo.appsvc.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *自定义注解 拦截Controller  
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemControllerLog {
	
    public static enum Operate {
        INSERT("新增数据"),
        UPDATE("更新数据"),
        DELETE("删除数据"),
        QUERY("查询数据"),
        NOTHING("");
        String value;

        Operate(String value) {
            this.value = value;
        }
        
        public String value() {
            return this.value;
        }
    }
	
	String module() default "";//模块名称

	Operate operateName() default Operate.NOTHING; //操作名称

	String description() default ""; //操作内容
	
	String className() default ""; // 类名称
	
	String methodName() default ""; // 方法名称
}
