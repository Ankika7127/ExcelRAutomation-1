package automation_project_001.testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import automation_project_001.pages.Product_Page;
import automation_project_001.pages.Signup_Page;

public class Search_Product_TC_009 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("./Extensions/AdBlock.crx"));
		
		//Launch browser
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
		Signup_Page sp = new Signup_Page(driver);
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
		
		//Click on 'Products' button
		pp.productbtn();
		
		//Verify user is navigated to ALL PRODUCTS page successfully
		boolean isValidUrl=sp.verifyCurrentPageIsExpectedPageOrNot("https://automationexercise.com/products");
		
		if(isValidUrl) {
			System.out.println("Verified user is navigated to ALL PRODUCTS page successfully");
			System.out.println("The all product page url is: "+ driver.getCurrentUrl());
		}else {
			System.out.println("Failed because user is not navigated to ALL PRODUCTS page.");
		}

        //Enter product name in search input and click search button
		pp.searcharea("Jeans");
		pp.searchbutton();
		
		//Verify 'SEARCHED PRODUCTS' is visible
		boolean isSearchedProductTextIsVisible= pp.verifysearchedproductstext();
		if(isSearchedProductTextIsVisible) {
			System.out.println("Verify 'SEARCHED PRODUCTS' is visible");
			
			}else {
			System.out.println("Verify 'SEARCHED PRODUCTS' is not visible");
		}
				
		//Verify all the products related to search are visible
        pp.relatedsearcheditems();
        
        //Close browser
        sp.closebrowser();
		
	}

}
