package com.sampleBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sampleBanking.pageObjects.Login_page;

public class TC_LoginPage_001 extends BaseClass {
	
	@Test
	
	public void loginTestCase() throws IOException{
	
//		driver.get(baseURL);
		
		logger.info("URL is opened");
		
		Login_page lp=new Login_page(driver);
		lp.setName(userName);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered password");
		
		lp.clickButton();
		logger.info("Clicked on login");
	
		
		/*if(driver.getTitle().equals(" GTPL Bank Manager HomePage ")) {
			Assert.assertTrue(true);
			logger.info("If_part executed");
			
			
		}
		
		else {
			
			captureScreen(driver , "loginTestCase");
			try{
			Assert.assertTrue(false);
			}
			catch(Exception e) {}
			logger.info("Else_part executed");
		}*/
		
		if (isAlertPresent()==true) {
			
			captureScreen(driver , "loginTestCase");
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
//			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		
		else {
//			Assert.assertTrue(true);
			logger.info("Login passed");
		}
		
		
		
		
	}

	public boolean isAlertPresent() // To check alert is present or not.
	{
		try {

			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	

}
