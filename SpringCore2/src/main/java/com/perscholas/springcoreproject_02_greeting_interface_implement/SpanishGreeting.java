package com.perscholas.springcoreproject_02_greeting_interface_implement;

import com.perscholas.springcoreproject_02_greeting_interface.GreetingService;

public class SpanishGreeting implements GreetingService {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "hola perscholas";
	}

	@Override
	public String sayWelcome() {
		// TODO Auto-generated method stub
		return "bievenious";
	}

}
