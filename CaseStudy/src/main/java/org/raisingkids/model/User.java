package org.raisingkids.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
	@Id
	@GeneratedValue
	private Integer userId;
	
	@Size(min=2, max=50,  message="User Name must be between 4 and 50 characters long.")
	@NotBlank(message="User Name required.")
	private String userName;
	@Size(min=2, max=50,  message="Password must be between 4 and 50 characters long.")
	@NotBlank(message="Password is required.")
	private String userPassword;
	private String userRole;
	/**
	 * @return the userId
	 */
	
	public User() {}
	
	public Integer getUserId() {
		return userId;
	}
	public User(int userId, String userName, String userPassword, String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRole = userRole;
	}
	public User(String userName, String userPassword, String userRole) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRole = userRole;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}
	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}
	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userRole="
				+ userRole + "]";
	}
	

}
