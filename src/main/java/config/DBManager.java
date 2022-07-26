package config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBManager {
	private static DBManager instance = new DBManager();
	
	private SqlSessionFactory factory;
	
	private DBManager() {
		String resource = "config/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public SqlSession getSession() {
		return factory.openSession(true);
	}
	public SqlSession getTestSession() {
		return factory.openSession(false);
	}
	public static DBManager getInstance() {
		if(instance == null)
			instance = new DBManager();
		return instance;
	}
	
}
