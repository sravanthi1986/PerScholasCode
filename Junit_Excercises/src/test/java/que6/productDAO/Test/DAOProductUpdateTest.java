package que6.productDAO.Test;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;
import ques6.parameterizedDAO.clas.Product;
import ques6.parameterizedDAO.clas.ProductDAO;
public class DAOProductUpdateTest {
	private static ProductDAO p_dao;
	private static Product product = null;
	@BeforeClass
	public static void setUp() {
		p_dao = new ProductDAO();
		product = new Product();
		product.setProductId(11);
		product.setName("Gold");
		product.setPrice(120.00);
	}

	@Test
	public void removeProdtctTest() throws ClassNotFoundException, SQLException, IOException {
		
		assertTrue(p_dao.updateProduct(product));
	}

}
