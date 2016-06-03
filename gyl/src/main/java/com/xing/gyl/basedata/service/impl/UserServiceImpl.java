package com.xing.gyl.basedata.service.impl;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xing.gyl.base.dao.BaseDao;
import com.xing.gyl.base.service.impl.BaseServiceImpl;
import com.xing.gyl.basedata.dao.UserDao;
import com.xing.gyl.basedata.service.UserService;
import com.xing.gyl.domain.basedata.User;

@Service(UserService.SERVICE_NAME)
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	@Resource(name=UserDao.SERVICE_NAME)
	UserDao userDao;
	
	@Override
	public BaseDao<User> getBaseDao() {
		// TODO Auto-generated method stub
		return userDao;
	}
	
}
