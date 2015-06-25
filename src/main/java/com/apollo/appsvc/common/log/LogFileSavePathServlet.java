package com.apollo.appsvc.common.log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.apollo.appsvc.demo.controller.DemoController;

/**
 * 初始化日志错误文件存放的路径
 */
public class LogFileSavePathServlet extends HttpServlet {
	private static Logger logger  = Logger.getLogger(LogFileSavePathServlet.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogFileSavePathServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// 获得系统的路径 /WebRoot

		String rootPath = this.getServletContext().getRealPath("/");
		// 获得log4j.properties的输入流
		InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream("log4j.properties");
		Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 设置日志文件的输出路径
//		prop.setProperty("log4j.appender.F.File",  prop.getProperty("log4j.appender.F.File"));
//		prop.setProperty("log4j.appender.F.DatePattern", prop.getProperty("log4j.appender.F.DatePattern"));
		// 加载配置项
		PropertyConfigurator.configure(prop);
		
		logger.info("日志文件存放路径：" + prop.getProperty("log4j.appender.F.File"));
		
		super.init();
	}

}
