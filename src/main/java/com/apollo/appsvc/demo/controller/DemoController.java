package com.apollo.appsvc.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apollo.appsvc.demo.bean.CompInst;
import com.apollo.appsvc.demo.service.CompInstService;

@Controller
@RequestMapping("/demo/test")
public class DemoController {
	@Autowired
	private CompInstService compInstService;
	
	
	@RequestMapping(value="/getCompDesc")
	public void startStopActivity(HttpServletRequest request, HttpServletResponse response) throws Exception{
		long compInstId = 1000096;
		CompInst compInst = compInstService.selectByPrimaryKey(compInstId);
		response.getWriter().print(compInst.getCompInstDesc());
	}
}
