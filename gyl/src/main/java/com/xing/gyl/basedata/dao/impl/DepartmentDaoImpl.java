package com.xing.gyl.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.xing.gyl.base.dao.impl.BaseDaoImpl;
import com.xing.gyl.basedata.dao.DepartmentDao;
import com.xing.gyl.domain.basedata.Department;

@Repository(DepartmentDao.SERVICE_NAME)
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{
	
}
