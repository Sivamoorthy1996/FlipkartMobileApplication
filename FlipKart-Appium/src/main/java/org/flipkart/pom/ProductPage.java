package org.flipkart.pom;

import org.flipkart.genericUtility.ThreadSafeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage 
{
	public ProductPage()
	{
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}


	@FindBy(xpath = "//android.widget.TextView[@text='Search for products']")
	private WebElement productTextButton;
	
	@FindBy(xpath = "//android.widget.EditText[@text='Search for Products, Brands and More']")
	private WebElement productText;
	
	@FindBy(xpath="//android.widget.TextView[@text='winter heater']")
	private WebElement EnteredTextFirstOption;
	
	@FindBy(xpath = "//android.widget.Button[@text='NOT NOW']")
	private WebElement cancelButton;
	
	@FindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[1]")
	private WebElement productName; 
	
	/*
	 * This method is used to enter the product name
	 */
	public void EnteringProductName(String EnterData)
	{ 
		productTextButton.click();
		productText.sendKeys(EnterData);
		EnteredTextFirstOption.click();
		//cancelButton.click();	
	}
	
	 /*
	  * This method is used to get the actual product name
	  */
	public String getActualProductName()
	{
		return productName.getText().trim();
	}
	
	/*
	 * This method is used to click on the product
	 */
	public void clickOnProduct()
	{
		productName.click();
	}
}
