package Project05;

import java.util.Date;

public class User5 {

	int userId;
	String firstName;
	String lastName;
	String userEmail;
	String userPassword; 
	Date userDOB;
	
	public User5() {}

	public User5(int userId, String firstName, String lastName, String userEmail, String userPassword, Date userDOB) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userDOB = userDOB;
	}
	public User5(String firstName, String lastName, String userEmail, String userPassword, Date userDOB) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userDOB = userDOB;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
	 * @return the userDOB
	 */
	public Date getUserDOB() {
		return userDOB;
	}

	/**
	 * @param userDOB the userDOB to set
	 */
	public void setUserDOB(Date userDOB) {
		this.userDOB = userDOB;
	}

	@Override
	public String toString() {
		return "User5 [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userEmail="
				+ userEmail + ", userPassword=" + userPassword + ", userDOB=" + userDOB + "]";
	}
	
    
}
