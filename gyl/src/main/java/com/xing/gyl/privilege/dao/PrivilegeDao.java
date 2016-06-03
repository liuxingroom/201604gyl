package com.xing.gyl.privilege.dao;

import java.util.List;

import com.xing.gyl.base.dao.BaseDao;
import com.xing.gyl.domain.privilege.Privilege;

public interface PrivilegeDao extends BaseDao<Privilege>{
	public static final String SERVICE_NAME="com.xing.gyl.privilege.dao.impl.PrivilegeDaoImpl";
	/**
	 * 通过角色id来获取该角色的所有权限
	 */
	public List<Privilege> getPrivilegeByRoleId(Long rid);
	
	/**
	 * 根据登陆的用户id来获取该用户的权限
	 * @param uid
	 * @return
	 */
	public List<Privilege> getMenuitemTreeByUid(Long uid);

	/**
	 * 根据用户id 来获取方法功能权限
	 * @param uid 用户的id
	 * @return 返回封装方法功能权限的集合
	 */
	public List<Privilege> getFunctionTreeByUid(Long uid);
}
