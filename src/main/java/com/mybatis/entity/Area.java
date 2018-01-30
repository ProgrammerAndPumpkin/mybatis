package com.mybatis.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity(name = "base_area")
public class Area {
	
	@Id
	private String  areaId;         //区域主键
	
	private String  parentId;       //父级主键
	private String  areaCode;       //区域编码
	private String  areaName;       //区域名称
	private String  quickQuery;     //快速查询
	private String  simpleSpelling; //简拼
	private Integer layer;          //层次
	private Integer sortCode;       //排序码
	private Integer deleteMark;     //删除标记
	private Integer enabledMark;    //有效标志
	private String  description;    //备注
	
	private Date    createDate;     //创建日期
	
	private String  createUserId;   //创建用户主键
	
	private String  createUserName; //创建用户
	
	private Date    modifyDate;     //修改日期
	
	private String  modifyUserId;   //修改用户主键
	
	private String  modifyUserName; //修改用户
	
	@Transient
	private List<Area> children;    
	
	public Area() {
		
	}
	
	public Area(String areaId, String parentId, 
			String areaCode, String areaName) {
		this.areaId = areaId;
		this.parentId = parentId;
		this.areaCode = areaCode;
		this.areaName = areaName;
		this.deleteMark = 0;
		this.enabledMark = 1;
	}
	
	public Area(String areaId, String parentId, 
			String areaCode, String areaName,
			Integer sortCode) {
		this.areaId = areaId;
		this.parentId = parentId;
		this.areaCode = areaCode;
		this.areaName = areaName;
		this.sortCode = sortCode;
		this.deleteMark = 0;
		this.enabledMark = 1;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getQuickQuery() {
		return quickQuery;
	}

	public void setQuickQuery(String quickQuery) {
		this.quickQuery = quickQuery;
	}

	public String getSimpleSpelling() {
		return simpleSpelling;
	}

	public void setSimpleSpelling(String simpleSpelling) {
		this.simpleSpelling = simpleSpelling;
	}

	public Integer getLayer() {
		return layer;
	}

	public void setLayer(Integer layer) {
		this.layer = layer;
	}

	public Integer getSortCode() {
		return sortCode;
	}

	public void setSortCode(Integer sortCode) {
		this.sortCode = sortCode;
	}

	public Integer getDeleteMark() {
		return deleteMark;
	}

	public void setDeleteMark(Integer deleteMark) {
		this.deleteMark = deleteMark;
	}

	public Integer getEnabledMark() {
		return enabledMark;
	}

	public void setEnabledMark(Integer enabledMark) {
		this.enabledMark = enabledMark;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifyUserId() {
		return modifyUserId;
	}

	public void setModifyUserId(String modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	public String getModifyUserName() {
		return modifyUserName;
	}

	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName;
	}

	public List<Area> getChildren() {
		return children;
	}

	public void setChildren(List<Area> children) {
		this.children = children;
	}
	
}
