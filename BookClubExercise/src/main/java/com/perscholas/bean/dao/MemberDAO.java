package com.perscholas.bean.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.bean.Member;
import com.perscholas.bean.dao.DatabaseConnection;

public class MemberDAO {
	
	

//
//	// ****************getAllUsers() method*****************
//
//	public List<User> getAllUsers() throws SQLException {
//		// Declare variables
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		User u = null;
//		List<User> userList = null;
//
//		// Assign query string to a variable
//		String qString = "select * from users";
//
//		// Create MySqlConnection class instance
//		MySqlConnection mysql = new MySqlConnection();
//
//		// Begin try/catch block to query the database
//		try {
//			// Connect to database
//			conn = mysql.getConnection();
//			// If the connection fails the application won't make it to this point
//			System.out.println("Connected to database.");
//			// Create Statement instance/object
//			stmt = conn.createStatement();
//
//			// Run query and assign to the ResultSet instance
//			rs = stmt.executeQuery(qString);
//			// Create list to hold User objects
//			userList = new ArrayList<User>();
//			// Read the ResultSet instance
//			while (rs.next()) {
//				// Each iteration creates a new user
//				u = new User();
//				// Assign columns/fields to related fields in the User object
//				// 1,2 and 3 represent column numbers/positions
//				u.setUserId(rs.getInt(1));
//				u.setName(rs.getString(2));
//				u.setEmail(rs.getString(3));
//				// Add the user to the list
//				userList.add(u);
//				// Repeat until rs.next() returns false (i.e., end of ResultSet)
//			}
//		} catch (ClassNotFoundException | IOException | SQLException e) {
//			System.out.println("Error: " + e.getMessage());
//			e.getStackTrace();
//		} finally {
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
//		return userList;
//	} // End of getAllUsers method
//
//	// ****************registerUser() method*****************
//
	public Integer registerMember(Member members) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "insert into member (name,email,password,favoriteGenre) values (?,?,?,?)";

		int ID = -1;
		String[] COL = { "member_id" };

		DatabaseConnection mysql = new DatabaseConnection();

		try {
			conn = mysql.getConnection();
			stmt = conn.prepareStatement(insertString, COL);

			stmt.setString(1, members.getName());
			stmt.setString(2, members.getEmail());
			stmt.setString(3, members.getPassword());
			stmt.setString(4, members.getFavoriteGenre());
			

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
	} 
	


	// End of registerUser() method
//
//	// ****************getUserById() method*****************
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
//		try {
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
//		} catch (ClassNotFoundException | IOException | SQLException e) {
//			System.out.println("Error: " + e.getMessage());
//			e.getStackTrace();
//		} finally {
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
//	// ****************getUserByName or login method*****************
//
	public Member memberByName(String name) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Member m = null;

		// Assign query string to variable
		String qString = "select * from Member where name = ?";

		// Create MySqlConnection class instance
		DatabaseConnection mysql = new DatabaseConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = mysql.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setString(1, name); // member_id if from String parameter passed to method
			// Run query and assign to ResultSet
			rs = stmt.executeQuery();
			// Retrieve ResultSet and assign to new User
			if (rs.next()) {
				m = new Member();
				m.setMemberId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setEmail(rs.getString(3));
				m.setPassword(rs.getString(4));
				m.setFavoriteGenre(rs.getString(5));
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println(e.getStackTrace());
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
		return m;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		//Member m=new Member();
		MemberDAO m_dao=new MemberDAO();
//		m.setName("sravs");
//		m.setEmail("sravs@gmail.com");
//		m.setPassword("pas2");
//		m.setFavoriteLanguage("java");
//		Integer i=m_dao.registerMember(m);
		Member m = m_dao.memberByName("sravs");
		System.out.println(m.getMemberId());
		//System.out.println(i);
	}
	
}// End of getUserByName() method
//
//	// ****************updateUser() method*****************
//
//	public Boolean updateUser(User u) throws SQLException, ClassNotFoundException, IOException {
//		// Declare variables
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		Integer updateResult = null;
//
//		// Assign update string to variable
//		String updateString = "update users " + "set name = ?, password = ? " + "where user_id = ?";
//
//		// Create MySqlConnection class instance
//		MySqlConnection mysql = new MySqlConnection();
//		// Begin try/catch block to query the database
//		try {
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
//		} catch (ClassNotFoundException | SQLException e) {
//			System.out.println("Error: " + e.getMessage());
//		} finally {
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
//	// ****************removeUser() method (i.e., delete)*****************
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
//		try {
//			// Connect to database and assign query string to PreparedStatement object
//			conn = mysql.getConnection();
//			stmt = conn.prepareStatement(deleteString);
//
//			// Set query parameters (?)
//			stmt.setInt(1, userId);
//			// Run query and assign to ResultSet
//			updateResult = stmt.executeUpdate();
//		} catch (ClassNotFoundException | SQLException e) {
//			System.out.println("Error: " + e.getMessage());
//		} finally {
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
//}
