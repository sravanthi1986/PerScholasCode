package org.oops.model;

public class Student {

	//state and behaviour
	private String name;
	private String email;
	//Constructors
	public Student() {}
	public Student(String name,String email) {
		this.name=name;
		this.email=email;
	}
	//gettersetter go to source <-genearate getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
		


}
