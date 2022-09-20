package org.flipkart.genericUtility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.flipkart.pom.AddToCartPage;
import org.flipkart.pom.ProductPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass extends instanceClass {





	@BeforeMethod
	public void methodSetUp() throws MalformedURLException {
		mobileUtility=new MobileUtility();
		fileutility=new FileUtility();
		javautility=new JavaUtility();
		excelutility=new ExcelUtility();


		ThreadSafeClass.setJavautility(javautility);
		ThreadSafeClass.setMobileutility(mobileUtility);

		//inialize the propertyfile
		fileutility.IntiallizePropertyFile(IPathContants.SRIMANDIRPROPERTYFILEPATH);

		//intialize the excelfile
		excelutility.intiallizeExcelFile(IPathContants.SRIMANDIREXCELFILEPATH);

		//fetching data from the property file
		URL = fileutility.getDataFromProperty("url");
		PlatformName = fileutility.getDataFromProperty("platformname");
		Platformversion = fileutility.getDataFromProperty("platformversion");
		Timeout = fileutility.getDataFromProperty("timeout");
		UDID = fileutility.getDataFromProperty("udid");
		apppackage = fileutility.getDataFromProperty("appPackage");
		appactivity = fileutility.getDataFromProperty("appActivity");
		noreset = fileutility.getDataFromProperty("noreset");
		SheetName = fileutility.getDataFromProperty("sheetname");

		//converting string to long
		longTimeout = javautility.convertStringToLong(Timeout);


		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,PlatformName);
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,Platformversion);
		dc.setCapability(MobileCapabilityType.UDID, UDID);
		dc.setCapability("noReset", noreset);
		//dc for android
		dc.setCapability("appPackage",apppackage);
		dc.setCapability("appActivity",appactivity);

		//appium server port number
		URL url=new URL(URL);
		driver=new AndroidDriver(url, dc);
		ThreadSafeClass.setDriver(driver);

		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);

		//creating object for the pom class
		productpage = new ProductPage();
		addtocartpage = new AddToCartPage();

		//Fatching Data from the excelFile
		 EnterData = excelutility.getDataFromExcel(2, 1, SheetName);

	}

	@AfterMethod
	public void methodTearDown() {
		excelutility.workbookClose();
		driver.closeApp();


	}
	

}
