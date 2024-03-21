package automation_project_001.testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import automation_project_001.pages.Cart_Page;
import automation_project_001.pages.Product_Page;
import automation_project_001.pages.Signup_Page;

public class Search_Products_and_Verify_Cart_After_Login_TC_020 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("./Extensions/AdBlock.crx"));
		
		//Launch browser
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
		Signup_Page sp = new Signup_Page(driver);
		Cart_Page cp=new Cart_Page(driver);
		Product_Page pp=new Product_Page(driver);
		
		
		//Navigate to URL 'http://automationexercise.com'
		sp.url();
		
		// Click on 'Products' button
		pp.productbtn();
		
		//Verify user is navigated to ALL PRODUCTS page successfully
		if (sp.verifyCurrentPageIsExpectedPageOrNot("https://automationexercise.com/products")) {
			System.out.println("Verified user is navigated to ALL PRODUCTS page successfully");
			System.out.println(driver.getCurrentUrl());
		} else {
			System.out.println("Failed because user is not navigated to ALL PRODUCTS page.");
		}
		
		//Enter product name in search input and click search button
		pp.searcharea("Jeans");
		pp.searchbutton();
		
		//Verify 'SEARCHED PRODUCTS' is visible
		if (pp.verifysearchedproductstext()) {
			System.out.println("Verify 'SEARCHED PRODUCTS' is visible");

		} else {
			System.out.println("Verify 'SEARCHED PRODUCTS' is not visible");
		}
		
		//Verify all the products related to search are visible
		pp.relatedsearcheditems();
	       
		//Add those products to cart
		pp.addtocartsoftstretchjeans();
		pp.clickoncontinuebutton();
		pp.addtocartregulafitstraightjeans();
		pp.clickoncontinuebutton();
		pp.clickongruntblueslimfitjeans();
		
		
		//Click 'Cart' button
		cp.viewcartbutton();
		
		//verify that products are visible in cart
		if (cp.verifysoftstretchjeansdetailsadded()) {
			System.out.println("Soft Stretch Jeans is visible");
		} else {
			System.out.println("Soft Stretch Jeans is not visible");
		}
		if(cp.verifyregulafitstraightjeansdetailsadded())
		{
			System.out.println("Regular Fit Straight Jeans is visible");	
		}else {
			System.out.println("Regular Fit Straight Jeans is not visible");	
		}
		if(cp.verifygruntblueslimfitjeansdetailsadded())
		{
			System.out.println("Grunt Blue Slim Fit Jeans is visible");	
		}else {
			System.out.println("Grunt Blue Slim Fit Jeans is not visible");	
		}
		
		//Click 'Signup / Login' button and submit login details
		Thread.sleep(1000);
		sp.clickonsignup();
		
		// Enter login email
		sp.loginemail("ankikap11@gmail.com");

		// Enter login pass
		sp.loginpass("admin@123");

		// click on login button
		sp.clickonloginbtn();
		
		//Again, go to Cart page
		cp.cartbutton();
		
		//Verify that those products are visible in cart after login as well
		if (cp.verifysoftstretchjeansdetailsadded()) {
			System.out.println("Soft Stretch Jeans is visible");
		} else {
			System.out.println("Soft Stretch Jeans is not visible");
		}
		if(cp.verifyregulafitstraightjeansdetailsadded())
		{
			System.out.println("Regular Fit Straight Jeans is visible");	
		}else {
			System.out.println("Regular Fit Straight Jeans is not visible");	
		}
		if(cp.verifygruntblueslimfitjeansdetailsadded())
		{
			System.out.println("Grunt Blue Slim Fit Jeans is visible");	
		}else {
			System.out.println("Grunt Blue Slim Fit Jeans is not visible");	
		}
		
		
	    //Close browser
		sp.closebrowser();
	}

}
