package com.xing.gyl.privilege.action;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xing.gyl.base.action.BaseAction;
import com.xing.gyl.domain.basedata.User;
import com.xing.gyl.domain.privilege.Privilege;
import com.xing.gyl.domain.privilege.Role;
import com.xing.gyl.privilege.service.PrivilegeService;
import com.xing.gyl.privilege.service.RoleService;

@Controller("privilegeAction")
@Scope("prototype")
public class PrivilegeAction extends BaseAction<Privilege>{
	Privilege privilege=this.getModel();
	//注入权限的service
	@Resource(name=PrivilegeService.SERVICE_NAEM)
	PrivilegeService privilegeService;
	@Resource(name=RoleService.SERVICE_NAME)
	RoleService roleService;
	/**
	 * 用户获取页面传来的角色id的值
	 */
	public Long rid;
	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}
	/**
	 * 用于获取页面传递的权限id
	 */
	public String checkedStr;
	public String getCheckedStr() {
		return checkedStr;
	}

	public void setCheckedStr(String checkedStr) {
		this.checkedStr = checkedStr;
	}

	/**
	 * 获取所有的权限
	 */
	public String showPrivilegeTree(){
		//获取所有的权限集合
		List<Privilege> privileges=this.privilegeService.getPrivilegesByRoleId(rid);
		//将获取到的权限集合压到栈顶
		ActionContext.getContext().getValueStack().push(privileges);
		return "SUCCESS";
	}
	
	/**
	 * 保存角色和权限之间的关系（即：在角色权限表中插入数据）
	 */
	public String savePrivilege(){
		//根据页面传来的rid获取角色对象
		Role role=this.roleService.getEntryById(rid);
		if(StringUtils.isNotBlank(checkedStr)){//如果页面选择的权限不为空
			String []checkedStrs=checkedStr.split(",");
			/**
			 * 因为权限（privilege）的id为Long类型  如果以checkedStrs(字符串数组)来获取权限集合    该操作会报异常   
			 * 因此要将字符数组转换成Long类型数组
			 */
			Long [] id=new Long[checkedStrs.length];
			for(int i=0;i<checkedStrs.length;i++){
				id[i]=Long.parseLong(checkedStrs[i]);
			}
			List<Privilege> privileges=this.privilegeService.getEntryByIds(id);
			//角色权限建立关联关系
			role.setPrivileges(new HashSet<Privilege>(privileges));
		}else{//如果页面没有为该角色设置权限
			role.setPrivileges(null);
		}
		//保存数据
		this.roleService.saveEntry(role);
		ActionContext.getContext().getValueStack().push(role);
		return "SUCCESS";
	}
	
	/**
	 * 加载登陆以后的  左侧页面的菜单树
	 */
	public String showMenuitemTreeByUid(){
		
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		List<Privilege> privileges=this.privilegeService.getMenuitemTreeByUid(user.getUid());
		ActionContext.getContext().getValueStack().push(privileges);
		return "SUCCESS";
	}
	
	
}
