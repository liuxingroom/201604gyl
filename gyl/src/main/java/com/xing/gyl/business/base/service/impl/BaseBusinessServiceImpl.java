package com.xing.gyl.business.base.service.impl;

import java.io.Serializable;

import com.xing.gyl.base.dao.BaseDao;
import com.xing.gyl.business.base.service.BaseBusinessService;
import com.xing.gyl.query.BaseQuery;
import com.xing.gyl.query.PageResult;

public abstract class BaseBusinessServiceImpl<T,E extends Serializable> implements BaseBusinessService<T,E>{
	public abstract BaseDao<T> getBaseDao_zhu();//得到主表dao
	public abstract BaseDao<E> getBaseDao_zhi();//得到字表dao
	
	@Override
	public PageResult<T> getEntrties_zhu(BaseQuery baseQuery) {
		// TODO Auto-generated method stub
		
		return this.getBaseDao_zhu().findPageResult(baseQuery);
	}

	@Override
	public PageResult<E> getEntrties_zhi(BaseQuery baseQuery) {
		// TODO Auto-generated method stub
		return this.getBaseDao_zhi().findPageResult(baseQuery);
	}

}
