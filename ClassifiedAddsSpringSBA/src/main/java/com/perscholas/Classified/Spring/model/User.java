package com.perscholas.Classified.Spring.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=5, max=20,  message="User Name must be between 5 and 20 characters long.")
	@NotBlank(message="User Name is required.")
	private String userName;
	
	@Size(min=4, max=50,  message="Password must be between 4 and 50 characters long.")
	@NotBlank(message="Author name is required.")
	private String password;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
