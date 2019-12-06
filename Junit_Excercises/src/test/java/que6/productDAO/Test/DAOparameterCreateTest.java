package que6.productDAO.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import ques6.parameterizedDAO.clas.Product;
import ques6.parameterizedDAO.clas.ProductDAO;

// Annotate class with @RunWith(Parameterized.class)
@RunWith(Parameterized.class)
public class DAOparameterCreateTest {
	// Declare atttibutes
	private static ProductDAO p_dao;
	private String name;
	private Double price;

	/*
	 * Create the constructor. The order of arguments in the parentheses determines
	 * the parameter position in the two-dimensional Object arrays. Parameter1 =
	 * argument num1, Parameter2 = argument num2, Parameter3 = argument testSum,
	 * Parameter4 = argument confirmation
	 */
	public DAOparameterCreateTest(String name, Double price) {
		this.name = name;
		this.price = price;

	}

	/*
	 * Set up the parameters. The confirmation parameter is null and will be
	 * assigned in the actual test method depending on accuracy of the addition
	 * result.
	 */
	@Parameters()
	public static Collection<Object[]> data() {
		return Arrays.asList(
				new Object[][] { { "phone", 499.00 }, { "Laptop", 799.00 }, { "TV", 899.00 }, { "Tablet", 399.00 } });
	}

	// Create the static class variable additionClass to run the test methods
	@BeforeClass
	public static void setUp() {
		p_dao = new ProductDAO();
	}

	// Run the test
	@Test
	public void ProductDAOTest() throws ClassNotFoundException, SQLException, IOException {

		Product p = new Product();

		p.setName(name);
		p.setPrice(price);
		assertNotNull(p_dao.createProduct(p));
		System.out.printf("Product: %s,Price:%.2f", p.getName(), p.getPrice());

	}// createProduct TEST
   


}
