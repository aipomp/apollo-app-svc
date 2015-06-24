package com.apollo.appsvc.common.aop;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apollo.appsvc.common.annotation.SystemControllerLog;
import com.apollo.appsvc.common.annotation.SystemServiceLog;
import com.apollo.appsvc.common.bean.SystemLog;
import com.apollo.appsvc.common.service.LogService;

/** 
 * 日志记录，添加、删除、修改方法AOP 
 * @author HotStrong 
 *  
 */  
@Aspect
@Component
public class LogAspect {

    private static Logger logger  = Logger.getLogger(LogAspect.class);
    
    @Autowired  
    private LogService logService;//日志记录Service

    // Service Tier Pointcut
    @Pointcut("@annotation(com.apollo.appsvc.common.annotation.SystemServiceLog)")
    public void serviceAspect() { }
    
    @Before(value="serviceAspect()")
    public void serviceCallBefore(JoinPoint joinPoint) throws Throwable {
        logger.debug("LogAspect.serviceCallBefore ...");
        logService.logCallBefore(getServiceMethodDescription(joinPoint));
    }

    @After(value="serviceAspect()")
    public void serviceCallAfter(JoinPoint joinPoint) throws Throwable {
        logger.debug("LogAspect.serviceCallAfter ...");
        logService.logCallAfter(getServiceMethodDescription(joinPoint));
    }

    @AfterReturning(value="serviceAspect()", argNames="rtv", returning="rtv")
    public void serviceAfterReturning(JoinPoint joinPoint, Object rtv) throws Throwable {
        logger.debug("LogAspect.serviceAfterReturning ...");
        logService.logAfterReturning(getServiceMethodDescription(joinPoint));
    }

    @AfterThrowing(value="serviceAspect()", throwing="e")
    public void serviceAfterThrowing(JoinPoint joinPoint, Throwable e) throws Throwable {
        logger.debug("LogAspect.serviceAfterThrowing ...");
        logService.logAfterThrowing(getServiceMethodDescription(joinPoint));
    }

    // Controller Tier Pointcut
    @Pointcut("@annotation(com.apollo.appsvc.common.annotation.SystemControllerLog)")
    public void controllerAspect() { }

    @Before(value="controllerAspect()")
    public void controllerCallBefore(JoinPoint joinPoint) throws Throwable {
        logger.debug("LogAspect.controllerCallBefore ...");
        logService.logCallBefore(getControllerMethodDescription(joinPoint));
    }

    @After(value="controllerAspect()")
    public void controllerCallAfter(JoinPoint joinPoint) throws Throwable {
        logger.debug("LogAspect.controllerCallAfter ...");
        logService.logCallAfter(getControllerMethodDescription(joinPoint));
    }

    @AfterReturning(value="controllerAspect()", argNames="rtv", returning="rtv")
    public void controllerAfterReturning(JoinPoint joinPoint, Object rtv) throws Throwable {
        logger.debug("LogAspect.controllerAfterReturning ...");
        logService.logAfterReturning(getControllerMethodDescription(joinPoint));
    }

    @AfterThrowing(value="controllerAspect()", throwing="e")
    public void controllerAfterThrowing(JoinPoint joinPoint, Throwable e) throws Throwable {
        logger.debug("LogAspect.controllerAfterThrowing ...");
        logService.logAfterThrowing(getControllerMethodDescription(joinPoint));
    }

    /**
     * 获取注解中对方法的描述信息 用于service层注解  
     *
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */
     public static SystemLog getServiceMethodDescription(JoinPoint joinPoint)
             throws Exception {
        SystemLog systemLog = null;
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class<?> targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        SystemServiceLog annotation;
        for (Method method : methods) {    
             if (method.getName().equals(methodName)) {
                Class<?>[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    annotation = method.getAnnotation(SystemServiceLog. class);
                    systemLog = new SystemLog(annotation.module(), annotation.operateName().value(), annotation.description(), 
                            annotation.className(), annotation.methodName());
                    break;
                }
            }
        }
        return systemLog;
    }
    
     /**  
      * 获取注解中对方法的描述信息 用于Controller层注解  
      *  
      * @param joinPoint 切点  
      * @return 方法描述  
      * @throws Exception  
      */    
    public static SystemLog getControllerMethodDescription(JoinPoint joinPoint)
            throws Exception {
        SystemLog systemLog = null;
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class<?> targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        SystemControllerLog annotation;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class<?>[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    annotation = method.getAnnotation(SystemControllerLog. class);
                    systemLog = new SystemLog(annotation.module(), annotation.operateName().value(), annotation.description(), 
                                              annotation.className(), annotation.methodName());
                    break;
                }
            }
        }
        return systemLog;    
    }
}
