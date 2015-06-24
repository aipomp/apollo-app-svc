package com.apollo.appsvc.common.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.apollo.appsvc.common.exception.BusinessException;

/**
 * 
 *    
 * 项目名称：apollo-app-svc   
 * 类名称：BaseController   
 * 类描述：添加自己的异常处理逻辑，如日志记录   
 * 创建人：zhoult   
 * 创建时间：2015年6月23日 下午4:30:32   
 * @version
 */
public abstract class BaseController {
	private static Logger log = Logger.getLogger(BaseController.class);

	@ExceptionHandler
	public void exception(HttpServletRequest request, Exception ex) {
		//简短的错误信息
		String errInfo = "";
		
		log.error(ex.toString(),ex);

		// 根据不同的异常类型进行不同处理
		if (ex instanceof DataAccessException) {
			errInfo = "数据库操作失败！";
		} else if (ex instanceof NullPointerException) {
			errInfo = "调用了未经初始化的对象或者是不存在的对象！";
		} else if (ex instanceof IOException) {
			errInfo = "IO异常！";
		} else if (ex instanceof ClassNotFoundException) {
			errInfo = "指定的类不存在！";
		} else if (ex instanceof ArithmeticException) {
			errInfo = "数学运算异常！";
		} else if (ex instanceof ArrayIndexOutOfBoundsException) {
			errInfo = "数组下标越界!";
		} else if (ex instanceof IllegalArgumentException) {
			errInfo = "方法的参数错误！";
		} else if (ex instanceof ClassCastException) {
			errInfo = "类型强制转换错误！";
		} else if (ex instanceof SecurityException) {
			errInfo = "违背安全原则异常！";
		} else if (ex instanceof SQLException) {
			errInfo = "操作数据库异常！";
		} else if (ex.getClass().equals(NoSuchMethodError.class)) {
			errInfo = "方法末找到异常！";
		} else if (ex.getClass().equals(InternalError.class)) {
			errInfo = "Java虚拟机发生了内部错误";
		} else {
			errInfo = "程序内部错误，操作失败！" ;
		}
		// 添加自己的异常处理逻辑，如日志记录　　　
		request.setAttribute("exceptionMessage", ex.getMessage());
		throw new BusinessException(errInfo);
		
	}
}
