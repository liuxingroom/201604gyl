package com.xing.gyl.privilege.service;

import java.util.List;

import com.xing.gyl.base.service.BaseService;
import com.xing.gyl.domain.privilege.Privilege;

public interface PrivilegeService extends BaseService<Privilege>{
	public static final String SERVICE_NAEM="com.xing.gyl.privilege.service.impl.PrivilegeServiceImpl";
	/**
	 * 通过角色id来获取该角色的所有权限
	 * @param rid 角色id
	 * @return 返回封装权限的集合
	 */
	public List<Privilege> getPrivilegesByRoleId(Long rid);
	
	/**
	 * 根据用户的id来获取 该用户所具有的权限
	 * @param uid 用户id
	 * @return 返回封装该用户所具有的权限
	 */
	public List<Privilege> getMenuitemTreeByUid(Long uid);

	/**
	 * 根据用户id 来获取方法功能权限
	 * @param uid 用户的id
	 * @return 返回封装方法功能权限的集合
	 */
	public List<Privilege> getFunctionTreeByUid(Long uid);
}
