package com.xing.gyl.basedata.test;

import org.junit.Test;

import com.xing.gyl.basedata.dao.DepartmentDao;
import com.xing.gyl.basedata.service.DepartmentService;
import com.xing.gyl.domain.basedata.Department;
import com.xing.gyl.query.PageResult;
import com.xing.gyl.query.basedata.DepartmentQuery;
import com.xing.gyl.test.utils.SpringUtils;

public class DepartmentTest extends SpringUtils{
	
	@Test
	public void testGetCount(){
		DepartmentDao departmentDao=(DepartmentDao) context.getBean(DepartmentDao.SERVICE_NAME);
		DepartmentQuery baseQuery = new DepartmentQuery();
		int count=departmentDao.getCount(baseQuery);
		System.out.println(count);
	}
	@Test
	public void testPageResult(){
		DepartmentDao departmentDao=(DepartmentDao) context.getBean(DepartmentDao.SERVICE_NAME);
		DepartmentQuery departmentQuery=new DepartmentQuery();
		departmentQuery.setCurrentPage(2);
		PageResult<Department> pageResult=departmentDao.findPageResult(departmentQuery);
		for(Department department:pageResult.getRows()){
			System.out.println(department.getDid());
		}
		
	}
	@Test
	public void testService(){
		DepartmentService departmentService=(DepartmentService) context.getBean(DepartmentService.SERVICE_NAME);
		Department department=new Department();
		department.setName("销售部");
		department.setDescription("大家好啊");
		departmentService.saveEntry(department);
	}
}
