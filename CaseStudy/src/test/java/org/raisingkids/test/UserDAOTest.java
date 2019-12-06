package org.raisingkids.test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.raisingkids.dao.UserDAO;
import org.raisingkids.model.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDAOTest {
	public static UserDAO userDAO;
	public static Boolean connectedDB;
	public static Integer testDataUserId_1;
	public static Integer testDataUserId_2;
	public static Integer testDataUserId_3;
	public static Integer userId_fromTest;
	public static User testDataBean1;
	public static User testUser;
	
	/* Fill the database with the test data used for the test cases
	   Test data used for these test cases can be found here!
	*/
	@BeforeClass
	public static void setUpTestObject() throws ClassNotFoundException, SQLException, IOException {
		userDAO = new UserDAO();
		// If the object returned by testConnection() is not null then connection successful
		if (Objects.nonNull(userDAO.testConnection())) {

			connectedDB = true;

			// Test data inserted into the database used to test DAO methods
			try {
				
				testDataBean1 = new User("Test1", "password1", "admin");
				User testDataBean2 = new User("Test2", "password1", "admin");
				User testDataBean3 = new User("Test3", "password1", "admin");
				testDataUserId_1 = userDAO.createUser(testDataBean1);
				testDataUserId_2 = userDAO.createUser(testDataBean2);
				testDataUserId_3 = userDAO.createUser(testDataBean3);

			} catch (Exception e) {

				System.out.println("Unable to insert Test data into DB"+e.getMessage());

			}

		} else {

			connectedDB = false;

		}
	}

	@Test
	public void testCreateUser() {
		assumeTrue(connectedDB);
		testUser = new User("userFromTest"+new Random().nextInt(1000), "password", "admin");
		try {
			// Insert the object into the database
			userId_fromTest = userDAO.createUser(testUser);
			assertThat(userId_fromTest, not(-1));
			// Make sure all information inserted in correct and consistent
			User actualUser = userDAO.getuserById(userId_fromTest);
			assertNotNull(actualUser);
			assertEquals(testUser.getUserName(), actualUser.getUserName());

		} catch (Exception e) {
			System.out.println("Unable to insert User into DB");
		}

	}

	@Test
	public void testGetUserbyId() {
		assumeTrue(connectedDB);
		try {
			// Make sure Null is not returned when given a valid ID
			User actualUser = userDAO.getuserById(testDataUserId_1);
			assertNotNull(actualUser);
			// Make sure Null is returned when an invalid ID is provided
			assertNull(userDAO.getuserById(10000));
			// Make sure returned data match with test data bean
			assertEquals(actualUser.getUserName(), testDataBean1.getUserName());

		} catch (Exception e) {
			System.out.println("Unable to Get User from DB");
		}

	}
	
	@Test
	public void testGetUserByUserName() {
		assumeTrue(connectedDB);
		try {
			// Make sure Null is not returned when given a valid user Name
			User actualUser = userDAO.getuserByUserName("Test2"); // positive test case
			assertNotNull(actualUser);
			// Make sure Null is returned when an invalid userName is provided
			assertNull(userDAO.getuserByUserName("Rams1004")); // Negative test case

		} catch (Exception e) {
			System.out.println("Unable to Get User from DB");
		}

	}

	@Test
	public void testUpdateUser() {
		assumeTrue(connectedDB);
		User updateUser = new User("Test2", "updated_password", "admin");
		try {
			// Make sure the user was actually updated
			assertTrue(userDAO.updateUser(updateUser));
			User actualUser = userDAO.getuserByUserName(updateUser.getUserName());
			assertNotNull(actualUser);
			assertEquals(updateUser.getUserName(), actualUser.getUserName());

		} catch (Exception e) {
			System.out.println("Unable to Update User into DB"+e.getMessage());
		}

	}
	
	

	@Test
	public void testZRemoveUserById() {
		assumeTrue(connectedDB);
		try {
			assertTrue(userDAO.removeUserbyId(testDataUserId_3));
			assertFalse(userDAO.removeUserbyId(1000));
			assertNull(userDAO.getuserById(testDataUserId_3));

		} catch (Exception e) {
			System.out.println("Unable to remove User from DB by Id");
		}

	}
	
	@Test
	public void testXRemoveUserByName() {
		assumeTrue(connectedDB);
		try {
			assertTrue(userDAO.removeUserbyUserName("Test2"));
			assertFalse(userDAO.removeUserbyUserName("Test1000"));
			assertNull(userDAO.getuserByUserName("Test2"));

		} catch (Exception e) {
			System.out.println("Unable to remove User from DB by Name"+e.getMessage());
		}

	}

	@AfterClass
	public static void cleanUpTestObject() throws ClassNotFoundException, SQLException, IOException {
		try {
			userDAO.removeUserbyId(testDataUserId_1);
			System.out.println("=====Removed Test data sucessfully========");
			System.out.println("=====Test Executed sucessfully========");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
