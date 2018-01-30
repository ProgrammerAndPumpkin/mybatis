package com.mybatis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.yaml.snakeyaml.Yaml;

import com.alibaba.druid.pool.DruidDataSourceFactory;


public class MybatisConfig {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		Map<String, Object> configs = loadYaml();
		@SuppressWarnings("unchecked")
		Map<String, Object> druidConfig = (Map<String, Object>) configs.get("druid");
		Map<String, String> properties  = valueToStr(druidConfig); 
		try {
			DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			Environment environment =   new Environment("development", transactionFactory, dataSource);
			Configuration configuration = new Configuration(environment);
			configuration.addMappers("com.mybatis.mapper");
			configuration.setLogImpl(Log4jImpl.class);
			sqlSessionFactory =  new SqlSessionFactoryBuilder().build(configuration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	private static Map<String, String> valueToStr(Map<String, Object> map) {
		Map<String, String> stringMap = new HashMap<String, String>();
		for (Entry<String, Object> entry : map.entrySet()) {
			String value = entry.getValue().toString();
			stringMap.put(entry.getKey(), value);
		}
		return stringMap;
	}
	
	@SuppressWarnings("unchecked")
	private static Map<String, Object> loadYaml() {
		Yaml yaml = new Yaml();
		ClassLoader loader = MybatisConfig.class.getClassLoader();
		URL rootURL = loader.getResource("");
		String rootPath = rootURL.getPath();
		String configPath = "config" + File.separator + "qyFramework.yml";
		File config = new File(rootPath + File.separator + configPath);
		FileInputStream input = null;
		Map<String, Object> map = null;
		try {
			input = new FileInputStream(config);
			map = (Map<String, Object>)yaml.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return map;
	} 

}
