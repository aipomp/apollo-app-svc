package com.apollo.appsvc.common.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.stereotype.Component;

@Component("configuration")
public class Configuration {
	
    private static Properties propertie;
    private InputStream in;
    private static Configuration INSTANCE;
    
    public static Configuration getInstance() {
        if (INSTANCE == null)
        	INSTANCE = new Configuration();
        return INSTANCE;
    }
    
    /**
     * 初始化Configuration类
     */
    private Configuration() {
        propertie = new Properties();
        try {
            in = getClass().getResourceAsStream("/mail.properties");
            propertie.load(in);
            in.close();
        } catch (FileNotFoundException ex) {
            System.out.println("读取属性文件--->失败！- 原因：文件路径错误或者文件不存在");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("装载文件--->失败!");
            ex.printStackTrace();
        }        
    }
    
    /**
     * 重载函数，得到key的值
     * @param key 取得其值的键
     * @return key的值
     */
    public String getValue(String key) {
        if(propertie.containsKey(key)){
            String value = propertie.getProperty(key);//得到某一属性的值
            return value;
        }
        else 
            return "";
    }
}
