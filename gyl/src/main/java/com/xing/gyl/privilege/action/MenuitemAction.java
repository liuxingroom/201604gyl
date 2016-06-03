package com.xing.gyl.privilege.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xing.gyl.base.action.BaseAction;
import com.xing.gyl.domain.privilege.Menuitem;
import com.xing.gyl.privilege.service.MenuitemService;

@Controller("menuitemAction")
@Scope("prototype")
public class MenuitemAction extends BaseAction<Menuitem>{
	Menuitem menuitem=this.getModel();
	//注入menuitemService
	@Resource(name=MenuitemService.SERVICE_NAME)
	MenuitemService menuitemService;
	
	public  String showMenuitemTree(){
		List<Menuitem> menuitems= this.menuitemService.findEntrys();
		ActionContext.getContext().getValueStack().push(menuitems);
		return "showMenuitemTree";
	}
}
