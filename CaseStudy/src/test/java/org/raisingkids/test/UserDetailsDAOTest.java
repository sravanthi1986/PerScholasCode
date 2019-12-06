package org.raisingkids.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.raisingkids.dao.UserDAO;
import org.raisingkids.dao.UserDetailsDAO;
import org.raisingkids.model.User;
import org.raisingkids.model.UserDetails;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDetailsDAOTest {
	public static UserDetailsDAO userDetailsDAO;
	public static Boolean connectedDB;
	public static Integer testDataUserId;
	public static Integer udId_fromTest;
	public static Integer testUdId;
	public static UserDetails userDetailsBean2;
	public static UserDAO userDAO;

	/*
	 * Fill the database with the test data used for the test cases Test data used
	 * for these test cases can be found here!
	 */
	@BeforeClass
	public static void setUpTestObject() throws ClassNotFoundException, SQLException, IOException {
		userDetailsDAO = new UserDetailsDAO();
		userDAO = new UserDAO();
		// If the object returned by testConnection() is not null then connection
		// successful
		if (Objects.nonNull(userDetailsDAO.testConnection())) {

			connectedDB = true;

			// Test data inserted into the database used to test DAO methods
			try {
				// create test User
				User userTestData = new User("testUserDetails", "password1", "admin");
				testDataUserId = userDAO.createUser(userTestData);
				User userTestData2 = new User("testUserDetails2", "password1", "admin");
				Integer testDataUserId2 = userDAO.createUser(userTestData2);
				userDetailsBean2 = new UserDetails(testDataUserId2, "jUnit FirstName2", "jUnit LastName2", "junit2@test.com","2017445190");
				userDetailsDAO.createUserDetails(userDetailsBean2);

			} catch (Exception e) {
				System.out.println("Unable to insert test data into DB");
			}

		} else {
			connectedDB = false;
		}
	}

	@Test
	public void testCreateUserDetails() {
		assumeTrue(connectedDB);
		try {
			UserDetails testUserDetails = new UserDetails(testDataUserId, "FirstName2", "LastName2", "junit3@test.com",
					"2027445190");
			// Insert the object into the database
			Integer udId_fromTest = userDetailsDAO.createUserDetails(testUserDetails);
			//System.out.println(udId_fromTest);
			assertEquals(testDataUserId, udId_fromTest);
			// Make sure all information inserted in correct and consistent
			UserDetails actualUd = userDetailsDAO.getUserDetailsById(udId_fromTest);
			assertEquals(testUserDetails.getEmailId(), actualUd.getEmailId());

		} catch (Exception e) {
			System.out.println("Unable to insert User Details into DB"+e.getMessage());
		}

	}

	@Test
	public void testGetUserDetailsById() {
		assumeTrue(connectedDB);
		try {
			// Make sure Null is not returned when given a valid ID
			UserDetails actualUserDetails = userDetailsDAO.getUserDetailsById(userDetailsBean2.getUserId());
			assertNotNull(actualUserDetails);
			// Make sure Null is returned when an invalid ID is provided
			//assertNull(userDetailsDAO.getUserDetailsById(1000));
			// Make sure returned data match with test data bean
			assertEquals(actualUserDetails.getEmailId(), userDetailsBean2.getEmailId());

		} catch (Exception e) {
			System.out.println("Unable to Get User Details from DB");
		}

	}
	
	@Test
	public void testGetUserDetailsByName() {
		assumeTrue(connectedDB);
		try {
			// Make sure Null is not returned when given a valid user name
			UserDetails actualUserDetails = userDetailsDAO.getUserDetailsByUserName("testUserDetails2");
			assertNotNull(actualUserDetails);
			// Make sure Null is returned when an invalid user name is provided
			//assertNull(userDetailsDAO.getUserDetailsByUserName("testttt100001"));
			// Make sure returned data match with test data bean
			assertEquals(actualUserDetails.getEmailId(), userDetailsBean2.getEmailId());

		} catch (Exception e) {
			System.out.println("Unable to Get User Details from DB");
		}

	}

	@Test
	public void testUpdateUserDetails() {
		assumeTrue(connectedDB);
	
		try {
			UserDetails userdetails = new UserDetails(testDataUserId, "FirstName3", "LastName3", "junit3@test.com",
					"4027445190");
			// Make sure the user was actually updated
			assertTrue(userDetailsDAO.updateUserDetails(userdetails));
			UserDetails actualUser = userDetailsDAO.getUserDetailsById(testDataUserId);
			assertEquals(userdetails.getEmailId(), actualUser.getEmailId());

		} catch (Exception e) {
			System.out.println("Unable to Update User Details into DB");
		}

	}

	@Test
	public void testZRemoveUserDetails() {
		assumeTrue(connectedDB);
		try {
			assertTrue(userDetailsDAO.removeUserDetailsbyUserId(testDataUserId));
			assertFalse(userDetailsDAO.removeUserDetailsbyUserId(1000));
		

		} catch (Exception e) {
			System.out.println("Unable to remove User Details from DB");
		}

	}

	@AfterClass
	public static void cleanUpTestObject() throws ClassNotFoundException, SQLException, IOException {
		try {
			userDAO.removeUserbyId(testDataUserId);
			userDetailsDAO.removeUserDetailsbyUserName("testUserDetails2");
			userDAO.removeUserbyUserName("testUserDetails2");
			System.out.println("=====Removed Test data sucessfully========");
			System.out.println("=====Test Executed sucessfully========");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
