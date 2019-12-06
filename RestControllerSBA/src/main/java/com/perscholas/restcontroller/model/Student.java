package com.perscholas.restcontroller.model;

public class Student {
	private Integer studentID;
	private String name;
	private String email;
	private String[] courseList;
	/**
	 * @return the studentID
	 */
	public Integer getStudentID() {
		return studentID;
	}
	public Student(Integer studentID, String name, String email, String[] courseList) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.email = email;
		this.courseList = courseList;
	}
	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the courseList
	 */
	public String[] getCourseList() {
		return courseList;
	}
	/**
	 * @param courseList the courseList to set
	 */
	public void setCourseList(String[] courseList) {
		this.courseList = courseList;
	}
	

}
