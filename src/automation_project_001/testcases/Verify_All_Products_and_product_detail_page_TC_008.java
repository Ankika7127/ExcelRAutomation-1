package automation_project_001.testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import automation_project_001.pages.Product_Page;
import automation_project_001.pages.Signup_Page;

public class Verify_All_Products_and_product_detail_page_TC_008 {

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
		
		//The products list is visible
		boolean isAllProductIsVisible=pp.allproduct();
		if(isAllProductIsVisible)
		{
			System.out.println("The products list is visible");
		}else {
			System.out.println("The products list is not visible");
		}
		
		//Click on 'View Product' of first product
		pp.clickonviewoffirstproduct();
		
		//User is landed to product detail page
		boolean isValidPage=sp.verifyCurrentPageIsExpectedPageOrNot("https://automationexercise.com/product_details/1");
		if(isValidPage)
		{
			System.out.println("User is landed to product detail page");
			System.out.println("The landed url is:" + driver.getCurrentUrl());
		}
		else
		{
			System.out.println("User is not landed to product detail page");
		}
		
		//Verify product name
		boolean isProductNameIsVisible=pp.verifyproductname();
		if(isProductNameIsVisible)
		{
			System.out.println("The products Name is visible");
		}else {
			System.out.println("The products Name is not visible");
		}
		
		//Verify product category
		boolean isProductCatagoryIsVisible=pp.verifyproductcatagory();
		if(isProductCatagoryIsVisible)
		{
			System.out.println("The products Catagory is visible");
		}else {
			System.out.println("The products Catagory is not visible");
		}
		
		//Verify product price
		boolean isProductPriceIsVisible=pp.verifyproductprice();
		if(isProductPriceIsVisible)
		{
			System.out.println("The products Price is visible");
		}else {
			System.out.println("The products Price is not visible");
		}
		
		//Verify product available
		boolean isProductAvailabilityIsVisible=pp.verifyproductavailability();
		if(isProductAvailabilityIsVisible)
		{
			System.out.println("The products Availability is visible");
		}else {
			System.out.println("The products Availability is not visible");
		}
		
		//Verify product condition
		boolean isProductConditionIsVisible=pp.verifyproductavcondition();
		if(isProductConditionIsVisible)
		{
			System.out.println("The products Condition is visible");
		}else {
			System.out.println("The products Condition is not visible");
		}
		
		//Verify product brand
		boolean isProductBrandIsVisible=pp.verifyproductavbrand();
		if(isProductBrandIsVisible)
		{
			System.out.println("The products Brand is visible");
		}else {
			System.out.println("The products Brand is not visible");
		}
		
        //Close browser
		sp.closebrowser();
	}

}
