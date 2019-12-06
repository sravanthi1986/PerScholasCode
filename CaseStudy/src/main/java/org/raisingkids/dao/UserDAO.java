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
import org.raisingkids.model.User;

/**
 * @author Student
 *
 */
public class UserDAO {
	
	private MariadbConnection dbc;
	private Connection conn = null;
	
	public Connection testConnection() throws SQLException, ClassNotFoundException, IOException {
		try {
			dbc=new MariadbConnection();
			conn = dbc.getConnection();
			//System.out.println("Connected to database.");
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println(e.getMessage());
			return null;
			
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
	public List<User> getAllUsers() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		User ud = null;
		List<User> usersList = null;

		// Assign query string to a variable
		String qString = "select * from user";

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
			// Create list to hold User objects
			usersList = new ArrayList<User>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new user
				ud = new User();
				// Assign columns/fields to related fields in the User object
				// 1,2 and 3 represent column numbers/positions
				ud.setUserName(rs.getString(1));
				ud.setUserPassword(rs.getString(2));
				ud.setUserRole(rs.getString(3));

				// Add the user to the list
				usersList.add(ud);
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
		return usersList;
	} // End of getAllUsers method

	
	/**
	 * @param user
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Integer createUser(User user) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// Assign insert statement string to variable
		String insertString = "insert into user (userName, userPassword,userRole) values (?,?,?)";
		int id = -1;
		String[] COL = {"userid"};
		MariadbConnection mysql = new MariadbConnection();
		try {
			conn = mysql.getConnection();
			stmt = conn.prepareStatement(insertString, COL);
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getUserPassword());
			stmt.setString(3, user.getUserRole());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				id = rs.getInt(1);
			}
			//System.out.println(id);
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

		return id;
	}

	/**
	 * @param userId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public User getuserById(int userId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User ud = null;

		// Assign query string to variable
		String qString = "select * from user where userid = ?";

		// Create MySqlConnection class instance
		MariadbConnection mysql = new MariadbConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = mysql.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setInt(1, userId); // user_id if from String parameter passed to method

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();

			// Retrieve ResultSet and assign to new User
			if (rs.next()) {
				ud = new User();
				ud.setUserId(rs.getInt(1));
				ud.setUserName(rs.getString(2));
				ud.setUserPassword(rs.getString(3));
				ud.setUserRole(rs.getString(4));

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
		return ud;
	} // End of getUserById() method

	
	public User getuserByUserName(String userName) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User user = null;

		// Assign query string to variable
		String qString = "select * from user where userName = ?";

		// Create MySqlConnection class instance
		MariadbConnection mysql = new MariadbConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = mysql.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setString(1, userName); // user_id if from String parameter passed to method

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();

			// Retrieve ResultSet and assign to new User
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserRole(rs.getString(4));

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
		return user;
	} // End of getUserByUserName() method
	
	/**
	 * @param userName
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public Boolean removeUserbyUserName(String userName) throws ClassNotFoundException, IOException, SQLException {
		User user = this.getuserByUserName(userName);
		return user != null ? this.removeUserbyId(user.getUserId()) : false;
	}
	
	// ****************remove*****************
   
	public Boolean removeUserbyId(int userId) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		// Assign delete string to variable
		String deleteString = "delete from user where userid = ?";
		// Create MySqlMariadbConnection class instance
		MariadbConnection mysql = new MariadbConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = mysql.getConnection();
			stmt = conn.prepareStatement(deleteString);
			// Set query parameters (?)
			stmt.setInt(1, userId);
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
	} 



	/**
	 * @param user
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Boolean updateUser(User user) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
        Integer userId = user.getUserId() == null ? this.getuserByUserName(user.getUserName()).getUserId(): user.getUserId();
		// Assign update string to variable
		String updateString = "update user " + "set userName = ?,userPassword = ?,userRole = ? where userid = ?";

		// Create MySqlConnection class instance
		MariadbConnection mysql = new MariadbConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = mysql.getConnection();
			stmt = conn.prepareStatement(updateString);

			// Set query parameters (?)

			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getUserPassword());
			stmt.setString(3, user.getUserRole());
			stmt.setInt(4, userId);

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
	} // End of updateUser() method

}
