package que6.productDAO.Test;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory({ProductionEnv.class})
@Suite.SuiteClasses({ques7ProductTest.class,
	ShopingCartTest.class,
	PaymentTest.class})
public class IncludeProductionEnvTest {

}
