package org.raisingkids.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.raisingkids.db.MariadbConnection;
import org.raisingkids.model.User;
import org.raisingkids.model.UserDetails;

public class UserDetailsDAO {
	private MariadbConnection dbc;
	private Connection conn = null;

	/**
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Connection testConnection() throws SQLException, ClassNotFoundException, IOException {
		try {
			dbc = new MariadbConnection();
			conn = dbc.getConnection();
			System.out.println("Connected to database.");
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
	 * @param userdetails
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Integer createUserDetails(UserDetails userdetails) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "insert into userdetails (userid,firstName, lastName,emailId,contactNo) values (?,?,?,?,?)";
		MariadbConnection mysql = new MariadbConnection();
		int id = -1;
		try {
			conn = mysql.getConnection();
			stmt = conn.prepareStatement(insertString);
			stmt.setInt(1, userdetails.getUserId());
			stmt.setString(2, userdetails.getFirstName());
			stmt.setString(3, userdetails.getLastName());
			stmt.setString(4, userdetails.getEmailId());
			stmt.setString(5, userdetails.getContactNo());

			int result = stmt.executeUpdate();
			id = result == 1 ? userdetails.getUserId() : id;
			System.out.println("User Id in User Details Table =====> " + id);

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
	 * @param userName
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public UserDetails getUserDetailsByUserName(String userName) throws ClassNotFoundException, IOException, SQLException {
		UserDAO userDAO = new UserDAO();
		User user = userDAO.getuserByUserName(userName);
		Integer userId = user != null ? user.getUserId() : null;
		return userId == null ? null : this.getUserDetailsById(userId);
	}

	/**
	 * @param userId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public UserDetails getUserDetailsById(int userId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		UserDetails ud = null;

		// Assign query string to variable
		String qString = "select * from userdetails where userid = ?";

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
			ud = new UserDetails();
			// Retrieve ResultSet and assign to new User
			if (rs.next()) {
				ud.setUserId(rs.getInt(1));
				ud.setFirstName(rs.getString(2));
				ud.setLastName(rs.getString(3));
				ud.setEmailId(rs.getString(4));
				ud.setContactNo(rs.getString(5));
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
	}
	
	/**
	 * @param userName
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public Boolean removeUserDetailsbyUserName(String userName) throws ClassNotFoundException,IOException, SQLException {
		UserDetails ud = this.getUserDetailsByUserName(userName);
		return this.removeUserDetailsbyUserId(ud.getUserId());
	}

	/**
	 * @param userId
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public Boolean removeUserDetailsbyUserId(int userId) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		// Assign delete string to variable
		String deleteString = "delete from userdetails where userid = ?";
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
	 * @param userdetails
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Boolean updateUserDetails(UserDetails userdetails) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign update string to variable
		String updateString = "update userdetails "
				+ "set firstName = ?,lastName = ?,emailId = ?,contactNo = ? where userid = ?";

		// Create MySqlConnection class instance
		MariadbConnection mysql = new MariadbConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = mysql.getConnection();
			stmt = conn.prepareStatement(updateString);

			// Set query parameters (?)

			stmt.setString(1, userdetails.getFirstName());
			stmt.setString(2, userdetails.getLastName());
			stmt.setString(3, userdetails.getEmailId());
			stmt.setString(4, userdetails.getContactNo());
			stmt.setInt(5, userdetails.getUserId());

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

} // class End
