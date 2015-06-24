package com.apollo.appsvc.common.service;

import org.springframework.transaction.annotation.Transactional;

import com.apollo.appsvc.common.bean.Log;

public interface LogService {
    /** 
     * 日志记录 
     * @param log 
     */  
    @Transactional  
    public void log(Log log);  
      
    /** 
     * 获取登录管理员ID 
     */  
    public Long loginUserId();
    
    public void insert();
    
    public void update();
}
