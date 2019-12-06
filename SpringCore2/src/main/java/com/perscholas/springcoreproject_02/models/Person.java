package com.perscholas.springcoreproject_02.models;

import com.perscholas.springcoreproject_02_greeting_interface.GreetingService;

public class Person {
    private GreetingService greetingService;
    
    public Person(GreetingService greetingService) {
    	this.greetingService=greetingService;
    }
    public GreetingService getGreetingService() {
    	
    	return greetingService;
    }
    public void setGreetingService(GreetingService greetingService) {
             this.greetingService =  greetingService;
    }
}
