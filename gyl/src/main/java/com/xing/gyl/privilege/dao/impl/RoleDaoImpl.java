package com.xing.gyl.privilege.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.xing.gyl.base.dao.impl.BaseDaoImpl;
import com.xing.gyl.domain.privilege.Role;
import com.xing.gyl.privilege.dao.RoleDao;

@Repository(RoleDao.SERVICE_NAME)
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

	@Override
	public Role getRoleByName(final String name) {
		return this.hibernateTemplate.execute(new HibernateCallback<Role>() {
			@Override
			public Role doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("from Role where name=:name");
				query.setParameter("name", name);
				return (Role)query.uniqueResult();
			}
		});
	}
	
	@Override
	public List<Role> getRoleByUserId(Long uid) {
		// TODO Auto-generated method stub
		List<Role> roles=this.hibernateTemplate.find("from Role r join fetch r.users u where u.uid=?",uid);
		return roles;
	}
}
