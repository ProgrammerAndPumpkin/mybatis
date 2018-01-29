package com.mybatis;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class MybatisConfig {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		Map<String, String> properties  = new HashMap<String, String>();
		properties.put("driverClassName", "com.mysql.jdbc.Driver");
		properties.put("url", " jdbc:mysql://127.0.0.1:3306/develop?characterEncoding=utf-8");
		properties.put("username", "wcx");
		properties.put("password", "123456");
		DataSource dataSource;
		try {
			dataSource = DruidDataSourceFactory.createDataSource(properties);
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			Environment environment =   new Environment("development", transactionFactory, dataSource);
			Configuration configuration = new Configuration(environment);
			//configuration.addMapper(AreaMapper.class);
			configuration.addMappers("com.mybatis.mapper");
			sqlSessionFactory =  new SqlSessionFactoryBuilder().build(configuration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	/*public static void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		MybatisConfig.sqlSessionFactory = sqlSessionFactory;
	}*/

}
