package com.xing.gyl.privilege.dao;

import java.util.List;

import com.xing.gyl.base.dao.BaseDao;
import com.xing.gyl.domain.basedata.User;
import com.xing.gyl.domain.privilege.Role;

public interface RoleDao extends BaseDao<Role>{
	public static final String SERVICE_NAME="com.xing.gyl.privilege.dao.impl.RoleDaoImpl";

	/**
	 * 根据角色姓名来获取角色对象
	 * @param name 角色名
	 * @return 返回查询到的角色对象
	 */
	Role getRoleByName(final String name);

	/**
	 * 根据用户id  来获取该用户所具有的id
	 * @param uid 用户id
	 * @return 返回封装该用户
	 */
	List<Role> getRoleByUserId(Long uid);
}
