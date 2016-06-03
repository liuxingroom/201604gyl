package com.xing.gyl.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xing.gyl.base.dao.BaseDao;
import com.xing.gyl.base.service.impl.BaseServiceImpl;
import com.xing.gyl.basedata.dao.DepartmentDao;
import com.xing.gyl.basedata.service.DepartmentService;
import com.xing.gyl.domain.basedata.Department;

@Service(DepartmentService.SERVICE_NAME)
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService{
	
	@Resource(name=DepartmentDao.SERVICE_NAME)
	DepartmentDao departmentDao;
	@Override
	public BaseDao<Department> getBaseDao() {
		// TODO Auto-generated method stub
		return departmentDao;
	}

}
