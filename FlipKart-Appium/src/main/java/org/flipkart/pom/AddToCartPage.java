package org.flipkart.pom;

import org.flipkart.genericUtility.ThreadSafeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage 
{
	@FindBy(xpath="//android.widget.TextView[@text='Add to cart']")
	private WebElement AddToCartButton;
	
	@FindBy(xpath="//android.widget.TextView[@text='SKIP']")
	private WebElement skipButton;
	
	@FindBy(xpath="//android.widget.TextView[@text='Go to cart']")
	private WebElement goToCartButton;
	
	@FindBy(xpath="//android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[1]")
	private WebElement ExpectedProduct;
	
	public AddToCartPage() {
		PageFactory.initElements(ThreadSafeClass.getDriver(),this);
	}
	/*
	 * This method is used to get the expected product name
	 */
	public String getExpectedProductName() {
		AddToCartButton.click();
		//skipButton.click();
		goToCartButton.click();
		return ExpectedProduct.getText().trim();
	}
	
	
	
}
