package Project05;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;





	public class User5DAO {
		
		public User5 getUserByfirstName(String name) throws ClassNotFoundException, IOException, SQLException {
			// Declare variables
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			User5 u = null;
			
			// Assign query string to variable
			String qString = "select * from userno5 where firstName = ?";
			
			// Create MySqlConnection class instance
			DatabaseConnection databaseConnection = new DatabaseConnection();
			// Begin try/catch block to query the database
			try
			{
				// Connect to database and assign query string to PreparedStatement object
				conn = databaseConnection.getConnection();
				//System.out.println("Find member by name connection made.");
				stmt = conn.prepareStatement(qString);
				
				// Set query parameters (?)
				stmt.setString(1, name);
				// Run query and assign to ResultSet
				rs = stmt.executeQuery();
				// Retrieve ResultSet and assign to new User
				if (rs.next()) {
					u = new User5();
					u.setUserId(rs.getInt(1));
					u.setFirstName(rs.getString(2));
					u.setLastName(rs.getString(3));
					u.setUserEmail(rs.getString(4));
					u.setUserPassword(rs.getString(5));
					u.setUserDOB(rs.getDate(6));
					
					
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
		}  // End of getMemberByName() method
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
			
			User5DAO u_dao = new User5DAO();
			User5 u = new User5("firstName", "lastName", "userEmail","userPassword",new Date());
			u_dao.createUser(u);
			User5 u5 = u_dao.getUserByfirstName("firstName");
			
		    System.out.println(u5);
	}
	//createUser method starts
	public Integer createUser(User5 userno5) throws SQLException, ClassNotFoundException, IOException {
        // Declare variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        // Assign insert statement string to variable
        String insertString = "insert into userno5 (firstName, lastName, userEmail, userPassword, userDOB) values (?,?,?,?,?)";
        
        int ID = -1;
        String[] COL = {"userId"};
        
       DatabaseConnection databaseConnection = new DatabaseConnection();
        
        try
        {
            conn = databaseConnection.getConnection();
            stmt = conn.prepareStatement(insertString, COL);
            
            stmt.setString(1, userno5.getFirstName());
            stmt.setString(2, userno5.getLastName());
            stmt.setString(3, userno5.getUserEmail());
            stmt.setString(4, userno5.getUserPassword());
           // stmt.setString(4, user.getUserDOB());
            stmt.setTimestamp(5, Timestamp.from(userno5.getUserDOB().toInstant()));
            
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
    }
	

}
