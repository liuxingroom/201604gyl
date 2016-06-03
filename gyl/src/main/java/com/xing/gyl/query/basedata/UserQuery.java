package com.xing.gyl.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.xing.gyl.query.BaseQuery;

public class UserQuery extends BaseQuery{
	
	private String username;
	private String email;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * 封装并校验查询条件
	 */
	@Override
	public Map<String, Object> buildWhere() {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(username)){
			this.getKeyValues().put("username", this.username);
		}
		if(StringUtils.isNotBlank(email)){
			this.getKeyValues().put("email", this.email);
		}
		return this.getKeyValues();
	}
}
