package com.apollo.appsvc.demo.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apollo.appsvc.common.annotation.SystemControllerLog;
import com.apollo.appsvc.common.annotation.SystemServiceLog;
import com.apollo.appsvc.common.controller.BaseController;
import com.apollo.appsvc.common.service.LogService;
import com.apollo.appsvc.demo.service.CompInstService;

@Controller
@RequestMapping("/demo/test")
public class DemoController extends BaseController{
	private static Logger log = Logger.getLogger(DemoController.class);
	
	@Autowired
	private CompInstService compInstService;
	
	@Autowired
	private LogService logService;
	
	
	@RequestMapping(value="/getCompDesc")
	public void startStopActivity(HttpServletRequest request, HttpServletResponse response) throws Exception{
			throw new SQLException();
//		long compInstId = Long.parseLong(request.getParameter("compInstId"));
//		String name = request.getParameter("name");
//		
//		log.info("中文的参数：" +  name);
//		CompInst compInst = compInstService.selectByPrimaryKey(compInstId);
//		response.getWriter().print(compInst.getCompInstDesc());
	}
	
	@RequestMapping(value="/saveInfo")
	public void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("DemoController.insert ...");
		logService.insert();
	}
	
	@RequestMapping(value="/updateInfo")
	@SystemControllerLog(description = "查询用户")
	public void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("DemoController.update ...");
		logService.update();
	}
}
