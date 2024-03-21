package automation_project_001.testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import automation_project_001.pages.Cart_Page;
import automation_project_001.pages.Checkout_Page;
import automation_project_001.pages.Product_Page;
import automation_project_001.pages.Signup_Page;

public class View_and_Cart_Brand_Products_TC_019 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("./Extensions/AdBlock.crx"));
		
		//Launch browser
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
		Signup_Page sp = new Signup_Page(driver);
		Cart_Page cp=new Cart_Page(driver);
		Product_Page pp=new Product_Page(driver);
		Checkout_Page cop=new Checkout_Page(driver);
		
		//Navigate to URL 'http://automationexercise.com'
		sp.url();
		
		//Click on 'Products' button
		pp.productbtn();
		
		//Verify that Brands are visible on left side bar
		if(pp.verifybrands())
		{
			System.out.println("Verified that Brands are visible on left side bar");
		}else {
			System.out.println("Failed because that Brands are not visible on left side bar");
		}

		//Click on any brand name
		pp.clickonpolobrandname();

		// Verify that user is navigated to brand page
		if (sp.verifyCurrentPageIsExpectedPageOrNot("https://automationexercise.com/brand_products/Polo")) {
			System.out.println("Verified that user is navigated to POLO brand page ");
			System.out.println(driver.getCurrentUrl());
		} else {
			System.out.println("Failed because that user is not navigated to POLO brand page ");
		}
		
		//Verify that brand products are displayed
		if(pp.verifypolobrandsproducts())
		{
			System.out.println("Verified that POLO brand products are displayed");
		}
		else {
			System.out.println("Failed because POLO brand products are not displayed");
		}
		
				
		//On left side bar, click on any other brand link
		pp.clickonhnmbrandname();
		
		//Verify that user is navigated to that brand page 
		if(sp.verifyCurrentPageIsExpectedPageOrNot("https://automationexercise.com/brand_products/H&M"))
		{
			System.out.println("Verified that user is navigated to H&M brand page ");
			System.out.println(driver.getCurrentUrl());
		}else {
			System.out.println("Failed because that user is not navigated to H&M brand page ");
		}
		
		//Verify that brand products are displayed
		if(pp.verifyhnmbrandsproducts())
		{
			System.out.println("Verified that H&M brand products are displayed");
		}
		else {
			System.out.println("Failed because H&M brand products are not displayed");
		}
		
		//Close browser
		sp.closebrowser();
		
	}

}
