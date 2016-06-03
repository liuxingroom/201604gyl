package com.xing.gyl.business.xsgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xing.gyl.base.dao.BaseDao;
import com.xing.gyl.business.base.service.impl.BaseBusinessServiceImpl;
import com.xing.gyl.business.xsgl.dao.XsddzhibDao;
import com.xing.gyl.business.xsgl.dao.XsddzhubDao;
import com.xing.gyl.business.xsgl.service.XsddService;
import com.xing.gyl.domain.business.xsgl.Xsddzhib;
import com.xing.gyl.domain.business.xsgl.Xsddzhub;

@Service(XsddService.SERVICE_NAME)
public class XsddServiceImpl extends BaseBusinessServiceImpl<Xsddzhub, Xsddzhib> implements XsddService{
	//注入子表dao
	@Resource(name=XsddzhibDao.SERVICE_NAME)
	XsddzhibDao xsddzhibDao;
	//注入主表dao
	@Resource(name=XsddzhubDao.SERVICE_NAME)
	XsddzhubDao xsddzhubDao;
	
	
	@Override
	public BaseDao<Xsddzhub> getBaseDao_zhu() {
		// TODO Auto-generated method stub
		return xsddzhubDao;
	}

	@Override
	public BaseDao<Xsddzhib> getBaseDao_zhi() {
		// TODO Auto-generated method stub
		return xsddzhibDao;
	}
	
	@Override
	public String getMax() {
		// TODO Auto-generated method stub
		return this.xsddzhubDao.getMax();
	}

	@Override
	public void saveEntry_zhu(Xsddzhub t) {
		// TODO Auto-generated method stub
		
	}

	
	
}
