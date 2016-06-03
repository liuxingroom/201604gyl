package com.xing.gyl.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.xing.gyl.base.dao.impl.BaseDaoImpl;
import com.xing.gyl.basedata.dao.ProductDao;
import com.xing.gyl.domain.basedata.Product;

@Repository(ProductDao.SERVICENAME)
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao{
	
}
