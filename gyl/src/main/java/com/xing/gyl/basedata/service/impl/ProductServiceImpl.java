package com.xing.gyl.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.xing.gyl.base.dao.BaseDao;
import com.xing.gyl.base.service.impl.BaseServiceImpl;
import com.xing.gyl.basedata.dao.ProductDao;
import com.xing.gyl.basedata.service.ProductService;
import com.xing.gyl.domain.basedata.Product;

@Repository(ProductService.SERVICE_NAME)
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService{
	
	@Resource(name=ProductDao.SERVICENAME)
	ProductDao productDao;
	@Override
	public BaseDao<Product> getBaseDao() {
		// TODO Auto-generated method stub
		return productDao;
	}

}
