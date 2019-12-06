package com.perscholas.springcoreproject_02_greeting_interface_implement;

import com.perscholas.springcoreproject_02_greeting_interface.GreetingService;

public class FrenchGreeting implements GreetingService {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "howdy y'all!";
	}

	@Override
	public String sayWelcome() {
		// TODO Auto-generated method stub
		return "y'all come on in";
	}

}
