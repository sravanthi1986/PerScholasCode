package org.raisingkids.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.raisingkids.db.MariadbConnection;
import org.raisingkids.model.Article;

public class ArticleDAO {
	private MariadbConnection dbc;
	private Connection conn = null;

	public Connection testConnection() throws SQLException, ClassNotFoundException, IOException {
		try {
			dbc = new MariadbConnection();
			conn = dbc.getConnection();
			System.out.println("Connected to database.");
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return conn;
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	public List<Article> getAllArticle() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Article a = null;
		List<Article> articleList = null;

		// Assign query string to a variable
		String qString = "select * from article";

		// Create MySqlConnection class instance
		MariadbConnection dbc = new MariadbConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database
			conn = dbc.getConnection();
			// If the connection fails the application won't make it to this point
			System.out.println("Connected to database.");
			// Create Statement instance/object
			stmt = conn.createStatement();
			// Run query and assign to the ResultSet instance
			rs = stmt.executeQuery(qString);
			// Create list to hold Article objects
			articleList = new ArrayList<Article>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new Article
				a = new Article();
				// Assign columns/fields to related fields in the Article object
				// 1,2 and 3 represent column numbers/positions
				a.setArticleId(rs.getInt(1));
				a.setArticleTitle(rs.getString(2));
				a.setArticleAuthor(rs.getString(3));
				a.setArticleContent(rs.getString(4));

				// Add the user to the list
				articleList.add(a);
				// Repeat until rs.next() returns false (i.e., end of ResultSet)
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return articleList;
	} // End of getAllArticle method

	
	/**
	 * @param article
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Integer createArticle(Article article) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "insert into article (articleTitle,articleAuthor,articleContent,categoryId) values (?,?,?,?)";

		int ID = -1;
		String[] COL = { "articleId" };

		MariadbConnection mysql = new MariadbConnection();

		try {
			conn = mysql.getConnection();
			stmt = conn.prepareStatement(insertString, COL);

	
			stmt.setString(1, article.getArticleTitle());
			stmt.setString(2, article.getArticleAuthor());
			stmt.setString(3, article.getArticleContent());
			stmt.setInt(4, article.getCategoryId());
			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				ID = rs.getInt(1);
			}
			System.out.println(ID);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return ID;
	} // End of createArticle() method

	public Article getarticleById(int articleId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Article a = null;

		// Assign query string to variable
		String qString = "select * from article where articleId = ?";

		// Create MySqlConnection class instance
		MariadbConnection mysql = new MariadbConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = mysql.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setInt(1, articleId); // user_id if from String parameter passed to method

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();

			// Retrieve ResultSet and assign to new Article
			if (rs.next()) {
				a = new Article();
				a.setArticleId(rs.getInt(1));
				a.setArticleTitle(rs.getString(2));
				a.setArticleAuthor(rs.getString(3));
				a.setArticleContent(rs.getString(4));

			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return a;
	} // End of getArticleById() method

	public Article getarticleByPath(String articlePath) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Article a = null;

		// Assign query string to variable
		String qString = "select * from article where articleUrl = ?";

		// Create MySqlConnection class instance
		MariadbConnection mysql = new MariadbConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = mysql.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setString(1, articlePath); // user_id if from String parameter passed to method

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();

			// Retrieve ResultSet and assign to new Article
			if (rs.next()) {
				a = new Article();
				a.setArticleId(rs.getInt(1));
				a.setArticleTitle(rs.getString(2));
				a.setArticleAuthor(rs.getString(3));
				a.setArticleContent(rs.getString(4));
				a.setArticleUrl(rs.getString(5));

			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return a;
	} // End of getArticleByPath() method
	// ****************remove*****************

	public Boolean removeArticle(int articleId) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		// Assign delete string to variable
		String deleteString = "delete from user where articleId = ?";
		// Create MySqlMariadbConnection class instance
		MariadbConnection mysql = new MariadbConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = mysql.getConnection();
			stmt = conn.prepareStatement(deleteString);
			// Set query parameters (?)
			stmt.setInt(1, articleId);
			// Run query and assign to ResultSet
			updateResult = stmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		if (updateResult > 0) {
			return true;
		}
		return false;
	} // End of removeArticle
// End of UserDAO class
//****************updateArticle() method*****************

	public Boolean updateArticle(Article article) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign update string to variable
		String updateString = "update article "
				+ "set articleTitle = ?,articleAuthor = ?,articleContent = ? where articleId = ?";

		// Create MySqlConnection class instance
		MariadbConnection mysql = new MariadbConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = mysql.getConnection();
			stmt = conn.prepareStatement(updateString);

			// Set query parameters (?)

			stmt.setString(1, article.getArticleTitle());
			stmt.setString(2, article.getArticleAuthor());
			stmt.setString(3, article.getArticleContent());
			stmt.setInt(4, article.getArticleId());

			// Run query and assign to ResultSet
			updateResult = stmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		if (updateResult > 0) {
			return true;
		}
		return false;
	} // End of updateArticle() method

}
