package org.perscholas6;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class curd {
	
	public Integer Student(int student) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// Assign insert statement string to variable
		String insertString = "insert into students (Student_id,name,QE,AD) values (?,?,?,?)";
		
	    int ID = -1;
	    String[] COL = {"student_id"};
	    
	    MariadbConnection maria = new MariadbConnection();
	    
	    try
	    {
	        conn = maria.getConnection();
	        stmt = conn.prepareStatement(insertString, COL);
	        
	        stmt.setString(1, Course.getstudent_id());
	        stmt.setString(2, Course.getName());
	        stmt.setString(3, Course.getQE());
	        stmt.setString(4, Course.getAD());

	        
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

}}
