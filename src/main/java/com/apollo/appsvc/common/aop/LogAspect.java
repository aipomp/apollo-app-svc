package com.apollo.appsvc.common.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    
    /** 
     * 添加业务逻辑方法切入点 
     */  
    @Pointcut("execution(* com.apollo.appsvc.*.service.impl.*.insert*(..))")
    public void insertServiceCall() { }
    
    @Before(value="insertServiceCall()")
    public void insertServiceCallBefore() throws Throwable{
        logger.debug("LogAspect.insertServiceCallBefore before ...");
        logService.log(null);
    }
    
    @After(value="insertServiceCall()")
    public void insertServiceCallAfter() throws Throwable{
        logger.debug("LogAspect.insertServiceCallAfter after ...");
        logService.log(null);
    }
    
    /** 
     * 管理员添加操作日志(后置通知) 
     * @param joinPoint 
     * @param rtv 
     * @throws Throwable 
     */  
    @AfterReturning(value="insertServiceCall()", argNames="rtv", returning="rtv")
    public void insertServiceCallAfterReturning(JoinPoint joinPoint, Object rtv) throws Throwable{
        logger.debug("LogAspect.insertServiceCall after returning ...");
        logService.log(null);
    }

    //Controller层切点    
    @Pointcut("@annotation(com.apollo.appsvc.common.annotation.SystemControllerLog)")
    public void controllerAspect() { }
    
    @Before(value="controllerAspect()")
    public void controllerServiceCallBefore() throws Throwable{
        logger.debug("LogAspect.controllerServiceCallBefore before ...");
        logService.log(null);
    }
    
    @After(value="controllerAspect()")
    public void controllerServiceCallAfter() throws Throwable{
        logger.debug("LogAspect.controllerServiceCallAfter after ...");
        logService.log(null);
    }
    
    /** 
     * 管理员添加操作日志(后置通知) 
     * @param joinPoint 
     * @param rtv 
     * @throws Throwable 
     */  
    @AfterReturning(value="controllerAspect()", argNames="rtv", returning="rtv")
    public void controllerServiceCallAfterReturning(JoinPoint joinPoint, Object rtv) throws Throwable{
        logger.debug("LogAspect.controllerServiceCallAfterReturning after returning ...");
        logService.log(null);
    }
}
