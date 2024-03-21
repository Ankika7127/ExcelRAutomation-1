package automation_project_001.testcases;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import automation_project_001.pages.Cart_Page;
import automation_project_001.pages.Signup_Page;

public class Add_to_cart_from_Recommended_items_TC_022 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("./Extensions/AdBlock.crx"));
		
		//Launch browser
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
		Signup_Page sp = new Signup_Page(driver);
		Cart_Page cp=new Cart_Page(driver);
		
		//Navigate to URL 'http://automationexercise.com'
		sp.url();
		
		//Scroll to bottom of page
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		
		//Verify 'RECOMMENDED ITEMS' are visible
		if(sp.verifyrecommendeditems())
		{
			System.out.println("Verify 'RECOMMENDED ITEMS' are visible");
		}else {
			System.out.println("Failed because 'RECOMMENDED ITEMS' are not visible");
		}
		
		//Click on 'Add To Cart' on Recommended product
		sp.clickonaddtocatofrecommendeditem();
	
		//Click on 'View Cart' button
		cp.viewcartbutton();
		
		//Verify that product is displayed in cart page
		if(sp.verifyrecommendeditemincart())
		{
			System.out.println("Verified that product is displayed in cart page");
		}else {
			System.out.println("Failed because that product is not displayed in cart page");
		}
		
		//Close browser
		sp.closebrowser();

	}

}
