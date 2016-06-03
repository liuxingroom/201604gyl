package com.xing.gyl.base.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xing.gyl.base.dao.BaseDao;
import com.xing.gyl.query.BaseQuery;
import com.xing.gyl.query.PageResult;
import com.xing.gyl.utils.GyUtils;

public class BaseDaoImpl<T> implements BaseDao<T>{

	private  final Class clazz;
	private ClassMetadata classMetadata; //元数据用来描述持久换对象的数据
	/**
	 * 把泛型的参数提取出来的过程放入到构造函数中写，因为
	 * 当子类创建对象的时候，直接调用父类的构造函数
	 */
	public BaseDaoImpl(){
		/**
		 * this代表子类
		 * this.getClass().getGenericSuperclass()就是父类:BaseDaoImpl<T> 泛型
		 * 如果不带T,this.getClass().getGenericSuperclass()返回的是class类型，而不是ParameterizedType
		 * spring(2.x和3.x)容器不支持带泛型的创建对象
		 */
		ParameterizedType parameterizedType=(ParameterizedType) this.getClass().getGenericSuperclass();
		clazz=(Class) parameterizedType.getActualTypeArguments()[0];
	}
	
	@PostConstruct	
	public void init(){//初始化方法获取元数据
		classMetadata=this.hibernateTemplate.getSessionFactory().getClassMetadata(clazz);
	}
	
	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate;
	
	/**
	 * 分页查询
	 */
	@Override
	public PageResult<T> findPageResult(final BaseQuery baseQuery) {
		//返回根据查询条件查询的总的记录数
		int totalRows=this.getCount(baseQuery);
		//创建PageResult对象
		final PageResult<T> pageResult=new PageResult<T>(baseQuery.getCurrentPage(),baseQuery.getPageSize(),totalRows);
		/**
		 * 拼接where条件语句
		 */
		final StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("from "+this.clazz.getSimpleName());
		stringBuffer.append(" where 1=1 ");
		System.out.println(stringBuffer.toString());
		
		//在map中封装查询的条件
		final Map<String, Object> keyValues=baseQuery.buildWhere();
		//拼接查询条件
		for(Map.Entry<String, Object> entry:keyValues.entrySet()){
			/**
			 * 在一对多的情况下，例如Xsyddzhib
			 *    entry.getKey()="xsyddzhub.xsyddzhubid"
			 *    "where xsyddzhub.xsyddzhubid=:xsyddzhubid"
			 */
			if(entry.getKey().contains(".")){
				stringBuffer.append(" and "+entry.getKey()+"=:"+entry.getKey().split("\\.")[1]);
			}else{
				stringBuffer.append(" and "+entry.getKey()+"=:"+entry.getKey());
			}
		}
		return this.hibernateTemplate.execute(new HibernateCallback<PageResult<T>>() {
			@Override
			public PageResult<T> doInHibernate(Session session) throws HibernateException,
					SQLException {
				//根据拼接的hql语句产生一个query对象
				Query query=session.createQuery(stringBuffer.toString());
				/**
				 * 给hql语句的参数赋值
				 */
				for(Map.Entry<String, Object> entry:keyValues.entrySet()){
					if(entry.getKey().contains(".")){
						/**
						 * "where xsyddzhub.xsyddzhubid=:xsyddzhubid"的=:后面的赋值
						 */
						query.setParameter(entry.getKey().split("\\.")[1], entry.getValue());
					}else{
						query.setParameter(entry.getKey(), entry.getValue());
					}
				}
				//设置当前页的第一行在集合中的位置
				int firstResult=(baseQuery.getCurrentPage()-1)*baseQuery.getPageSize();
				//设置每页显示多少行
				int maxResult=baseQuery.getPageSize();
				//使用hibernate设置分页
				query.setFirstResult(firstResult).setMaxResults(maxResult);
				//返回分页结果
				List<T> rows=query.list();
				pageResult.setRows(rows);
				return pageResult;
			}
		});
	}
	
	@Override
	public List<T> findEntrys() {
		// TODO Auto-generated method stub
		List<T> list=this.hibernateTemplate.find("from "+this.clazz.getSimpleName());
		return list;
	}

	@Override
	public void saveEntry(T t) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(t);
	}

	@Override
	public void updateEntry(T t) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.update(t);
	}

	@Override
	public void deleteEntry(Serializable id) {
		// TODO Auto-generated method stub
		T t=this.getEntryById(id);
		this.hibernateTemplate.delete(t);
	}
	
	@Override
	public void deleteEntryByIDS(Serializable[] ids) {
		// TODO Auto-generated method stub
		for(Serializable id:ids){
			this.deleteEntry(id);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getEntryById(Serializable id) {
		// TODO Auto-generated method stub
		
		return (T) this.hibernateTemplate.get(clazz, id);
	}
	
	@Override
	public List<T> getEntryByIds(Serializable[] ids) {
		// TODO Auto-generated method stub
		ArrayList<T> list=new ArrayList<T>(); 
		for(Serializable id:ids){
			list.add(this.getEntryById(id));
		}
		return list;
	}

	@Override
	public int getCount(final BaseQuery baseQuery) {
		return this.hibernateTemplate.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException,
					SQLException {
				StringBuffer stringBuffer=new StringBuffer();
				stringBuffer.append("select count(*) from "+clazz.getSimpleName());
				stringBuffer.append(" where 1=1 ");
				//获取所有的查询条件
				Map<String,Object> keyValues=baseQuery.buildWhere();
				
				/**
				 *拼接查询条件 
				 */
				for(Map.Entry<String, Object> entry:keyValues.entrySet()){
					/**
					 * 在一对多的情况下，例如Xsyddzhib
					 *    entry.getKey()="xsyddzhub.xsyddzhubid"
					 *    "where xsyddzhub.xsyddzhubid=:xsyddzhubid"
					 */
					if(entry.getKey().contains(".")){
						stringBuffer.append(" and "+entry.getKey()+"=:"+entry.getKey().split("\\.")[1]);
					}else{
						stringBuffer.append(" and "+entry.getKey()+"=:"+entry.getKey());
					}
				}
				System.out.println("hql语句："+stringBuffer.toString());
				
				Query query=session.createQuery(stringBuffer.toString());
				
				/**
				 * 把where条件中的参数传递值得过程 
				 */
				for(Map.Entry<String, Object> entry:keyValues.entrySet()){
					if(entry.getKey().contains(".")){
						/**
						 * "where xsyddzhub.xsyddzhubid=:xsyddzhubid"的=:后面的赋值
						 */
						query.setParameter(entry.getKey().split("\\.")[1], entry.getValue());
					}else{
						query.setParameter(entry.getKey(), entry.getValue());
					}
				}
				//	uniqueResult获取唯一的结果
				Long num=(Long) query.uniqueResult();
				
				return num.intValue();
			}
		});
	}
	
	/**
	 * 获取子表或者主表的订单号
	 */
	@Override
	public String getMax() {
		// TODO Auto-generated method stub
		/**
		 * 把订单号的前8为数字提取到，然后和今天的时间作对比，如果一样，说明今天已经产生订单号了
		 * 如果没有，说明今天没有订单号
		 */
		
		List list=this.hibernateTemplate.find("select max(ddh) from "+this.clazz.getSimpleName()+" where ddh like '%"+GyUtils.getDateToString()+"%'");
		if(list!=null){
			if(list.get(0)==null){
				return GyUtils.getDateToString()+"0001";
			}else{
				String temp=(String) list.get(0);
				return ""+(Long.parseLong(temp)+1);
			}
		}else{
			return null;
		}
	}
	
}
