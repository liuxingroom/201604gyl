package com.xing.gyl.basedata.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xing.gyl.base.action.BaseAction;
import com.xing.gyl.basedata.service.DepartmentService;
import com.xing.gyl.basedata.service.UserService;
import com.xing.gyl.domain.basedata.Department;
import com.xing.gyl.domain.basedata.User;
import com.xing.gyl.query.PageResult;
import com.xing.gyl.query.basedata.UserQuery;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	User user=this.getModel();
	//注入用户Service
	@Resource(name=UserService.SERVICE_NAME)
	UserService userService;
	//注入部门service
	@Resource(name=DepartmentService.SERVICE_NAME)
	DepartmentService departmentService;
	//设置查询对象
	UserQuery baseQuery=new UserQuery();
	//设置部门的id
	public long did;

	public long getDid() {
		return did;
	}
	public void setDid(long did) {
		this.did = did;
	}
	/**
	 * 显示用户首页 （分页显示）
	 * @return
	 */
	public String showPageResult(){
		baseQuery.setCurrentPage(this.currentPage);
		PageResult<User> users=this.userService.getPageResult(baseQuery);
		ActionContext.getContext().put("users", users);
		return listAction;
	}
	/**
	 * 显示添加页面
	 */
	public String addUI(){
		List<Department> departments=this.departmentService.findEntrys();
		ActionContext.getContext().put("departments", departments);
		return "addUI";
	}
	/**
	 * 用户保存
	 */
	public String add(){
		//获取修改后的部门id  然后根据部门id 来获取部门对象
		Department department=this.departmentService.getEntryById(did);
		//用户和部门建立关系
		user.setDepartment(department);
		//保存用户
		this.userService.saveEntry(user);
		return action2action;
	}
	/**
	 * 跳转到修改页面
	 */
	public String updateUI(){
		User user1=this.userService.getEntryById(user.getUid());
		/**
		 * 将获取的用户信息放到栈顶  用于数据回显
		 */
		ActionContext.getContext().getValueStack().push(user1);
		//用于回显部门
		this.did=user1.getDepartment().getDid();
		//回显部门后还能重新选择部门
		List<Department> departments=departmentService.findEntrys();
		//将部门信息放到application域中 并带到页面显示
		ActionContext.getContext().put("departments",departments);
		return "updateUI";
	}
	
	/**
	 *	更新用户信息 
	 */
	public String update(){
		//获取修改后的部门id  然后根据部门id 来获取部门对象
		Department department=this.departmentService.getEntryById(this.did);
		//用户和部门建立关系
		user.setDepartment(department);
		//更新用户
		this.userService.updateEntry(user);
		return action2action;
	}
	
	/**
	 * 删除多个用户信息
	 */
	public String deleteUsers(){
		this.userService.deleteEntryByIds(this.getIds());
		return action2action;
	}
	/**
	 * 删除指定用户的信息
	 */
	public String deleteUser(){
		this.userService.deleteEntryById(user.getUid());
		return action2action;
	}
}
