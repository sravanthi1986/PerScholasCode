package Project04;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Project03.DatabaseConnection;
import Project03.UserClass;

public class UpadateDAO {
	public UserClass getUserByName(String name) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		UserClass u = null;
		
		// Assign query string to variable
		String qString = "select * from users where userName = ?";
		
		// Create MySqlConnection class instance
		DatabaseConnection databaseConnection = new DatabaseConnection();
		// Begin try/catch block to query the database
		try
		{
			// Connect to database and assign query string to PreparedStatement object
			conn = databaseConnection.getConnection();
			System.out.println("Find member by name connection made.");
			stmt = conn.prepareStatement(qString);
			
			// Set query parameters (?)
			stmt.setString(1, name);
			// Run query and assign to ResultSet
			rs = stmt.executeQuery();
			// Retrieve ResultSet and assign to new User
			if (rs.next()) {
				u = new UserClass();
				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setPassword(rs.getString(3));
				
			}
		}
		catch (ClassNotFoundException | IOException | SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
			System.out.println(e.getStackTrace());
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
		return u;
	}
	public Boolean updateUser(User u) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		
		// Assign update string to variable
		String updateString = "update users "
				+ "set userName = ?, password = ? ";
				
		
		// Create MySqlConnection class instance
		DatabaseConnection mysql = new DatabaseConnection();
		// Begin try/catch block to query the database
		try
		{
			// Connect to database and assign query string to PreparedStatement object
			conn = mysql.getConnection();
			stmt = conn.prepareStatement(updateString);
			
			// Set query parameters (?)
			stmt.setString(1, u.getUserName());
			stmt.setString(2, u.getPassword());
			
			// Run query and assign to ResultSet
			updateResult = stmt.executeUpdate();
		}
		catch (ClassNotFoundException | SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		finally
		{
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
	


