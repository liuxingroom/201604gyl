package com.xing.gyl.login.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xing.gyl.base.action.BaseAction;
import com.xing.gyl.domain.basedata.User;
import com.xing.gyl.domain.privilege.Privilege;
import com.xing.gyl.login.service.LoginService;
import com.xing.gyl.privilege.service.PrivilegeService;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<User>{
	User user=this.getModel();
	//注入登陆的service
	@Resource(name=LoginService.SERVICE_NAME)
	LoginService loginService;
	//注入权限Service
	@Resource(name=PrivilegeService.SERVICE_NAEM)
	PrivilegeService privilegeService;
	
	public String authentication(){
		User user1=this.loginService.authentication(user.getUsername(),user.getPassword());
		if(user1==null){
			this.addActionError("登录名或者密码为空");
			return "login";
		}else{
			List<Privilege> functions = this.privilegeService.getFunctionTreeByUid(user1.getUid());
			this.getSession().setAttribute("user", user1);
			//把该用户能够访问到的功能权限放入到session中
			this.getSession().setAttribute("functions", functions);
			return "index";
		}
	}
}
