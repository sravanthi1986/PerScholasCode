package com.perscholas.springcoreproject_01.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.perscholas.springcoreproject_01.models.SpringGreeting;
public class SpringGreetingApp {
    
    public static void main(String[] args) {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("/com/perscholas/springcoreproject_01/bean_def/BeanDef.xml");
        SpringGreeting sg = context.getBean("springGreeting", SpringGreeting.class);
        System.out.println(sg.sayHello());
    //    System.out.println(SpringGreeting.staticString());
        context.close();
        
    }
}

