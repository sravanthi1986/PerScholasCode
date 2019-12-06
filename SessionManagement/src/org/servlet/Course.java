package org.servlet;

public class Course {

	int courseId;
	String name;
	String description;
	Course(){}
	
	public Course(int courseId, String name, String description) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.description = description;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
