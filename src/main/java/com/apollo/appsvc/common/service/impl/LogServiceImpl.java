package com.apollo.appsvc.common.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apollo.appsvc.common.bean.Log;
import com.apollo.appsvc.common.service.LogService;

@Service("logService")
public class LogServiceImpl implements LogService {

	private static Logger logger  = Logger.getLogger(LogServiceImpl.class);
	
	@Transactional
	public void log(Log log) {
		logger.debug("记录操作日志");
	}

	public Long loginUserId() {
		logger.debug("获取用户ID");
		return null;
	}
	
	public void insert() {
		logger.debug("添加一条记录");
	}

	public void update() {
		logger.debug("更新一条记录");
	}
}
