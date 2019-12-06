package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class LoginDAO {
	

	//****************createEvent() method*****************
	
	public String createLogin(Login event) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// Assign insert statement string to variable
		String insertString = "insert into login (name, password) values (?,?)";
		
	    
	    DatabaseConnection databaseConnection = new DatabaseConnection();
	    
	    try
	    {
	        conn = databaseConnection.getConnection();
	        stmt = conn.prepareStatement(insertString);
	        
	        stmt.setString(1, event.getName());
	        stmt.setString(2, event.getPassword());

	        
	        stmt.executeUpdate();

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
	    
		return "";
	} // End of createEvent() method
	

	
} // End of EventDAO class