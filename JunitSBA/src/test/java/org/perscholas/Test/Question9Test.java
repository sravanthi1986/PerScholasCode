package org.perscholas.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.perscholas.Question9.User;
import org.perscholas.Question9.UserDAO;
import org.perscholas.exam.InvalidPasswordException;




public class Question9Test {
	
	@RunWith(Parameterized.class)
	public class DAOparameterCreateTest {
		// Declare atttibutes
		private UserDAO u_dao;
		private String name;
		private Double javascore;

		/*
		 * Create the constructor. The order of arguments in the parentheses determines
		 * the parameter position in the two-dimensional Object arrays. Parameter1 =
		 * argument num1, Parameter2 = argument num2, Parameter3 = argument testSum,
		 * Parameter4 = argument confirmation
		 */
		public DAOparameterCreateTest(String name, String password) {
			this.name = name;
			this.javascore = javascore;

		}

		/*
		 * Set up the parameters. The confirmation parameter is null and will be
		 * assigned in the actual test method depending on accuracy of the addition
		 * result.
		 */
		@Parameters()
		public  Collection<Object[]> data() {
			return Arrays.asList(
					new Object[][] { { "bujji", 99.00 }, { "ram", 79.00 }, { "chinnu", 89.00 }, { "dogg", 39.00 } });
		}

		// Create the static class variable additionClass to run the test methods
		@BeforeClass
		public  void setUp() {
			u_dao = new UserDAO();
		}

		// Run the test
		@Test
		public void ProductDAOTest() throws ClassNotFoundException, SQLException, IOException, InvalidPasswordException {

			User u = new User();

			u.setName(name);
			u.setJavaScore(javascore);
			assertNotNull(u_dao.getAllUser());
			System.out.printf("Product: %s,Price:%.2f", u.getName(), u.getPassword());

		}// createProduct TEST
		
	   }
	
	//for update test
	
	private static UserDAO u_dao;
	private static User user = null;
	@BeforeClass
	public static void setUp() throws InvalidPasswordException {
		u_dao = new UserDAO();
		user = new User();
		user.setName("prasanna");
		user.setPassword("prsanamutrhy");
		user.setJavaScore(90.00);
		user.setSqlScore(80.00);
	}

	@Test
	public void removeUser() throws ClassNotFoundException, SQLException, IOException {
		
		assertTrue(u_dao.updateUser(user));
	}

}
	
