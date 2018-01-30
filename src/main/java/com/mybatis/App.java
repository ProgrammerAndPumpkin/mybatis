package com.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.alibaba.fastjson.JSON;
import com.mybatis.entity.Area;
import com.mybatis.mapper.AreaMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SqlSessionFactory sqlSessionFactory = MybatisConfig.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AreaMapper areaMapper = sqlSession.getMapper(AreaMapper.class);
        /*UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user= userMapper.findByUserKey(10000);*/
        List<Area> areas = areaMapper.queryChildren("0");
        String json =  JSON.toJSONString(areas);
        System.out.println(json);
        sqlSession.close();
    }
}
