package org.raisingkids.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDetails {
	
	@Id
	@GeneratedValue
	private int userId;
	@Size(min=2, max=50,  message="First Name must be between 4 and 50 characters long.")
	@NotBlank(message="First Name required.")
	private String firstName;
	@Size(min=2, max=50,  message="Last Name must be between 4 and 50 characters long.")
	@NotBlank(message="Last Name required.")
	private String lastName;
	@Size(min=2, max=50,  message="EmailId must be between 4 and 50 characters long.")
	@NotBlank(message="Email Id required.")
	private String emailId;
	@NotBlank(message="ContactNO required.")
	private String contactNo;
	
	public UserDetails() {}
	
	public UserDetails(int userId, String firstName, String lastName, String emailId,String contactNo) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.contactNo = contactNo;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", contactNo=" + contactNo + "]";
	}
	
	
}
