package Project05;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuoteDAO {
	public Quote getQuoteByquoteId(int homeId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Quote q = null;
		
		// Assign query string to variable
		String qString = "select * from quote where quoteId = ?";
		
		// Create MySqlConnection class instance
		DatabaseConnection databaseConnection = new DatabaseConnection();
		// Begin try/catch block to query the database
		try
		{
			// Connect to database and assign query string to PreparedStatement object
			conn = databaseConnection.getConnection();
			System.out.println("Find Quote by name connection made.");
			stmt = conn.prepareStatement(qString);
			
			// Set query parameters (?)
			stmt.setInt(1, homeId);
			// Run query and assign to ResultSet
			rs = stmt.executeQuery();
			// Retrieve ResultSet and assign to new User
			if (rs.next()) {
				q = new Quote();
				q.setHomeId(rs.getInt(1));
				q.setYearlyPremium(rs.getDouble(2));
				q.setStartDate(rs.getDate(3));
				q.setExpiration(rs.getDate(4));
				q.setActive(rs.getBoolean(5));
			     
			    
				
				
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
		return q;
	}  // End of getMemberByName() method
public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		QuoteDAO q_dao = new QuoteDAO();
		Quote q = new Quote();
		Quote qo = q_dao.getQuoteByquoteId(1);
	    System.out.println(qo);
}

}
