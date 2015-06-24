package com.apollo.appsvc.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.apollo.appsvc.baseapi.demo.CompInstMapper;
import com.apollo.appsvc.demo.bean.CompInst;
import com.apollo.appsvc.demo.service.CompInstService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
		//测试分页
		PageHelper.startPage(1, 10);
		List<CompInst> root = compInstMapper.selectAll();
		//用PageInfo对结果进行包装
		PageInfo page = new PageInfo(root);
		//测试PageInfo全部属性
		//PageInfo包含了非常全面的分页属性
		System.out.println(page.getPageNum());
		String jsonString = JSON.toJSONString(page);
		System.out.println(jsonString);
		// TODO Auto-generated method stub
		return compInstMapper.selectByPrimaryKey(compInstId);
	}

}
