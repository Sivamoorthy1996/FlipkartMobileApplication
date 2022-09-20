package org.flipkart.genericUtility;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;

public class ThreadSafeClass {
	
	
	private static ThreadLocal<JavaUtility> javautility=new ThreadLocal<>();
	private static ThreadLocal<MobileUtility> mobileutility=new ThreadLocal<>();
	private static ThreadLocal<AndroidDriver> driver=new ThreadLocal<>();

	


	public static AndroidDriver getDriver() {
		return driver.get();
	}




	public static void setDriver(AndroidDriver driver) {
		ThreadSafeClass.driver.set(driver);
	}




	public static JavaUtility getJavautility() {
		return javautility.get();
	}
	
	
	

	public static MobileUtility getMobileutility() {
		return mobileutility.get();
	}


	public static void setMobileutility(MobileUtility mobiledriver) {
		mobileutility.set(mobiledriver);
	}


	public static void setJavautility(JavaUtility javdriver) {
		javautility.set(javdriver);
	}

	
	
	

}
