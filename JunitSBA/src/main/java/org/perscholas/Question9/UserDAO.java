package org.perscholas.Question9;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.perscholas.exam.InvalidPasswordException;






public class UserDAO {

		private MysqlConnection mysql;
		private Connection conn = null;
		public void testConnection() throws SQLException, ClassNotFoundException, IOException {
			try {
				mysql=new MysqlConnection();
				conn = mysql.getConnection();
				System.out.println("Connected to database.");
			} catch (SQLException | ClassNotFoundException | IOException e) {
				System.out.println(e.getMessage());
			} finally {
				if (conn != null) {
					conn.close();
				}
			}

		
	}
	/*	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
	 UserDAO u_dao=new UserDAO();
	 u_dao.testConnection();
			
		}*/
				
				
		//****************getAllUsers() method*****************

		public List<User> getAllUser() throws SQLException, InvalidPasswordException {
            // Declare variables
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            User u = null;
            List<User> UserList = null;
            // Assign query string to a variable
            String qString = "select * from user";
            // Create MySqlConnection class instance
            MysqlConnection dbc = new MysqlConnection();
            // Begin try/catch block to query the database
            try
            {
                // Connect to database
                conn = dbc.getConnection();
                // If the connection fails the application won't make it to this point
                System.out.println("Connected to database.");
                // Create Statement instance/object
                stmt = conn.createStatement();
            
                // Run query and assign to the ResultSet instance
                rs = stmt.executeQuery(qString);
                //Create list to hold User objects
                UserList = new ArrayList<User>();
                // Read the ResultSet instance
                while (rs.next()) {
                    // Each iteration creates a new user
                    u = new User();
                    // Assign columns/fields to related fields in the User object
                    // 1,2 and 3 represent column numbers/positions
                    u.setUserId(rs.getInt(1));
                    u.setName(rs.getString(2));
                    u.setPassword(rs.getString(3));
                    u.setJavaScore(rs.getDouble(4));
                    u.setSqlScore(rs.getDouble(5));
                    
                    // Add the user to the list
                    UserList.add(u);
                    // Repeat until rs.next() returns false (i.e., end of ResultSet)
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
            return UserList;
        }
     public static void main1(String[]args)throws ClassNotFoundException,SQLException,IOException, InvalidPasswordException{
        UserDAO u_dao=new UserDAO();
        List<User>res=new ArrayList<User>();
        res=u_dao.getAllUser();
        System.out.println(res);
        }
     //*****************CREATE
     public Integer createUser(User user) throws SQLException, ClassNotFoundException, IOException {
           // Declare variables
           Connection conn = null;
           PreparedStatement stmt = null;
           ResultSet rs = null;
           // Assign insert statement string to variable
           String insertString = "insert into user (name,password,javascore,sqlscore) values (?,?,?,?)";
           int ID = -1;
           String[] COL = {"userid"};
           MysqlConnection dbc = new MysqlConnection();
           try
           {
               conn =dbc.getConnection();
               stmt = conn.prepareStatement(insertString, COL);
               stmt.setString(1, user.getName());
               stmt.setString(2,user.getPassword());
               stmt.setDouble(3,user.getJavaScore());
               stmt.setDouble(4, user.getSqlScore());
               stmt.executeUpdate();
               rs = stmt.getGeneratedKeys();
               if(rs != null && rs.next()) {
                   ID = rs.getInt(1);
                   user.setUserId(ID);
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
//  public static void main(String[]args)throws ClassNotFoundException,SQLException,IOException, InvalidPasswordException{
//  UserDAO p_dao=new UserDAO();
//User p=new User();
//      p.setName("ramu");
//      p.setPassword("password");
//      p.setJavaScore(99.00);
//      p.setSqlScore(67.09);
//      
//      
//      Integer i=u_dao.createUser(u);
//  System.out.println(i);
//  }
    ///*******************UPDATE
    public Boolean updateUser(User u) throws SQLException, ClassNotFoundException, IOException {
        //Declare variables
        Connection conn = null;    
        PreparedStatement stmt = null;
            Integer updateResult = null;
            
            // Assign update string to variable
            String updateString = "update user "
                    + "set name = ?,  javascore= ? ,sqlscore=?"
                    + "where userid = ?";
            
            // Create MySqlConnection class instance
             MysqlConnection dbc = new MysqlConnection();
            // Begin try/catch block to query the database
            try
            {
                // Connect to database and assign query string to PreparedStatement object
                conn = dbc.getConnection();
                stmt = conn.prepareStatement(updateString);
                
                // Set query parameters (?)
                stmt.setString(1, u.getName());
                stmt.setDouble(2, u.getJavaScore());
                stmt.setDouble(3,u.getSqlScore());
                stmt.setInt(4, u.getUserId());
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
        } //update
    
            
//*******************DELETE
public Boolean removeUser(int ProductId) throws IOException, SQLException {
    // Declare variables
    Connection conn = null;
    PreparedStatement stmt = null;
    Integer updateResult = null;
    
    // Assign delete string to variable
    String deleteString = "delete from user where userid = ?";
    
    // Create MySqlConnection class instance
    MysqlConnection mysql = new MysqlConnection();
    // Begin try/catch block to query the database
    try
    {
        // Connect to database and assign query string to PreparedStatement object
        conn = mysql.getConnection();
        stmt = conn.prepareStatement(deleteString);
        
        // Set query parameters (?)
        stmt.setInt(1, ProductId);
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
} 
//public static void main(String[]args)throws ClassNotFoundException,SQLException,IOException, InvalidPasswordException{
//  UserDAO p_dao=new UserDAO();
//User p=new User();
//
// p_dao.removeUser(2);
//
//}
//****************getuserId() method*****************
//
    public User getUserById(int UserId) throws ClassNotFoundException, IOException, SQLException {
        // Declare variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User p = null;
        
        // Assign query string to variable
        String qString = "select * from user where userId = ?";
        
        // Create MySqlConnection class instance
        MysqlConnection mysql = new MysqlConnection();
        
        // Begin try/catch block to query the database
        try
        {
            // Connect to database and assign query string to PreparedStatement object
            conn = mysql.getConnection();
            stmt = conn.prepareStatement(qString);
            
            // Set query parameters (?)
            stmt.setInt(1, UserId); // user_id if from String parameter passed to method
            
            // Run query and assign to ResultSet
            rs = stmt.executeQuery();
            
            // Retrieve ResultSet and assign to new User
            if (rs.next()) {
                p = new User();
                p.setUserId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setJavaScore(rs.getDouble(3));
                p.setSqlScore(rs.getDouble(4));
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
        return p;
        
    } 
    public static void main(String[]args)throws ClassNotFoundException,SQLException,IOException{
    UserDAO p_dao=new UserDAO();
    User result=p_dao.getUserById(1);
        
        
        System.out.println(result);
}   
    // End of getUserById() method
    
//  //****************getuserByName or login method*****************
//
    public User getUserByName(String name) throws ClassNotFoundException, IOException, SQLException {
        // Declare variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User u = null;
        
        // Assign query string to variable
        String qString = "select * from user where name = ?";
        
        // Create MySqlConnection class instance
        MysqlConnection mysql = new MysqlConnection();
        // Begin try/catch block to query the database
        try
        {
            // Connect to database and assign query string to PreparedStatement object
            conn = mysql.getConnection();
            stmt = conn.prepareStatement(qString);
            
            // Set query parameters (?)
            stmt.setString(1, name); // user_id if from String parameter passed to method
            // Run query and assign to ResultSet
            rs = stmt.executeQuery();
            // Retrieve ResultSet and assign to new User
            if (rs.next()) {
                u = new User();
                u.setUserId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setJavaScore(rs.getDouble(3));
                u.setSqlScore(rs.getDouble(4));
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
    } 
    
//  public static void main(String[]args)throws ClassNotFoundException,SQLException,IOException{
//      UserDAO u_dao=new UserDAO();
//      User result=u_dao.getUserByName("sravs");
//          
//          
//          System.out.println(result);
//  }
//  
    
}
// End of UserDAO class

