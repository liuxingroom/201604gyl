package com.xing.gyl.login.service;

import com.xing.gyl.domain.basedata.User;

public interface LoginService {
	public static final String SERVICE_NAME="com.xing.gyl.login.service.impl.LoginServiceImpl";
	public User authentication(String username,String password);
}
