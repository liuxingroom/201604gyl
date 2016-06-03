package com.xing.postconstruct.test;

import org.junit.Test;

import com.xing.gyl.test.utils.SpringUtils;

public class MainTest extends SpringUtils{
	@Test
	public void testMain() {   
     //   PersonService personService=(PersonService)context.getBean("personService");  
     //   personService.dostory();  
		PersonService personService=new PersonService();
        System.out.println("sss");
    }  
}
