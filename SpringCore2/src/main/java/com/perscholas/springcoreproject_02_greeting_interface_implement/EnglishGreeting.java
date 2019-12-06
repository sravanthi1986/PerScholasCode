package com.perscholas.springcoreproject_02_greeting_interface_implement;

import com.perscholas.springcoreproject_02_greeting_interface.GreetingService;

public class EnglishGreeting implements GreetingService {

	@Override
	public String sayHello() {
		return "hello perscholas";
	}

	@Override
	public String sayWelcome() {
		// TODO Auto-generated method stub
		return "welcome perscholas";
	}

}
