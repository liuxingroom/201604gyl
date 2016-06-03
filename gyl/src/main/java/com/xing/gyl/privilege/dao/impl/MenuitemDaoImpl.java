package com.xing.gyl.privilege.dao.impl;

import org.springframework.stereotype.Repository;

import com.xing.gyl.base.dao.impl.BaseDaoImpl;
import com.xing.gyl.domain.privilege.Menuitem;
import com.xing.gyl.privilege.dao.MenuitemDao;

@Repository(MenuitemDao.SERVICE_NAME)
public class MenuitemDaoImpl extends BaseDaoImpl<Menuitem> implements MenuitemDao{

}
