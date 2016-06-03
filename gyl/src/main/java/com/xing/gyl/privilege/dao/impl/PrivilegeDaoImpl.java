package com.xing.gyl.privilege.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xing.gyl.base.dao.impl.BaseDaoImpl;
import com.xing.gyl.domain.privilege.Privilege;
import com.xing.gyl.privilege.dao.PrivilegeDao;

@Repository(PrivilegeDao.SERVICE_NAME)
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao{
	
	/**
	 * 通过角色id来获取该角色的所有权限
	 */
	public List<Privilege> getPrivilegeByRoleId(Long rid){
		List<Privilege> privileges=this.hibernateTemplate.find("from Privilege p join fetch p.roles r where r.rid=?",rid);
		return privileges;
	}

	@Override
	public List<Privilege> getMenuitemTreeByUid(Long uid) {
		// TODO Auto-generated method stub
			if(uid.longValue()==1){//说明是管理员
				return this.hibernateTemplate.find("from Privilege where type='1'");
			}else{//普通员工    根据uid查找对应的权限
				return this.hibernateTemplate.find("from Privilege p inner join fetch p.roles r inner join fetch r.users u where u.uid=? and p.type='1'",uid);
			}
	}

	@Override
	public List<Privilege> getFunctionTreeByUid(Long uid) {
		// TODO Auto-generated method stub
		if(uid.longValue()==1){//说明是管理员
			return this.hibernateTemplate.find("from Privilege where type='2'");
		}else{
			return this.hibernateTemplate.find("from Privilege p inner join fetch p.roles r inner join fetch r.users u where u.uid=? and p.type='2'",uid);
		}

	}
	
	
}
