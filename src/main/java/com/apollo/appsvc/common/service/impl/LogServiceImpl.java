package com.apollo.appsvc.common.service.impl;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apollo.appsvc.common.annotation.SystemControllerLog;
import com.apollo.appsvc.common.annotation.SystemServiceLog;
import com.apollo.appsvc.common.bean.SystemLog;
import com.apollo.appsvc.common.service.LogService;

@Service("logService")
public class LogServiceImpl implements LogService {

	private static Logger logger  = Logger.getLogger(LogServiceImpl.class);
	
	@Transactional
	public void logCallBefore(SystemLog log) {
		if (log != null)
			logger.debug("操作前日志记录 : " + log.toString());
		else
			logger.debug("操作前日志记录");
	}
	
	@Transactional
	public void logCallAfter(SystemLog log) throws Exception {
		if (log != null)
			logger.debug("操作后日志记录 : " + log.toString());
		else
			logger.debug("操作后日志记录");
	}
	
	@Transactional
	public void logAfterReturning(SystemLog log) throws Exception {
		if (log != null)
			logger.debug("操作返回日志记录 : " + log.toString());
		else
			logger.debug("操作返回日志记录");
	}

	@Transactional
	public void logAfterThrowing(SystemLog log) throws Exception {
		if (log != null)
			logger.debug("操作异常日志记录 : " + log.toString());
		else
			logger.debug("操作异常日志记录");
	}

	@Transactional
	@SystemServiceLog(module = "示例", operateName = SystemServiceLog.Operate.INSERT, description = "添加用户",
					className = "LogServiceImpl", methodName="insert")
	public void insert() throws Exception {
		logger.debug("添加一条记录");
	}

	@Transactional
	public void update() throws Exception {
		logger.debug("更新一条记录");
	}
	
	@Transactional
	public void delete() throws Exception {
		logger.debug("删除一条记录");
		
	}

	@Transactional
	public void query() throws Exception {
		logger.debug("更新一条记录");
	}

}
