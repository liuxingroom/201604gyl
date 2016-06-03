package com.xing.gyl.business.xsgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xing.gyl.base.dao.BaseDao;
import com.xing.gyl.business.base.service.impl.BaseBusinessServiceImpl;
import com.xing.gyl.business.xsgl.dao.XsyddzhiDao;
import com.xing.gyl.business.xsgl.dao.XsyddzhubDao;
import com.xing.gyl.business.xsgl.service.XsyddService;
import com.xing.gyl.domain.business.xsgl.Xsyddzhib;
import com.xing.gyl.domain.business.xsgl.Xsyddzhub;

@Service(XsyddService.SERVICE_NAME)
public class XsyddServiceImpl extends BaseBusinessServiceImpl<Xsyddzhub, Xsyddzhib> implements XsyddService{
	@Resource(name=XsyddzhubDao.SERVICE_NAME)
	XsyddzhubDao xsyddzhubDao;
	@Resource(name=XsyddzhiDao.SERVICE_NAME)
	XsyddzhiDao  xsyddzhiDao;
		
	@Override
	public BaseDao<Xsyddzhub> getBaseDao_zhu() {
		// TODO Auto-generated method stub
		return xsyddzhubDao;
	}

	@Override
	public BaseDao<Xsyddzhib> getBaseDao_zhi() {
		// TODO Auto-generated method stub
		return xsyddzhiDao;
	}

	@Override
	public String getMax() {
		
		return this.xsyddzhubDao.getMax();
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveEntry_zhu(Xsyddzhub t) {
		// TODO Auto-generated method stub
		this.xsyddzhubDao.saveEntry(t);
	}
	
}
