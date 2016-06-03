package com.xing.gyl.test.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {
	public static ApplicationContext context;
	static{
		context = new ClassPathXmlApplicationContext("com/xing/gyl/spring/applicationContext.xml");
		System.out.println("sss");
	}
}