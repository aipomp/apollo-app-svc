package com.apollo.appsvc.common.service;

import org.springframework.transaction.annotation.Transactional;

import com.apollo.appsvc.common.bean.SystemLog;

public interface LogService {

    @Transactional
    public void logCallBefore(SystemLog log) throws Exception;
    
    @Transactional
    public void logCallAfter(SystemLog log) throws Exception;
    
    @Transactional
    public void logAfterReturning(SystemLog log) throws Exception;
    
    @Transactional
    public void logAfterThrowing(SystemLog log) throws Exception;
    
    @Transactional
    public void insert() throws Exception;
    
    @Transactional
    public void update() throws Exception;
    
    @Transactional
    public void delete() throws Exception;
    
    @Transactional
    public void query() throws Exception;
}
