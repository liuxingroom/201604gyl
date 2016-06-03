package com.xing.gyl.basedata.dao;

import com.xing.gyl.base.dao.BaseDao;
import com.xing.gyl.domain.basedata.Department;

public interface DepartmentDao extends BaseDao<Department>{
	public static String SERVICE_NAME="com.xing.gyl.basedata.dao.impl.DepartmentDaoImpl";
}
