package com.xing.gyl.privilege.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xing.gyl.base.dao.BaseDao;
import com.xing.gyl.base.service.impl.BaseServiceImpl;
import com.xing.gyl.domain.privilege.Privilege;
import com.xing.gyl.privilege.dao.PrivilegeDao;
import com.xing.gyl.privilege.service.PrivilegeService;

@Service(PrivilegeService.SERVICE_NAEM)
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege> implements PrivilegeService{
	//注入权限的dao
	@Resource(name=PrivilegeDao.SERVICE_NAME)
	PrivilegeDao privilegeDao;
	@Override
	public BaseDao<Privilege> getBaseDao() {
		// TODO Auto-generated method stub
		return privilegeDao;
	}
	
	@Override
	public List<Privilege> getPrivilegesByRoleId(Long rid) {
		/**
		 * 1、加载所有的权限
		 * 2、加载该角色能够访问到的权限
		 * 3、两次遍历，把所有的权限中用户能够访问到的权限的checked设置为true
		 */
		//获取所有的权限
		List<Privilege> allPrivileges=this.privilegeDao.findEntrys();
		//获取该角色具有的权限集合
		List<Privilege> rolePrivileges=this.privilegeDao.getPrivilegeByRoleId(rid);
		if(allPrivileges!=null && rolePrivileges!=null){//若两个集合不为空则执行一下操作
			for(Privilege privilege:allPrivileges){
				for(Privilege privilege2:rolePrivileges){
					if(privilege.getId().longValue()==privilege2.getId().longValue()){
						privilege.setChecked(true);
					}
				}
			}
		}
		
		return allPrivileges;
	}

	@Override
	public List<Privilege> getMenuitemTreeByUid(Long uid) {
		// TODO Auto-generated method stub
		
		return this.privilegeDao.getMenuitemTreeByUid(uid);
	}

	@Override
	public List<Privilege> getFunctionTreeByUid(Long uid) {
		// TODO Auto-generated method stub
		return this.privilegeDao.getFunctionTreeByUid(uid);
	}
	
	
}
