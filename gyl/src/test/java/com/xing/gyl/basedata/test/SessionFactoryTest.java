package com.xing.gyl.basedata.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.xing.gyl.test.utils.SpringUtils;

public class SessionFactoryTest extends SpringUtils{
	@Test
	public void testSessionFactory(){
		context.getBean("sessionFactory");
	}
	
//	@Test
//	public void testCuntProduct(){
//		SessionFactory sessionFactory=(SessionFactory) context.getBean("sessionFactory");
//		Session session=sessionFactory.openSession();
//		Long count=(Long) session.createQuery("select count(*) from Department").uniqueResult();
//		System.out.println(count);
//		session.close();
//	}
}
