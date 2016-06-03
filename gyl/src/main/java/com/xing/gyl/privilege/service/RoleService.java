package com.xing.gyl.privilege.service;

import java.util.List;

import com.xing.gyl.base.service.BaseService;
import com.xing.gyl.domain.basedata.User;
import com.xing.gyl.domain.privilege.Role;

public interface RoleService extends BaseService<Role>{
	public static final String SERVICE_NAME="com.xing.gyl.privilege.service.impl.RoleServiceImpl";

	/**
	 * 根据角色名来获取角色对象
	 * @param name 角色名
	 * @return 返回封装符合该角色名的角色对象
	 */
	Role getRoleByName(String name);

	/**
	 * 根据用户的id来获取   该用户所具有的角色
	 * @param uid 用户id
	 * @return 返回封装该用户的list集合
	 */
	List<Role> getRoleByUserId(Long uid);
}
