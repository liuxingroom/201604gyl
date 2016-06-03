package com.xing.postconstruct.test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PersonService {
	private String  message;  
	  
    public String getMessage() {  
        return message;  
    }  
  
    public void setMessage(String message) {  
        this.message = message;  
    }  
      
    public PersonService(){
    	System.out.println("fff");
    }
    @PostConstruct  
    public void  init(){
        System.out.println("I'm  init  method  using  @PostConstrut...."+message);  
    }  
      
    @PreDestroy  
    public void  dostory(){  
        System.out.println("I'm  destory method  using  @PreDestroy....."+message);  
    } 
}
