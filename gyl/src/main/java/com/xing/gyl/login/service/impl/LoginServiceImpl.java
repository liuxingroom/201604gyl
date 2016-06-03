package com.xing.gyl.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xing.gyl.domain.basedata.User;
import com.xing.gyl.login.dao.LoginDao;
import com.xing.gyl.login.service.LoginService;

@Service(LoginService.SERVICE_NAME)
public class LoginServiceImpl implements LoginService{
	@Resource(name="")
	LoginDao loginDao;
	
	@Override
	public User authentication(String username, String password) {
		// TODO Auto-generated method stub
		return this.loginDao.authentication(username, password);
	}
}
