package com.xing.gyl.privilege.interceptor;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.xing.gyl.domain.privilege.Privilege;
import com.xing.gyl.privilege.annotation.AnnotationParse;

public class PrivilegeInterceptor extends MethodFilterInterceptor {
	
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		/**
		 * 首先获取用户所用户的功能权限
		 */
		List<Privilege> privileges=
				(List<Privilege>) ServletActionContext.getRequest().getSession().getAttribute("functions");
		
		/**
		 * 获取访问目标方法的注解的name 属性的值
		 */
		Class targetClass=invocation.getAction().getClass();
		String methodName=invocation.getProxy().getMethod();
		String accessMethod=AnnotationParse.parse(targetClass, methodName);
		if("".equals(accessMethod)){//如果目标方法上没有写权限的注解，或者写了权限的注解，但是没有写name属性，放行
			return invocation.invoke();
		}else{
			/**
			 * 判断用户是否具有该功能权限
			 */
			boolean flag=false;
			for(Privilege privilege:privileges){
				if(privilege.getName().equals(accessMethod)){
					flag=true;
					break;
				}
			}
			
			
			if(flag){//有权限
				return invocation.invoke();
			}else {//没有权限
				ActionContext.getContext().getValueStack().push("您没有权限访问");
				return "privilege_error";
			}
		}
		
	}
}
