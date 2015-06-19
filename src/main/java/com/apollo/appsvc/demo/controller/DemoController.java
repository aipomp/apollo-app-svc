package com.apollo.appsvc.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apollo.appsvc.demo.MyBatisTest;
import com.apollo.appsvc.demo.bean.CompInst;
import com.apollo.appsvc.demo.service.CompInstService;

@Controller
@RequestMapping("/demo/test")
public class DemoController {
	private static Logger log = Logger.getLogger(DemoController.class);
	
	@Autowired
	private CompInstService compInstService;
	
	
	@RequestMapping(value="/getCompDesc")
	public void startStopActivity(HttpServletRequest request, HttpServletResponse response) throws Exception{
		long compInstId = Long.parseLong(request.getParameter("compInstId"));
		String name = request.getParameter("name");
		
		log.info("中文的参数：" +  name);
		CompInst compInst = compInstService.selectByPrimaryKey(compInstId);
		response.getWriter().print(compInst.getCompInstDesc());
	}
}
