package com.ssafy.board.config;


import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyAppSqlConfig {
	private static SqlSession session;
	
	static {
		try {
			String resource = "config/mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); 
			
			session = sqlSessionFactory.openSession(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static SqlSession getSession() {
		return session;
	}
}
