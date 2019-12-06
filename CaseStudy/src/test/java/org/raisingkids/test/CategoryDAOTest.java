package org.raisingkids.test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.raisingkids.dao.CategoryDAO;
import org.raisingkids.model.Category;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoryDAOTest {
	
	public static Boolean connectedDB;
	public static Integer testDataUserId;
	public static Integer userId_fromTest;
	public static Category testDataBean;
	public static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void setUpTestObject() throws ClassNotFoundException, SQLException, IOException {
		categoryDAO = new CategoryDAO();
		// If the object returned by testConnection() is not null then connection
		// successful
		if (Objects.nonNull(categoryDAO.testConnection())) {

			connectedDB = true;

			// Test data inserted into the database used to test DAO methods
			try {
				// create test Category
				Category category1 = new Category("Kids");
				Category category2 = new Category("Stories");
				categoryDAO.createCategory(category1);
				categoryDAO.createCategory(category2);
				

			} catch (Exception e) {
				System.out.println("Unable to insert test data into DB");
			}

		} else {
			connectedDB = false;
		}
	}
	
	@Test
	public void testCreateCategory() throws ClassNotFoundException, IOException, SQLException {
		try {
			Category testCategory = new Category("DataFromJunit");
			Integer cId = categoryDAO.createCategory(testCategory);
			assertThat(cId, not(-1));
		} catch (Exception e) {
			System.out.println("Unable to insert User into DB");
		}
	}
	
	@Test
	public void testremoveCategory() throws ClassNotFoundException, IOException, SQLException {
		try {
			
			Boolean status = categoryDAO.removeCategorybyName("DataFromJunit");
			assertTrue(status);
			Boolean status2 = categoryDAO.removeCategorybyName("testcdfr1234");
			assertFalse(status2);
		} catch (Exception e) {
			System.out.println("Unable to insert User into DB");
		}
	}
	
	@AfterClass
	public static void cleanUpTestObject() throws ClassNotFoundException, SQLException, IOException {
		try {
			categoryDAO.removeCategorybyName("Kids");
			categoryDAO.removeCategorybyName("Stories");
			System.out.println("=====Removed Test data sucessfully========");
			System.out.println("=====Test Executed sucessfully========");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
