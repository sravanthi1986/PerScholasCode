package com.perscholas.snacks_repository.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Snacks {
	@Id
	@GeneratedValue
	private Integer snacksid;
	
	@Size(min=2, max=50,  message="Title must be between 2 and 50 characters long.")
	@NotBlank(message="snacksname is required.")
	private String snacksname;
	
	@Size(min=2, max=50,  message="Author name must be between 2 and 50 characters long.")
	@NotBlank(message="student name is required.")
	private String studentname;

	/**
	 * @return the snacksid
	 */
	public Integer getSnacksid() {
		return snacksid;
	}

	/**
	 * @param snacksid the snacksid to set
	 */
	public void setSnacksid(Integer snacksid) {
		this.snacksid = snacksid;
	}

	/**
	 * @return the snacksname
	 */
	public String getSnacksname() {
		return snacksname;
	}

	/**
	 * @param snacksname the snacksname to set
	 */
	public void setSnacksname(String snacksname) {
		this.snacksname = snacksname;
	}

	/**
	 * @return the studentname
	 */
	public String getStudentname() {
		return studentname;
	}

	/**
	 * @param studentname the studentname to set
	 */
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	
	}
