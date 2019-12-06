package org.raisingkids.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.raisingkids.db.DataBaseConnection;
import org.raisingkids.db.MariadbConnection;
import org.raisingkids.model.Category;


public class CategoryDAO {
	private MariadbConnection dbc;
	private Connection conn = null;
	
	//creating category starting
	public Integer createCategory(Category category) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// Assign insert statement string to variable
		String insertString = "insert into category (categoryName) values (?)";
	    int ID = -1;
	    String[] COL = {"categoryId"};
	    MariadbConnection mysql = new MariadbConnection();
	    try
	    {
	        conn = mysql.getConnection();
	        stmt = conn.prepareStatement(insertString, COL);
	        stmt.setString(1, category.getCategoryName());
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
	} // End of CraeteCategory() method
	
	/**
	 * @param categoryId
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public Boolean removeCategorybyId(int categoryId) throws IOException, SQLException {
        // Declare variables
        Connection conn = null;
        PreparedStatement stmt = null;
        Integer updateResult = null;
       // Assign delete string to variable
       String deleteString = "delete from category where categoryId = ?";
       // Create MySqlMariadbConnection class instance
       MariadbConnection mysql = new MariadbConnection();
        // Begin try/catch block to query the database
        try
       {
            // Connect to database and assign query string to PreparedStatement object
            conn = mysql.getConnection();
           stmt = conn.prepareStatement(deleteString);
           // Set query parameters (?)
            stmt.setInt(1, categoryId);
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
    } // End of removeCategory() method	
	
	
	public Boolean removeCategorybyName(String categoryName) throws IOException, SQLException {
        // Declare variables
        Connection conn = null;
        PreparedStatement stmt = null;
        Integer updateResult = null;
       // Assign delete string to variable
       String deleteString = "delete from category where categoryName = ?";
       // Create MySqlMariadbConnection class instance
       MariadbConnection mysql = new MariadbConnection();
        // Begin try/catch block to query the database
        try
       {
            // Connect to database and assign query string to PreparedStatement object
            conn = mysql.getConnection();
           stmt = conn.prepareStatement(deleteString);
           // Set query parameters (?)
            stmt.setString(1, categoryName);
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
    } // End of removeCategory() method	
	
	//****************getAllCategories() method*****************

		public List<Category> getAllCategories() throws SQLException {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			List<Category> categoryList = null;

			String qString = "select * from category";

			DataBaseConnection databaseConnection = new DataBaseConnection();

			try
			{
				// Connect to database
				conn = databaseConnection.getConnection();
				// If the connection fails the application won't make it to this point
				System.out.println("Connected to database.");

				stmt = conn.createStatement();

				rs = stmt.executeQuery(qString);
				categoryList = new ArrayList<Category>();
				// Outer loop creates the event objects and add them to a list of events
				while (rs.next()) {
					Category category= new Category();
					category.setCategoryId(rs.getInt(1));
					category.setCategoryName(rs.getString(2));
					categoryList.add(category);
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
			return categoryList;
		} // End of getAllCategories method	
	
	public Connection testConnection() throws SQLException, ClassNotFoundException, IOException {
		try {
			dbc=new MariadbConnection();
			conn = dbc.getConnection();
			//System.out.println("Connected to database.");
		} catch (SQLException | ClassNotFoundException | IOException e) {
			System.out.println(e.getMessage());
			return null;
			
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return conn;

	
	}

}
