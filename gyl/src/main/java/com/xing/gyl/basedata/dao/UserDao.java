package com.xing.gyl.basedata.dao;

import com.xing.gyl.base.dao.BaseDao;
import com.xing.gyl.domain.basedata.User;

public interface UserDao extends BaseDao<User>{
	public static final String SERVICE_NAME="com.xing.gyl.basedata.dao.impl.UserDaoImpl";
}
