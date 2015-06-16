package com.apollo.appsvc.demo.service;

import com.apollo.appsvc.demo.bean.CompInst;

public interface CompInstService {

	/**
	 * @Title: selectByPrimaryKey 
	 * @方法描述: 获取组件实例
	 * @param compInstId
	 * @return   
	 * @返回类型 CompInst
	 */
	public CompInst selectByPrimaryKey(Long compInstId) ;
}
