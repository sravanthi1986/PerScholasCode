package que6.productDAO.Test;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({TestEnv.class})
public class ques7ProductTest {
	@Test
	public void createProductTest() {
		System.out.println("createProductTest");
		
		
	}
	@Category({ProductionEnv.class})
	@Test
	public void restockInventoryTest() {
		System.out.println("restockInventoryTest");
		
	}

}
