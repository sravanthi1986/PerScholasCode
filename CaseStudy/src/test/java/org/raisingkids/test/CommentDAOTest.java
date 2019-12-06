package org.raisingkids.test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.raisingkids.dao.CommentsDAO;
import org.raisingkids.model.Comments;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommentDAOTest {
	public static CommentsDAO commentsDAO;
	public static Boolean connectedDB;
	public static Integer testDataId;
	public static Integer id_fromTest;
	public static Comments testDataBean;
	// Fill the database with the test data used for the test cases
	// Test data used for these test cases can be found here!
	@BeforeClass
	public static void setUpTestObject() throws ClassNotFoundException, SQLException, IOException {
		commentsDAO = new CommentsDAO();
		// If the object returned by testConnection() is not null then connection successful
		if (Objects.nonNull(commentsDAO.testConnection())) {

			connectedDB = true;

			// Test data inserted into the database used to test DAO methods
			try {
				
				testDataBean = new Comments("testComment", 1, 1);
				testDataId = commentsDAO.createCommentDetails(testDataBean);
				//System.out.println("Test Data Primary Key ===>"+testDataId);

			} catch (Exception e) {

				System.out.println("Unable to insert test data into DB");

			}

		} else {

			connectedDB = false;

		}
	}

	@Test
	public void testCreateComment() {
		assumeTrue(connectedDB);
		Comments testcomment = new Comments("commentFromJunit",1,1);
		try {
			// Insert the object into the database
			id_fromTest = commentsDAO.createCommentDetails(testcomment);
			assertThat(id_fromTest, not(-1));

		} catch (Exception e) {
			System.out.println("Unable to insert Comment into DB");
		}

	}

	
	@Test
	public void testRemoveComment() {
		assumeTrue(connectedDB);
		try {
			assertTrue(commentsDAO.removeComments(testDataId));
			assertFalse(commentsDAO.removeComments(1000));


		} catch (Exception e) {
			System.out.println("Unable to remove Comment from DB");
		}

	}

	

}
