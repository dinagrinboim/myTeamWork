package com.topq.testteamwork;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SingletonFileConfiguration {
	private static SingletonFileConfiguration instance = null;
	private Properties  m_prop;
	
	public SingletonFileConfiguration(){
		m_prop = new Properties();
		FileInputStream fts = null;
		try{
			fts = new FileInputStream("config.properties");
			m_prop.load(fts);	
		}
		catch(Exception e){	
		}finally{
			try{
				fts.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}	
	}
	
	public synchronized static SingletonFileConfiguration getInstance(){
		if(instance == null){
			instance = new SingletonFileConfiguration();
		}
		return instance;
	}
	
	public String getMyProperties(String key){
		return m_prop.getProperty(key);	
	}
}	