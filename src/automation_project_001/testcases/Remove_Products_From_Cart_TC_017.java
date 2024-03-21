package automation_project_001.testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import automation_project_001.pages.Cart_Page;
import automation_project_001.pages.Product_Page;
import automation_project_001.pages.Signup_Page;

public class Remove_Products_From_Cart_TC_017 {

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

		//Verify that home page is visible successfully
		String title = "Automation Exercise";
		boolean isHomePageVissible = sp.varifyhomepage(title);

		if (isHomePageVissible) {
			System.out.println("Verified home page is visible successfully.");
			System.out.println("The Home page title is: " + title);
		} else {
			System.out.println("Home page is not visible successfully.");
		}
		
		// Add products to cart
		pp.clickonfirstproductaddtocart();
		pp.clickoncontinuebutton();
		pp.clickonsecondproductaddtocart();
		
		//Click 'View Cart' button
        cp.viewcartbutton();
        
		// Verify that cart page is displayed
		boolean isValidUrlIsDisplayed = sp
				.verifyCurrentPageIsExpectedPageOrNot("https://automationexercise.com/view_cart");
		if (isValidUrlIsDisplayed) {
			System.out.println("Verified that cart page is displayed");
			System.out.println("The cart page url is displayed as: " + driver.getCurrentUrl());
		} else {
			System.out.println("Failed because that cart page is not displayed");
		}
		
		// Click 'X' button corresponding to particular product
		cp.clickoncrossbutton();

		
		//Verify that product is removed from the cart
		if(cp.isProductPresent("Blue Top"))
		{
			System.out.println("Failed because that product is not removed from the cart");
		}else {
			System.out.println("Verified that product is removed from the cart");
		}
        
        //Close browser
		sp.closebrowser();
	}

}
