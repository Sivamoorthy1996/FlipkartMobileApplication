package org.flipkart.genericUtility;

import org.flipkart.pom.AddToCartPage;
import org.flipkart.pom.ProductPage;

import io.appium.java_client.android.AndroidDriver;

public class instanceClass {
	public FileUtility fileutility;
	public JavaUtility javautility;
	public ExcelUtility excelutility;
	public MobileUtility mobileUtility;
	public AndroidDriver  driver;
	protected String URL;
	protected String PlatformName;
	protected String Platformversion;
	protected String Timeout;
	protected String UDID;
	protected String apppackage;
	protected String appactivity;
	protected String noreset;
	protected long longTimeout;
	public ProductPage productpage;
	public AddToCartPage addtocartpage ;
	public  String EnterData;
	public String SheetName;

}
