package automation_project_001.testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import automation_project_001.pages.Cart_Page;
import automation_project_001.pages.Product_Page;
import automation_project_001.pages.Signup_Page;

public class Add_Products_in_Cart_TC_012 {

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
		
		//Click 'Products' button
		pp.productbtn();
		
		//Hover over first product and click 'Add to cart'
		pp.clickonfirstproductaddtocart();
		
		//Click 'Continue Shopping' button
        pp.clickoncontinuebutton();
        
        //Hover over second product and click 'Add to cart'
        pp.clickonsecondproductaddtocart();
        
        //Click 'View Cart' button
        cp.viewcartbutton();
        
        //Verify both products are added to Cart
		boolean isProductDetailsIsVisible = cp.verifybothproductsvisible();
		if (isProductDetailsIsVisible) {
			System.out.println("Verify both products are added to Cart");
		} else {
			System.out.println("Failed because both products are not added to Cart");
		}
        
        //Verify their prices, quantity and total price
        cp.productsdetailsincartpage(2);
                
        //Close browser
        sp.closebrowser();
        
	}
	
}
