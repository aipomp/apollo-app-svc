package com.apollo.appsvc.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.apollo.appsvc.baseapi.demo.CompInstMapper;
import com.apollo.appsvc.demo.bean.CompInst;
import com.apollo.appsvc.demo.service.CompInstService;

/**
  * @author zhoult
  * 使用@Service注解将CompInstServiceImpl类标注为一个service
  * service的id是CompInstService
  */
@Service("compInstService")
public class CompInstServiceImpl implements CompInstService {
	/**
	 * 使用@Autowired注解标注userMapper变量，
	 * 当需要使用CompInstMapper时，Spring就会自动注入CompInstMapper
	 */
	@Resource(name="compInstMapper")
	private CompInstMapper compInstMapper;

	/**
	 * 
	 */
	public CompInst selectByPrimaryKey(Long compInstId) {
		// TODO Auto-generated method stub
		return compInstMapper.selectByPrimaryKey(compInstId);
	}

}
