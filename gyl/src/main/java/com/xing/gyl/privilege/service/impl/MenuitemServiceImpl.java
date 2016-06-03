package com.xing.gyl.privilege.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xing.gyl.base.dao.BaseDao;
import com.xing.gyl.base.service.impl.BaseServiceImpl;
import com.xing.gyl.domain.privilege.Menuitem;
import com.xing.gyl.privilege.dao.MenuitemDao;
import com.xing.gyl.privilege.service.MenuitemService;

@Service(MenuitemService.SERVICE_NAME)
public class MenuitemServiceImpl extends BaseServiceImpl<Menuitem> implements MenuitemService{
	//注入权限dao
	@Resource(name=MenuitemDao.SERVICE_NAME)
	MenuitemDao menuitemDao;
	
	@Override
	public BaseDao<Menuitem> getBaseDao() {
		// TODO Auto-generated method stub
		return menuitemDao;
	}
	
}
