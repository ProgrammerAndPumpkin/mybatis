package com.mybatis.mapper;

import java.util.List;

import com.mybatis.entity.Area;

public interface AreaMapper {
	
	List<Area> queryChildren(String parentId);
	
}
