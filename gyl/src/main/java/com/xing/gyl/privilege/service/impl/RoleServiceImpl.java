package com.xing.gyl.privilege.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xing.gyl.base.dao.BaseDao;
import com.xing.gyl.base.service.impl.BaseServiceImpl;
import com.xing.gyl.domain.basedata.User;
import com.xing.gyl.domain.privilege.Role;
import com.xing.gyl.privilege.dao.RoleDao;
import com.xing.gyl.privilege.service.RoleService;


@Service(RoleService.SERVICE_NAME)
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{
	//注入角色dao
	@Resource(name=RoleDao.SERVICE_NAME)
	RoleDao roleDao;
	@Override
	public BaseDao<Role> getBaseDao() {
		// TODO Auto-generated method stub
		return roleDao;
	}
	
	@Override
	public Role getRoleByName(String name) {
		// TODO Auto-generated method stub
		Role role=this.roleDao.getRoleByName(name);
		return role;
	}

	@Override
	public List<Role> getRoleByUserId(Long uid) {
		List<Role> allRoles=this.roleDao.findEntrys();
		List<Role> userRoles=this.roleDao.getRoleByUserId(uid);
		for(Role role:allRoles){
			for(Role role2:userRoles){
				if(role.getRid().longValue()==role2.getRid().longValue()){
					role.setChecked(true);
				}
			}
		}
		return allRoles;
	}



}
