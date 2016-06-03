package com.xing.gyl.base.service;

import java.io.Serializable;
import java.util.List;

import com.xing.gyl.domain.basedata.User;
import com.xing.gyl.query.BaseQuery;
import com.xing.gyl.query.PageResult;

public interface BaseService<T> {
	
	public PageResult<T> getPageResult(BaseQuery baseQuery);
	public void saveEntry(T t);
	public void updateEntry(T t);
	public T getEntryById(Serializable id);
	public void deleteEntryByIds(Serializable [] ids);
	public void deleteEntryById(Serializable id);
	public List<T> findEntrys();
	public List<T> getEntryByIds(Serializable ids[]);
}
