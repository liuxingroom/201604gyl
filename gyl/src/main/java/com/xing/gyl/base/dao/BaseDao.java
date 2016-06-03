package com.xing.gyl.base.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.xing.gyl.query.BaseQuery;
import com.xing.gyl.query.PageResult;

public interface BaseDao<T> {
	
	/**
	 * 分页查询
	 */
	public PageResult<T> findPageResult(final BaseQuery baseQuery);
	
	/**
	 * 不分页查寻
	 */
	public List<T> findEntrys();
	
	/**
	 * 保存
	 */
	public void saveEntry(T t);
	
	/**
	 * 修改
	 */
	public void updateEntry(T t);
	
	/**
	 * 根据id删除一些数据
	 */
	public void deleteEntryByIDS(Serializable[] ids);
	
	/**
	 * 根据id删除一条数据
	 */
	public void deleteEntry(Serializable id);
	
	/**
	 * 根据id提取一条数据
	 */
	public T getEntryById(Serializable id);
	
	/**
	 * 根据ids提取很多条数据
	 */
	public List<T> getEntryByIds(Serializable ids[]);
	
	/**
	 * 查询一张表的总记录数
	 */
	public int getCount(BaseQuery baseQuery);
	
	/**
	 * 用来获取订单号的最大值    子表和主表都可以使用
	 */
	public String getMax();
}
