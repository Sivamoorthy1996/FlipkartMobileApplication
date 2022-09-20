package AddToCart;

import org.flipkart.genericUtility.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToCart extends BaseClass
{

	@Test
	public void addProductToCart()
	{
		productpage.EnteringProductName(EnterData);
		String ActualProductName = productpage.getActualProductName();
		productpage.clickOnProduct();
		String ExpectedProductName = addtocartpage.getExpectedProductName();
		Assert.assertEquals(ActualProductName, ExpectedProductName);
	}
}
