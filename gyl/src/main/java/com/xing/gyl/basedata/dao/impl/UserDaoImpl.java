package com.xing.gyl.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.xing.gyl.base.dao.impl.BaseDaoImpl;
import com.xing.gyl.basedata.dao.UserDao;
import com.xing.gyl.domain.basedata.User;

@Repository(UserDao.SERVICE_NAME)
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

}
