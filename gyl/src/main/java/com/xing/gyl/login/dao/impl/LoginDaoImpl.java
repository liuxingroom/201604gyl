package com.xing.gyl.login.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xing.gyl.domain.basedata.User;
import com.xing.gyl.login.dao.LoginDao;

@Repository(LoginDao.SERVICE_NAME)
public class LoginDaoImpl implements LoginDao{
	@Resource(name="hibernateTemplate")
	HibernateTemplate hibernateTemplate;
	@Override
	public User authentication(String username, String password) {
		// TODO Auto-generated method stub
		List<User> users=this.hibernateTemplate.find("from User u where u.username=? and u.password=?",username,password);
		if(users.size()>0){
			return users.get(0);
		}else{
			return null;
		}
	}
}
