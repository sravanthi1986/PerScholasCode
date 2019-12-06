package org.raisingkids.test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.raisingkids.dao.ArticleDAO;
import org.raisingkids.model.Article;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArticleDAOTest {

	public static Boolean connectedDB;
	public static Integer testDataId;
	public static ArticleDAO dao;

	@BeforeClass
	public static void setUpTestObject() throws ClassNotFoundException, SQLException, IOException {
		dao = new ArticleDAO();
		// If the object returned by testConnection() is not null then connection
		// successful
		if (Objects.nonNull(dao.testConnection())) {

			connectedDB = true;

			// Test data inserted into the database used to test DAO methods
			try {
				Article article = new Article("articleTitleTestDataJunit", "articleAuthor", "articleContent",1,"");	
				testDataId = dao.createArticle(article);
				System.out.println("Test Data Primary Key ===>" + testDataId);

			} catch (Exception e) {

				System.out.println("Unable to insert test data into DB");

			}

		} else {

			connectedDB = false;

		}
	}

	@Test
	public void createArticleTest() throws ClassNotFoundException, IOException, SQLException {
		try {
			Article article = new Article("articleTitlefromJunit", "articleAuthor", "articleContent",1,"");	
			int id = dao.createArticle(article);
			assertThat(id, not(-1));
			Article result = dao.getarticleById(id);
			assertEquals(result.getArticleTitle(), article.getArticleTitle());
			assertEquals(result.getArticleAuthor(), article.getArticleAuthor());
			assertEquals(result.getArticleContent(), article.getArticleContent());
		} catch (Exception e) {
			System.out.println("Unable to insert Article  into DB");
		}
	}

	@Test
	public void UpdateArticle() throws ClassNotFoundException, IOException, SQLException {
		try {
		Article a = new Article();
		a.setArticleId(testDataId);
		a.setArticleTitle("Updated Article Tile");
		a.setArticleAuthor("Updated Author");
		a.setArticleContent("Updated Content");
		boolean isUpdated = dao.updateArticle(a);
		assertTrue(isUpdated);
	} catch (Exception e) {
		System.out.println("Unable to Update Article into DB");
	}
	}

}
