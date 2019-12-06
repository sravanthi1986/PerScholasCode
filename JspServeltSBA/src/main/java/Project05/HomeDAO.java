package Project05;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeDAO {
	public Home getHomeByhomeId(int homeId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Home h = null;
		
		// Assign query string to variable
		String qString = "select * from home where homeId = ?";
		
		// Create MySqlConnection class instance
		DatabaseConnection databaseConnection = new DatabaseConnection();
		// Begin try/catch block to query the database
		try
		{
			// Connect to database and assign query string to PreparedStatement object
			conn = databaseConnection.getConnection();
			System.out.println("Find home by name connection made.");
			stmt = conn.prepareStatement(qString);
			
			// Set query parameters (?)
			stmt.setInt(1, homeId);
			// Run query and assign to ResultSet
			rs = stmt.executeQuery();
			// Retrieve ResultSet and assign to new User
			if (rs.next()) {
				h = new Home();
			     h.setUserId(rs.getInt(1));
			     h.setAddress1(rs.getString(2));
			     h.setAddress2(rs.getString(3));
			     h.setCity(rs.getString(4));
			     h.setState(rs.getString(5));
			     h.setYearBuilt(rs.getInt(6));
			     h.setHomeValue(rs.getDouble(7));
			    
				
				
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
		return h;
	}  // End of getMemberByName() method
public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		HomeDAO u_dao = new HomeDAO();
		Home u = new Home();
		Home ho = u_dao.getHomeByhomeId(1);
	    System.out.println(ho);
}



}
