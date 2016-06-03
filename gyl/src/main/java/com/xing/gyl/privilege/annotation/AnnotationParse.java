package com.xing.gyl.privilege.annotation;

import java.lang.reflect.Method;

public class AnnotationParse {
	/**
	 * 提供一个目标类，提供一个目标方法，获取目标方法上面的注解的name属性的值
	 * @param targetClass
	 * @param methodName
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws Exception
	 */
	public static String parse(Class targetClass,String methodName) throws NoSuchMethodException, SecurityException{
		String accessMethod="";
		//通过反射的方法  获取方法对象
		Method method=targetClass.getMethod(methodName);
		if(method.isAnnotationPresent(targetClass)){//如果方法上存在注解  就获取该注解的值
			//先获取该注解的对象
			PrivilegeInfo privilegeInfo=method.getAnnotation(PrivilegeInfo.class);
			//获取该注解的值
			accessMethod=privilegeInfo.name();
		}
		
		return accessMethod;
	}
}
