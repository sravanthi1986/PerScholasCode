package que6.productDAO.Test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import ques6.parameterizedDAO.clas.ProductDAO;

public class DAOProductRemoveTest {
	private static ProductDAO p_dao;

	@BeforeClass
	public static void setUp() {
		p_dao = new ProductDAO();
	}

	@Test
	public void removeProdtctTest() throws ClassNotFoundException, SQLException, IOException {
		boolean exp = p_dao.removeProduct(3);
		assertTrue(exp);
	}

}
