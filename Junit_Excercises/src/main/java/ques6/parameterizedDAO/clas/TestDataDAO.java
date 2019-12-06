package ques6.parameterizedDAO.clas;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDataDAO {
	public Integer createTestData(TestData data) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// Assign insert statement string to variable
		String insertString = "insert into testdata (testName) values (?)";
		
	    int ID = -1;
	    String[] COL = {"userid"};
	    
	    MariadbConnection mysql = new MariadbConnection();
	    
	    try
	    {
	        conn = mysql.getConnection();
	        stmt = conn.prepareStatement(insertString, COL);
	        
	        stmt.setString(1, data.getTestName());
	        //stmt.setString(2, user.getUserPassword());
	        //stmt.setString(3,user.getUserRole());
	        
	        
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
	
} // End of UserDAO class
