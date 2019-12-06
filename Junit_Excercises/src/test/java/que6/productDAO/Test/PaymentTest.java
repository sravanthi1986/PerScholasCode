package que6.productDAO.Test;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({TestEnv.class})
public class PaymentTest {
	@Category({ProductionEnv.class})
	@Test
	public void verifyPaymentTest(){
		System.out.println("verify PaymentTest");
		
	}
	@Test
	public void submitPaymentTest() {
		System.out.println("submitPaymentTest");
	}
	
	@Test
	public void confirmPaymentTest() {
		System.out.println("confirmPaymentTest");
		
	}

}
