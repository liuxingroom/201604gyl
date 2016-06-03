package com.xing.gyl.base.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xing.gyl.base.dao.BaseDao;
import com.xing.gyl.base.service.BaseService;
import com.xing.gyl.query.BaseQuery;
import com.xing.gyl.query.PageResult;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	/**
	 * 该类中需要dao的实体类来操作dao层  由于带泛型的类在spring容器中无法创建对象  （因此不能注入BaseDaoImpl对象）
	 * 该层又不能注入具体实现的dao（如DepartmentDaoImpl） 
	 * 因此定义一个抽象方法由子类实现  获取子类中注入是dao对象
	 * @return
	 */
	public abstract BaseDao<T> getBaseDao();
	
	@Override
	public PageResult<T> getPageResult(BaseQuery baseQuery) {
		// TODO Auto-generated method stub
		return this.getBaseDao().findPageResult(baseQuery);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveEntry(T t) {
		// TODO Auto-generated method stub
		this.getBaseDao().saveEntry(t);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void updateEntry(T t) {
		// TODO Auto-generated method stub
		this.getBaseDao().updateEntry(t);
	}

	@Override
	public T getEntryById(Serializable id) {
		// TODO Auto-generated method stub
		return this.getBaseDao().getEntryById(id);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteEntryByIds(Serializable[] ids) {
		// TODO Auto-generated method stub
		this.getBaseDao().deleteEntryByIDS(ids);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteEntryById(Serializable id) {
		// TODO Auto-generated method stub
		this.getBaseDao().deleteEntry(id);
	}
	
	@Override
	public List<T> findEntrys(){
		return this.getBaseDao().findEntrys();
	}
	
	@Override
	public List<T> getEntryByIds(Serializable ids[]){
		return this.getBaseDao().getEntryByIds(ids);
	}
}
