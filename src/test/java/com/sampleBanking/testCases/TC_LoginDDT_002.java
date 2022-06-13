package com.sampleBanking.testCases;

import java.io.IOException;


import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sampleBanking.pageObjects.Login_page;
import com.sampleBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider="LoginData", priority=1)
	public void loginDDT(String user , String pwd) throws InterruptedException 
	{
		Login_page lp= new Login_page(driver);
		lp.setName(user);
		logger.info("User name provided");
		lp.setPassword(pwd);
		logger.info("Password provided");
		lp.clickButton();
		
		Thread.sleep(3000);
		
		if (isAlertPresent()==true) {
			
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		
		else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			Thread.sleep(3000);
			lp.clickLogout();
			driver.switchTo().alert().accept();  //close logout alert
			driver.switchTo().defaultContent();
		}
		
		
		
	}
	
	public boolean isAlertPresent()    //To check alert is present or not.
	{
		try {
			
			driver.switchTo().alert();
			return true;
		}
		
		catch(NoAlertPresentException e ) {
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path="./src/test/java/com/sampleBanking/testData/LoginData.xlsx";
		
		int rownum= XLUtils.getRowCount(path, "Sheet1");
		int colnum= XLUtils.getCellCount(path, "Sheet1" , 1);
		
		String loginData[][]= new String[rownum][colnum];
		
		for(int i=1 ; i<=rownum ; i++) {
			for(int j=0 ; j<colnum ;j++) {
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return loginData;
		
	}

}
