package com.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.alibaba.fastjson.JSON;
import com.mybatis.entity.User;
import com.mybatis.mapper.UserMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SqlSessionFactory sqlSessionFactory = MybatisConfig.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user= userMapper.findByUserKey(10000);
        String json =  JSON.toJSONString(user);
        System.out.println(json);
    }
}
