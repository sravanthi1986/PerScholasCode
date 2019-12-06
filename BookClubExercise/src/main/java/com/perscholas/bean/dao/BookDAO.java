package com.perscholas.bean.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.bean.Book;

public class BookDAO {
	
	//****************getAllEvents() method*****************

	public List<Book> getAllBooks() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Book book = null;
		List<Book> bookList = null;

		// Assign query string to a variable
		String qString = "select * from book";

		// Create MySqlConnection class instance
		DatabaseConnection databaseConnection = new DatabaseConnection();

		// Begin try/catch block to query the database
		try
		{
			// Connect to database
			conn = databaseConnection.getConnection();
			// If the connection fails the application won't make it to this point
			System.out.println("Connected to database.");
			// Create Statement instance/object
			stmt = conn.createStatement();

			// Run query and assign to the ResultSet instance			rs = stmt.executeQuery(qString);
			//Create list to hold User objects
			 bookList = new ArrayList<Book>();
			// Read the ResultSet instance
			while (rs.next()) {
				book = new Book();
			
				book.setBookId(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setSynopsis(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setPublicationDate(rs.getTimestamp(5).toLocalDateTime());
				book.setMemberId(rs.getInt(6));

				// Add the user to the list
				bookList.add(book);
				// Repeat until rs.next() returns false (i.e., end of ResultSet)
			}
		}
		catch (ClassNotFoundException | IOException | SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		}
		finally
		{
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
		return bookList;
	} // End of getAllBooks method	
	
	//****************createBook() method*****************
	
	public Integer createBook(Book book) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// Assign insert statement string to variable
		String insertString = "insert into book (title, sysnopsis, author, publicationDate, book_member_id) values (?,?,?,?,?)";
		
	    int ID = -1;
	    String[] COL = {"event_id"};
	    
	    DatabaseConnection databaseConnection = new DatabaseConnection();
	    
	    try
	    {
	        conn = databaseConnection.getConnection();
	        stmt = conn.prepareStatement(insertString, COL);
	        
	        stmt.setString(1, book.getTitle());
	        stmt.setString(2, book.getSynopsis());
	        stmt.setString(3, book.getAuthor());
	        stmt.setTimestamp(4, Timestamp.from(book.getPublicationDate().toInstant(ZoneOffset.ofHours(-4))));
	        stmt.setInt(5, book.getMemberId());
	        
	        stmt.executeUpdate();
	        
	        rs = stmt.getGeneratedKeys();
	        if(rs != null && rs.next()) {
	            ID = rs.getInt(1);
	        }
	        System.out.println(ID);
	    }
	    catch (SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		finally
		{
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
	} // End of createEvent() method
	
//	//****************getUserById() method*****************
//
//	public User getUserById(int userId) throws ClassNotFoundException, IOException, SQLException {
//		// Declare variables
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		User u = null;
//		
//		// Assign query string to variable
//		String qString = "select * from users where user_id = ?";
//		
//		// Create MySqlConnection class instance
//		MySqlConnection mysql = new MySqlConnection();
//		
//		// Begin try/catch block to query the database
//		try
//		{
//			// Connect to database and assign query string to PreparedStatement object
//			conn = mysql.getConnection();
//			stmt = conn.prepareStatement(qString);
//			
//			// Set query parameters (?)
//			stmt.setInt(1, userId); // user_id if from String parameter passed to method
//			
//			// Run query and assign to ResultSet
//			rs = stmt.executeQuery();
//			
//			// Retrieve ResultSet and assign to new User
//			if (rs.next()) {
//				u = new User();
//				u.setUserId(rs.getInt(1));
//				u.setName(rs.getString(2));
//				u.setEmail(rs.getString(3));
//			}
//		}
//		catch (ClassNotFoundException | IOException | SQLException e)
//		{
//			System.out.println("Error: " + e.getMessage());
//			e.getStackTrace();
//		}
//		finally
//		{
//			if (rs != null) {
//				rs.close();
//			}
//			if (stmt != null) {
//				stmt.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		return u;
//	} // End of getUserById() method
//	
//	//****************getUserByName or login method*****************
//
//	public User getUserByName(String name) throws ClassNotFoundException, IOException, SQLException {
//		// Declare variables
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		User u = null;
//		
//		// Assign query string to variable
//		String qString = "select * from users where name = ?";
//		
//		// Create MySqlConnection class instance
//		MySqlConnection mysql = new MySqlConnection();
//		// Begin try/catch block to query the database
//		try
//		{
//			// Connect to database and assign query string to PreparedStatement object
//			conn = mysql.getConnection();
//			stmt = conn.prepareStatement(qString);
//			
//			// Set query parameters (?)
//			stmt.setString(1, name); // user_id if from String parameter passed to method
//			// Run query and assign to ResultSet
//			rs = stmt.executeQuery();
//			// Retrieve ResultSet and assign to new User
//			if (rs.next()) {
//				u = new User();
//				u.setUserId(rs.getInt(1));
//				u.setName(rs.getString(2));
//				u.setEmail(rs.getString(3));
//			}
//		}
//		catch (ClassNotFoundException | IOException | SQLException e)
//		{
//			System.out.println("Error: " + e.getMessage());
//			System.out.println(e.getStackTrace());
//		}
//		finally
//		{
//			if (rs != null) {
//				rs.close();
//			}
//			if (stmt != null) {
//				stmt.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		return u;
//	}  // End of getUserByName() method
//	
//	//****************updateUser() method*****************
//	
//	public Boolean updateUser(User u) throws SQLException, ClassNotFoundException, IOException {
//		// Declare variables
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		Integer updateResult = null;
//		
//		// Assign update string to variable
//		String updateString = "update users "
//				+ "set name = ?, password = ? "
//				+ "where user_id = ?";
//		
//		// Create MySqlConnection class instance
//		MySqlConnection mysql = new MySqlConnection();
//		// Begin try/catch block to query the database
//		try
//		{
//			// Connect to database and assign query string to PreparedStatement object
//			conn = mysql.getConnection();
//			stmt = conn.prepareStatement(updateString);
//			
//			// Set query parameters (?)
//			stmt.setString(1, u.getName());
//			stmt.setString(2, u.getEmail());
//			stmt.setInt(3, u.getUserId());
//			// Run query and assign to ResultSet
//			updateResult = stmt.executeUpdate();
//		}
//		catch (ClassNotFoundException | SQLException e)
//		{
//			System.out.println("Error: " + e.getMessage());
//		}
//		finally
//		{
//			if (stmt != null) {
//				stmt.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		if (updateResult > 0) {
//			return true;
//		}
//		return false;
//	} // End of updateUser() method
//	
//	//****************removeUser() method (i.e., delete)*****************
//	
//	public Boolean removeUser(int userId) throws IOException, SQLException {
//		// Declare variables
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		Integer updateResult = null;
//		
//		// Assign delete string to variable
//		String deleteString = "delete from users where user_id = ?";
//		
//		// Create MySqlConnection class instance
//		MySqlConnection mysql = new MySqlConnection();
//		// Begin try/catch block to query the database
//		try
//		{
//			// Connect to database and assign query string to PreparedStatement object
//			conn = mysql.getConnection();
//			stmt = conn.prepareStatement(deleteString);
//			
//			// Set query parameters (?)
//			stmt.setInt(1, userId);
//			// Run query and assign to ResultSet
//			updateResult = stmt.executeUpdate();
//		}
//		catch (ClassNotFoundException | SQLException e)
//		{
//			System.out.println("Error: " + e.getMessage());
//		}
//		finally
//		{
//			if (stmt != null) {
//				stmt.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		if (updateResult > 0) {
//			return true;
//		}
//		return false;
//	} // End of removeUser() method
//	
} // End of UserDAO class