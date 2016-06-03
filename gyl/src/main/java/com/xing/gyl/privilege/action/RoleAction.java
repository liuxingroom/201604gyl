package com.xing.gyl.privilege.action;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xing.gyl.base.action.BaseAction;
import com.xing.gyl.basedata.service.UserService;
import com.xing.gyl.domain.basedata.User;
import com.xing.gyl.domain.privilege.Role;
import com.xing.gyl.privilege.service.RoleService;
import com.xing.gyl.utils.GylConstantKey;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	Role role=this.getModel();
	
	//注入角色Service
	@Resource(name=RoleService.SERVICE_NAME)
	RoleService roleService;
	//注入用户Service
	@Resource(name=UserService.SERVICE_NAME)
	UserService userService;
	
	/**
	 * 通过uid来获取页面传递的用户id的值
	 */
	public Long uid;
	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}
	/**
	 * 页面传来的由角色id组成的字符串
	 */
	private String checkedStr;
	public String getCheckedStr() {
		return checkedStr;
	}

	public void setCheckedStr(String checkedStr) {
		this.checkedStr = checkedStr;
	}
	
	public String showRoleTree(){
		List<Role> roles= this.roleService.findEntrys();
		ActionContext.getContext().getValueStack().push(roles);
		return "SUCCESS";
	}
	
	/**
	 * 通过用户id来获取角色集合   并显示角色树
	 * @return
	 */
	public String showRoleByUid(){
		List<Role> roles=this.roleService.getRoleByUserId(uid);
		ActionContext.getContext().getValueStack().push(roles);
		return "SUCCESS";
	}
	/**
	 * 检验该角色名是否存在
	 */
	public String showRoleByName(){
		String name=this.role.getName();
		if(StringUtils.isNotBlank(name)){
			Role role=this.roleService.getRoleByName(name);
			if(role==null){
				ActionContext.getContext().getValueStack().push(GylConstantKey.ROLE_NAME_FLAG_ABLE);
			}else{
				ActionContext.getContext().getValueStack().push(GylConstantKey.ROLE_NAME_FLAG_DISABLE);
			}
		}
		return "SUCCESS";
	}
	
	/**
	 * 添加角色
	 */
	public String add(){
		//添加角色信息
		this.roleService.saveEntry(role);
		/**
		 * 把role回调到客户端，因为客户端要使用rid
		 */
		ActionContext.getContext().getValueStack().push(role);
		return "SUCCESS";
	}
	
	/**
	 * 删除角色
	 */
	public String deleteRole(){
		this.roleService.deleteEntryById(role.getRid());
		return "SUCCESS";
	}
	
	/**
	 * 更新角色信息
	 */
	public String updateRole(){
		//更新部分字段
		//先取出数据库中的Role对象  然后将修改后的属性   设置一下  然后在执行普通的更新
		Role role2=this.roleService.getEntryById(role.getRid());
		role2.setName(role.getName());
		this.roleService.updateEntry(role2);
		return "SUCCESS";
	}
	
	
	/**
	 * 在权限模块显示角色名(点击权限模块的权限分配按键  然后在右侧显示所有角色)
	 */
	public String showRoles(){
		//获取所有的角色
		List<Role> roles=this.roleService.findEntrys();
		ActionContext.getContext().put("roles", roles);
		return listAction;
	}
	
	/**
	 * 在角色模块中显示所有的用户名（点击角色模块的角色分配按键  然后在右侧显示所有用户）
	 * 
	 *  跳转到用户设置角色的页面
	 */
	public String showUsers(){
		//获取所有的用户
		List<User> users=this.userService.findEntrys();
		ActionContext.getContext().put("users", users);
		return "listAction";
	}
	/**
	 * 建立用户与角色之间的关系
	 */
	public String saveRole(){
		User user=this.userService.getEntryById(uid);
		String [] checkedStrs=checkedStr.split(",");
		Long []id=new Long[checkedStrs.length];
		for(int i=0;i<checkedStrs.length;i++){
			id[i]=Long.parseLong(checkedStrs[i]);
		}
		List<Role> roles=this.roleService.getEntryByIds(id);
		user.setRoles(new HashSet<Role>(roles));
		this.userService.saveEntry(user);
		return "SUCCESS";
	}
}
