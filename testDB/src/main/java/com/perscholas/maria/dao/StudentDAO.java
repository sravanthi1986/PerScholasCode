package com.perscholas.maria.dao;

import java.sql.Statement;

import com.perscholas.maria.models.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
	public Integer registerStudent(Student student) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// Assign insert statement string to variable
		String insertString = "insert into students (name, email,hometown,courseselected) values (?,?,?,?)";
		
	    int ID = -1;
	    String[] COL = {"student_id"};
	    
	    MariadbConnection maria = new MariadbConnection();
	    
	    try
	    {
	        conn = maria.getConnection();
	        stmt = conn.prepareStatement(insertString, COL);
	        
	        stmt.setString(1, student.getName());
	        stmt.setString(2, student.getEmail());
	        stmt.setString(3, student.getHometown());
	        stmt.setString(4, student.getCourseselected());

	        
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
	} // End of registerUser() method
	
	
	 public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		 StudentDAO s_dao=new StudentDAO();
		 Student s=new Student();
		 s.setName("james");
		 s.setEmail("sravs@gmail.com");
		 s.setHometown("texas");
		 s.setCourseselected("AD");
		 
		 
		 Integer i =s_dao.registerStudent(s);
		 System.out.println(i);
		 
		
		 
	        /*
	         * StudentDAO s_dao=new StudentDAO(); s_dao.testConn();
	         */
//	        MariadbConnection MariadbConnection = new MariadbConnection();
//	        try {
//	            // Test connection to mariaDB
//	            Connection cn = MariadbConnection.getConnection();
//	            System.out.println("connected to mariadb:)");
//	            // create the java statement
//	            Statement smt = (Statement) cn.createStatement();
//	            String q = "Select * from students";
//	            // to execute query
//	            ResultSet rs = ((java.sql.Statement) smt).executeQuery(q);
//	            // to print the resultset on console
//	            if (rs.next()) {
//	                do {
//	                    System.out.println(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + ","
//	                            + rs.getString(4) + "," + rs.getString(5));
//	                } while (rs.next());
//	            } else {
//	                System.out.println("Record Not Found...");
//	            }
//	            cn.close();
//	        } catch (Exception e) {
//	            System.out.println(e);
//	        }
	    }
	 
	}


