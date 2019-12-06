package que6.productDAO.Test;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import ques6.parameterizedDAO.clas.Product;
import ques6.parameterizedDAO.clas.ProductDAO;
public class DAOProductReadTest {
	private static ProductDAO p_dao;
	@BeforeClass
	public static void setUp() {
		p_dao = new ProductDAO();
	}

	@Test
	public void removeProdtctTest() throws ClassNotFoundException, SQLException, IOException {
		Product p = p_dao.getProductById(11);
		assertNotNull(p);
		System.out.println(p);
		
	}

}
