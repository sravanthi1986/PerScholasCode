package org.perscholas6;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.perscholas3.Course;

import com.perscholas.maria.dao.MariadbConnection;
import com.perscholas.maria.dao.StudentDAO;
import com.perscholas.maria.models.Student;

public class CourseDAO {
{public Integer registerStudent(Course Course) throws SQLException, ClassNotFoundException, IOException {
	// Declare variables
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	// Assign insert statement string to variable
	String insertString = "insert into Course (name, cousre_id,courseselected) values (?,?,?)";
	
    int ID = -1;
    String[] COL = {"student_id"};
    
    MariadbConnection maria = new MariadbConnection();
    
    try
    {
        conn = maria.getConnection();
        stmt = conn.prepareStatement(insertString, COL);
        
        stmt.setString(1, Course.getName());
        stmt.setString(2, Course.getCourseid());
        stmt.setString(4, Course.getCourseselected());

        
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
	 CourseDAO s_dao=new CourseDAO();
	 Course s=new Course();
	 s.setName("james");
	 s.setCourseID(5);
	 s.setCourseselected("AD");
	 
	 
	 Integer i =s_dao.registerStudent(s);
	 System.out.println(i);
}
}