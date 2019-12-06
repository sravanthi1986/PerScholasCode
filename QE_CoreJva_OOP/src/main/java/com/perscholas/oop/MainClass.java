package com.perscholas.oop;

import org.oops.model.Student;

public class MainClass {
	
	public static void main(String [] args) {
		
  // System.out.println("heloooo main qe");
   //MainClass mc=new MainClass();
	//mc.sayHello();
	//mc.returnHello();
		//ClassOne classone=new ClassOne();
		//ClassOne classone1=new ClassOne();
		
		//ClassOne.helloFromClassOne();
		//ClassOneA.helloFromClassOne();
		//System.out.println(classOne.returnHelloFromClassOne());
		Student s1=new Student();
		Student s2=new Student("bujji","buuhji@gmil.com");
		System.out.println(s1.getName());
		System.out.println(s2.getName());


		
	}

	public void sayHello() {
		System.out.println("hello buddyy");
	}
	
	public String returnHello() {
		return "hello from qe";
	}
}
