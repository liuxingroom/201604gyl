package com.xing.gyl.business.base.service;

import java.io.Serializable;

import com.xing.gyl.query.BaseQuery;
import com.xing.gyl.query.PageResult;

/**
 * 
 * @author xing
 *
 * @param <T>代表主表
 * @param <E>代表子表
 */
public interface BaseBusinessService<T,E extends Serializable> {
	/**
	 * 返回主表的查询
	 * @param baseQuery 封装的查询条件
	 * @return 返回查询的结果
	 */
	public PageResult<T> getEntrties_zhu(BaseQuery baseQuery);
	
	/**
	 * 返回字表的查询
	 * @param baseQuery 封装的查询条件
	 * @return 返回查询的结果
	 */
	public PageResult<E> getEntrties_zhi(BaseQuery baseQuery);
	
	/**
	 * 得到订单号的最大值+1
	 * @return
	 */
	public String getMax();
	
	/**
	 * 保存主表，级联保存子表
	 */
	public void saveEntry_zhu(T t);
}
