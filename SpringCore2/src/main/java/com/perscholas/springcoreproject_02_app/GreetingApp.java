package com.perscholas.springcoreproject_02_app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perscholas.springcoreproject_02.models.Person;

public class GreetingApp {
	public static void main(String[]args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("com/perscholas/springcoreproject_02_bean_def/BeanDef.xml");
		Person p=context.getBean("Person", Person.class);
		Person p1=context.getBean("Person1", Person.class);
		Person p2=context.getBean("Person2", Person.class);
		
		System.out.println(p.getGreetingService().sayHello());
		System.out.println(p.getGreetingService().sayWelcome());
		
		System.out.println(p1.getGreetingService().sayHello());
		System.out.println(p1.getGreetingService().sayWelcome());
		
		System.out.println(p2.getGreetingService().sayHello());
		System.out.println(p2.getGreetingService().sayWelcome());
		
		context.close();
		
	}

}
