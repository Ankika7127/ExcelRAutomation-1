package automation_project_001.testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import automation_project_001.pages.Cart_Page;
import automation_project_001.pages.Product_Page;
import automation_project_001.pages.Signup_Page;

public class Verify_Product_quantity_in_Cart_TC_013 {

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
		
		//Click 'View Product' for any product on home page
		pp.clickonviewoffirstproduct();
		
		//Verify product detail is opened
        boolean isProductDetailsIsOpen=sp.verifyCurrentPageIsExpectedPageOrNot("https://automationexercise.com/product_details/1");
        if(isProductDetailsIsOpen) {
        	System.out.println("Verify product detail is opened");
        }else {
        	System.out.println("Failed because product detail is not opened");
        }

        //Increase quantity to 4
        int quanity = 4;
        pp.quantitybtn(quanity);
        
        //Click 'Add to cart' button
        cp.addcartbutton();
        
        //Click 'View Cart' button
        cp.viewcartbutton();
        
        //Verify that product is displayed in cart page with exact quantity
        boolean isExactQuantityVisible=cp.quantityincartpage("Blue Top", quanity);
        if(isExactQuantityVisible)
        {
        	System.out.println("Verify that product is displayed in cart page with exact quantity");
        }else {
        	System.out.println("Failed because product is not displayed in cart page with exact quantity");
        }
        
        //Close browser
        sp.closebrowser();
	}
}
