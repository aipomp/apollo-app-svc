package com.apollo.appsvc.demo;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apollo.appsvc.demo.bean.CompInst;
import com.apollo.appsvc.demo.service.CompInstService;

public class MyBatisTest {
	private CompInstService compInstService;
	private static Logger log = Logger.getLogger(MyBatisTest.class);

	/**
	 * 这个before方法在所有的测试方法之前执行，并且只执行一次 所有做Junit单元测试时一些初始化工作可以在这个方法里面进行
	 * 比如在before方法里面初始化ApplicationContext和userService
	 */
	@Before
	public void before() {
		// 使用"spring.xml"和"spring-mybatis.xml"这两个配置文件创建Spring上下文
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "spring.xml", "spring-mybatis.xml" });
		// 从Spring容器中根据bean的id取出我们要使用的userService对象
		compInstService = (CompInstService) ac.getBean("compInstService");
	}

	@Test
	public void testGetCompInst() {
		long compInstId = 1000096;
		CompInst compInst = compInstService.selectByPrimaryKey(compInstId);
		log.info("组件名称：" + compInst.getCompInstDesc());

	}
}
