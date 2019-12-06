package org.raisingkids.dao;


	import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.raisingkids.db.MariadbConnection;
import org.raisingkids.model.Article;
import org.raisingkids.model.Comments;




	public class CommentsDAO {
		
		private MariadbConnection dbc;
		private Connection conn = null;
		//public static void main(String [] args) throws Exception {
		//	Comments us=new Comments();
			//us.setFirstName("tanu");
			//us.setLastName("gorantla");
			//us.setEmailId("tanu@gmail.com");
			//us.setContactNo(243566778);
		
			//CommentsDAO u_dao=new CommentsDAO();
			//Integer pk = u_dao.createComments(us);
			//System.out.println(pk);

		//}
		
		//create product*************
	  public static void main(String[]args)throws ClassNotFoundException,SQLException,IOException{
     CommentsDAO c_dao=new CommentsDAO();
     List<Comments> comments = c_dao.getAllCommentsByArticleId(17);
     System.out.print(comments.size());
	}

	  


		public Connection testConnection() throws SQLException, ClassNotFoundException, IOException {
			try {
				dbc=new MariadbConnection();
				conn = dbc.getConnection();
				System.out.println("Connected to database.");
			} catch (SQLException | ClassNotFoundException | IOException e) {
				System.out.println(e.getMessage());
			} finally {
				if (conn != null) {
					conn.close();
				}
			}
			return conn;

		
	}
		
		
		
		
		// ****************getAllComments() method*****************

		public List<Comments> getAllCommentsByArticleId(int articleId) throws ClassNotFoundException, IOException, SQLException {
			// Declare variables
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Comments a = null;

			// Assign query string to variable
			String qString = "select * from comments where articleId = ?";

			// Create MySqlConnection class instance
			MariadbConnection mysql = new MariadbConnection();
			List<Comments> comments = new ArrayList<Comments>();
			// Begin try/catch block to query the database
			try {
				// Connect to database and assign query string to PreparedStatement object
				conn = mysql.getConnection();
				stmt = conn.prepareStatement(qString);

				// Set query parameters (?)
				stmt.setInt(1, articleId); // user_id if from String parameter passed to method

				// Run query and assign to ResultSet
				rs = stmt.executeQuery();

				// Retrieve ResultSet and assign to new Article
				while (rs.next()) {
					//System.out.println("=================");
					Comments comment = new Comments();
					comment.setComment(rs.getString(2));
					comments.add(comment);

				}
			} catch (ClassNotFoundException | IOException | SQLException e) {
				
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
			return comments;
		}
		
		
		public Integer createCommentDetails(Comments comments) throws SQLException, ClassNotFoundException, IOException {
			// Declare variables
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			// Assign insert statement string to variable
			String insertString = "insert into comments (comment,articleId,userid) values (?,?,?)";
			
		    int ID = -1;
		    String[] COL = {"commentid"};
		    
		    MariadbConnection mysql = new MariadbConnection();
		    
		    try
		    {
		        conn = mysql.getConnection();
		        stmt = conn.prepareStatement(insertString, COL);
		        
		        stmt.setString(1, comments.getComment());
		        stmt.setInt(2,comments.getArticleId());
		       stmt.setInt(3,comments.getUserId());
		        
		       
		        
		        
		        
		        
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
		public Comments getuserById(int userId) throws ClassNotFoundException, IOException, SQLException {
			// Declare variables
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Comments ud = null;
			
			// Assign query string to variable
			String qString = "select * from Comments where userid = ?";
			
			// Create MySqlConnection class instance
			MariadbConnection mysql = new MariadbConnection();
			
			// Begin try/catch block to query the database
			try
			{
				// Connect to database and assign query string to PreparedStatement object
				conn = mysql.getConnection();
				stmt = conn.prepareStatement(qString);
				
				// Set query parameters (?)
				stmt.setInt(1, userId); // user_id if from String parameter passed to method
				
				// Run query and assign to ResultSet
				rs = stmt.executeQuery();
				
				// Retrieve ResultSet and assign to new User
				if (rs.next()) {
					ud = new Comments();
					
					ud.setCommentId(rs.getInt(1));
					ud.setComment(rs.getString(2));
					
				}
			}
			catch (ClassNotFoundException | IOException | SQLException e)
			{
				System.out.println("Error: " + e.getMessage());
				e.getStackTrace();
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
			return ud;
		} // End of getUserById() method
	//	
		//****************remove*****************

		public Boolean removeComments(int commentId) throws IOException, SQLException {
	        // Declare variables
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        Integer updateResult = null;
	       // Assign delete string to variable
	       String deleteString = "delete from comments where commentId = ?";
	       // Create MySqlMariadbConnection class instance
	       MariadbConnection mysql = new MariadbConnection();
	        // Begin try/catch block to query the database
	        try
	       {
	            // Connect to database and assign query string to PreparedStatement object
	            conn = mysql.getConnection();
	           stmt = conn.prepareStatement(deleteString);
	           // Set query parameters (?)
	            stmt.setInt(1, commentId);
	            // Run query and assign to ResultSet
	            updateResult = stmt.executeUpdate();
	        }
	       catch (ClassNotFoundException | SQLException e)
	       {
	            System.out.println("Error: " + e.getMessage());
	       }
	        finally
	       {
	            if (stmt != null)
	            {
	                stmt.close();
	            }
	            if (conn != null)
	            {
	                conn.close();
	           }
	        }
	        if (updateResult > 0)
	        {
	            return true;
	        }
	        return false;
	    } // End of removeProduct() method	
	// End of UserDAO class
	//****************updateUser() method*****************

		public Boolean updateComments(Comments comments) throws SQLException, ClassNotFoundException, IOException {
			// Declare variables
			Connection conn = null;
			PreparedStatement stmt = null;
			Integer updateResult = null;
			
			// Assign update string to variable
			String updateString = "update comments "
					+ "set comment where commentId = ?";
			
			// Create MySqlConnection class instance
			MariadbConnection mysql = new MariadbConnection();
			// Begin try/catch block to query the database
			try
			{
				// Connect to database and assign query string to PreparedStatement object
				conn = mysql.getConnection();
				stmt = conn.prepareStatement(updateString);
			
				// Set query parameters (?)
				
				stmt.setInt(1,comments.getCommentId());
				stmt.setString(2, comments.getComment());
				
				
			
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


