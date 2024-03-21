package automation_project_001.testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import automation_project_001.pages.Cart_Page;
import automation_project_001.pages.Product_Page;
import automation_project_001.pages.Signup_Page;

public class Add_review_on_product_TC_021 {

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
		
		// Verify user is navigated to ALL PRODUCTS page successfully
		if (sp.verifyCurrentPageIsExpectedPageOrNot("https://automationexercise.com/products")) {
			System.out.println("Verified user is navigated to ALL PRODUCTS page successfully");
			System.out.println(driver.getCurrentUrl());
		} else {
			System.out.println("Failed because user is not navigated to ALL PRODUCTS page.");
		}
		
		//Click on 'View Product' button
		pp.clickonviewoffirstproduct();
		
		//Verify 'Write Your Review' is visible
		if(pp.verifywriteyourreview())
		{
			System.out.println("Verified 'Write Your Review' is visible");
		}else {
			System.out.println("Failed because 'Write Your Review' is not visible");
		}
		
		//Enter name, email and review
		pp.nameinreview("Ankika");
		pp.emailinreview("ankikap134@gmail.com");
		pp.textinreview("This is a very nice product.");
		
		//Click 'Submit' button
		pp.clickonreviewsubmitbutton();
		
		//Verify success message 'Thank you for your review.'
		if(pp.verifyreviewsuccessmessage())
		{
			System.out.println("Verified success message 'Thank you for your review.'");
				}else {
			System.out.println("Failed because success message 'Thank you for your review.' is not visible.");
		}
		
		//Close browser
		sp.closebrowser();
		
	}

}
