package ques6.parameterizedDAO.clas;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	private MariadbConnection dbc;
	private Connection conn = null;
	
	//list product***************
//  public static void main(String[]args)throws ClassNotFoundException,SQLException,IOException{
//      productDAO p_dao=new productDAO();
//      List<Product>res=new ArrayList<Product>();
//      res=p_dao.getAllProducts();
//      System.out.println(res);
//      }
  
  //create product*************
//  //public static void main(String[]args)throws ClassNotFoundException,SQLException,IOException{
//  productDAO p_dao=new productDAO();
//  Product p=new Product();
//  p.setName("testProduct3");
//  p.setPrice(59.09);
//  Integer i=p_dao.createProduct(p);
//  System.out.println(i);
//}
  //updateProduct*************
  //public static void main(String[]args)throws ClassNotFoundException,SQLException,IOException{
//      productDAO p_dao=new productDAO();
//      Product p=new Product();
//      p_dao.getProductById(124);
//  
//      p.setPrice(555.00);
//      p.setName("f");
//      p_dao.updateProduct(p);
//  }
  //removeProduct*************
  //public static void main(String[]args)throws ClassNotFoundException,SQLException,IOException{
//      productDAO p_dao=new productDAO();
//      //Product p=new Product();
//      Product p=new Product();
//  //    
//       p_dao.removeProduct(125);
//      
//      }
 // getProductID***********
//  public static void main(String[]args)throws ClassNotFoundException,SQLException,IOException{
//	  ProductDAO p_dao=new ProductDAO();
//      Product result=p_dao.getProductById(3);
//          
//          
//          System.out.println(result);
//  }    
  //getProductbyname************
  
//  public static void main(String[]args)throws ClassNotFoundException,SQLException,IOException{
//      productDAO p_dao=new productDAO();
//      Product result=p_dao.getProductByName("phone");
//          
//          
//          System.out.println(result);
//  }


	public void testConnection() throws SQLException, ClassNotFoundException, IOException {
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

	
}
	
	public static void main(String[]args)throws ClassNotFoundException,SQLException,IOException{
		ProductDAO p_dao=new ProductDAO();
      Product p=new Product();
  
      p.setProductId(4);
      p.setPrice(555.00);
      p.setName("f");
     p_dao.updateProduct(p);
	}
	
	
	// ****************getAllUsers() method*****************

	public List<Product> getAllProduct() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Product p = null;
		List<Product> productList = null;

		// Assign query string to a variable
		String qString = "select * from products";

		// Create MySqlConnection class instance
		MariadbConnection dbc = new MariadbConnection();

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
			productList = new ArrayList<Product>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new user
				p = new Product();
				// Assign columns/fields to related fields in the User object
				// 1,2 and 3 represent column numbers/positions
				p.setProductId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				// Add the user to the list
				productList.add(p);
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
		return productList;
	} // End of getAllProduct method
	
	 
	//****************createProduct() method*****************
	
	public Integer createProduct(Product product) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// Assign insert statement string to variable
		String insertString = "insert into products (name, price) values (?,?)";
		
	    int ID = -1;
	    String[] COL = {"product_id"};
	    
	    MariadbConnection mysql = new MariadbConnection();
	    
	    try
	    {
	        conn = mysql.getConnection();
	        stmt = conn.prepareStatement(insertString, COL);
	        
	        stmt.setString(1, product.getName());
	        stmt.setDouble(2, product.getPrice());
	        
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
	
	//****************getUserById() method*****************

	public Product getProductById(int productId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Product p = null;
		
		// Assign query string to variable
		String qString = "select * from products where product_id = ?";
		
		// Create MySqlConnection class instance
		MariadbConnection mysql = new MariadbConnection();
		
		// Begin try/catch block to query the database
		try
		{
			// Connect to database and assign query string to PreparedStatement object
			conn = mysql.getConnection();
			stmt = conn.prepareStatement(qString);
			
			// Set query parameters (?)
			stmt.setInt(1, productId); // user_id if from String parameter passed to method
			
			// Run query and assign to ResultSet
			rs = stmt.executeQuery();
			
			// Retrieve ResultSet and assign to new User
			if (rs.next()) {
				p = new Product();
				p.setProductId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getDouble(3));
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
	} // End of getUserById() method
//	
	//****************remove*****************

	public Boolean removeProduct(int ProductId) throws IOException, SQLException {
        // Declare variables
        Connection conn = null;
        PreparedStatement stmt = null;
        Integer updateResult = null;
       // Assign delete string to variable
       String deleteString = "delete from products where product_id = ?";
       // Create MySqlMariadbConnection class instance
       MariadbConnection mysql = new MariadbConnection();
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

	public Boolean updateProduct(Product product) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		
		// Assign update string to variable
		String updateString = "update products "
				+ "set name = ?, price = ? "
				+ "where product_id = ?";
		
		// Create MySqlConnection class instance
		MariadbConnection mysql = new MariadbConnection();
		// Begin try/catch block to query the database
		try
		{
			// Connect to database and assign query string to PreparedStatement object
			conn = mysql.getConnection();
			stmt = conn.prepareStatement(updateString);
		
			// Set query parameters (?)
			stmt.setString(1,product.getName());
			stmt.setDouble(2, product.getPrice());
			stmt.setInt(3, product.getProductId());
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