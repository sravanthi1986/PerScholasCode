package org.perscholas3;

public class Course {
	private int courseId;
	private String courseName;
	private String courseDesciption;
	
	public  Course(){
		
	}
	
    public  Course(int id,String name, String description){   	
    	this.courseId = id;
    	this.courseName = name;
    	this.courseDesciption = description;
		
	}
	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return the courseDesciption
	 */
	public String getCourseDesciption() {
		return courseDesciption;
	}
	/**
	 * @param courseDesciption the courseDesciption to set
	 */
	public void setCourseDesciption(String courseDesciption) {
		this.courseDesciption = courseDesciption;
	}
    
	@Override
    public String toString(){
		return String.format("Course Id: "+courseId+"\n" +"Course Name: "+courseName+"\n"+"Course Description: "+courseDesciption);
    }
	

}
