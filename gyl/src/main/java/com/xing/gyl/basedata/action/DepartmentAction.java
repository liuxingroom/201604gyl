package com.xing.gyl.basedata.action;

import java.lang.reflect.InvocationTargetException;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xing.gyl.base.action.BaseAction;
import com.xing.gyl.basedata.service.DepartmentService;
import com.xing.gyl.domain.basedata.Department;
import com.xing.gyl.privilege.annotation.PrivilegeInfo;
import com.xing.gyl.query.BaseQuery;
import com.xing.gyl.query.PageResult;
import com.xing.gyl.query.basedata.DepartmentQuery;

/**Department 部门*/
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{
	//获取页面传递的值  封装从Department对象
	Department department=this.getModel();
	@Resource(name=DepartmentService.SERVICE_NAME)
	DepartmentService departmentService;
	//查询条件
	private BaseQuery baseQuery=new DepartmentQuery();
	
	@PrivilegeInfo(name="部门查询")
	public String showPageResult(){
		baseQuery.setCurrentPage(this.currentPage);
		PageResult<Department> departments=this.departmentService.getPageResult(baseQuery);
		ActionContext.getContext().put("departments", departments);
		return "listAction";
	}
	/**
	 * 根据id的集合 来删除
	 * @return
	 */
	public String deleteDepartments(){
		//String [] ids=this.checkedStr.split(",");
		departmentService.deleteEntryByIds(this.getIds());
		return action2action;
	}
	/**
	 * 删除指定行
	 */
	public String deleteDepartment(){
		departmentService.deleteEntryById(department.getDid());
		return action2action;
	}
	
	/**
	 * 跳转到添加页面
	 */
	public String addUI(){
		return "addUI";
	}
	
	/**
	 * 添加信息
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public String add() throws IllegalAccessException, InvocationTargetException{
		this.departmentService.saveEntry(department);
		return action2action;
	}
	
	/**
	 * 跳转到更新页面并且将属性值回显
	 * @return
	 */
	public String updateUI(){
		Department department1=this.departmentService.getEntryById(department.getDid());
		ActionContext.getContext().getValueStack().push(department1);
		return "updateUI";
	}
	
	public String update(){
		this.departmentService.updateEntry(department);
		return "chain";
	}
}
