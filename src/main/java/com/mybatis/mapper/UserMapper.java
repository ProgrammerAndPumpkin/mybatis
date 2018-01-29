package com.mybatis.mapper;

import com.mybatis.entity.User;

public interface UserMapper {
	
	User findByUserKey(Integer id);
}
