package com.xing.gyl.login.dao;

import com.xing.gyl.domain.basedata.User;

public interface LoginDao{
	public static final String SERVICE_NAME="com.xing.gyl.login.dao.impl.LoginDaoImpl";
	public User authentication(String username,String password);
}
