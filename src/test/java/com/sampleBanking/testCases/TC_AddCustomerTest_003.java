package com.sampleBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sampleBanking.pageObjects.AddCustomerPage;
import com.sampleBanking.pageObjects.Login_page;

public class TC_AddCustomerTest_003 extends BaseClass {

	
	@Test
	public void addCustomer() throws InterruptedException, IOException {

		Login_page lp = new Login_page(driver);
		lp.setName(userName);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered password");
		
		lp.clickButton();
		

		Thread.sleep(3000);

		AddCustomerPage ac = new AddCustomerPage(driver);

		ac.clickAddNewCustomer();
		
		logger.info("clicked on new customer");
//		driver.switchTo().frame("ad_iframe");
//		driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
		ac.custName("Vinay");
		ac.custgender("male");
		ac.custdob("1", "17", "1997");
	
		ac.custaddress("India");
		ac.custstate("Maharashtra");
		ac.custcity("Solapur");
		ac.custpinno("411401");
		ac.custtelephoneno("7887525496");
		String eMail = randomString() + "@gmail.com";
		ac.custemailid(eMail);
		//ac.custpassword("1234");
		Thread.sleep(2000);
		ac.custsubmit();
		logger.info("clicked on submit");

		Thread.sleep(5000);
		
		logger.info("Validation started...........");

		boolean res = driver.getPageSource().contains("Customer Registerd Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			
		}

		else {
			captureScreen(driver, "addCustomer");
			Assert.assertFalse(false);
			

		}

	}

}
