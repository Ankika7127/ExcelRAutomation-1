package automation_project_001.testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import automation_project_001.pages.Signup_Page;

public class View_Category_Products_TC_018 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("./Extensions/AdBlock.crx"));
		
		//Launch browser
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
		Signup_Page sp = new Signup_Page(driver);
				
		
		//Navigate to URL 'http://automationexercise.com'
		sp.url();

		//Verify that categories are visible on left side bar
        if(sp.verifycatagories())
        {
        	System.out.println("Verified that categories are visible on left side bar");
        }else {
        	System.out.println("Failed because that categories are not visible on left side bar");	
        }
        
        //Click on 'Women' category
        sp.clickonwomencatagory();
        
        //Click on any category link under 'Women' category, for example: Dress
        sp.clickondresssubcatagory();
        
        //Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        if(sp.verifywomendressproductsvisible())
        {
        	System.out.println("Verified that category page is displayed and confirm text 'WOMEN - DRESS PRODUCTS'");
        }else {
        	System.out.println("Failed because that category text is not displayed as 'WOMEN - TOPS PRODUCTS'");	
        }
        
               
        //On left side bar, click on any sub-category link of 'Men' category
        sp.clickonmencatagory();
        sp.clickonjeanssubcatagory();
        
        //Verify that user is navigated to that category page
        if(sp.verifymenjeansproductspagevisible())
        {
        	System.out.println("Verified that category page is displayed and confirm text 'MEN - JEANS PRODUCTS'");
        }else {
        	System.out.println("Failed because that category text is not displayed as 'MEN - JEANS PRODUCTS'");	
        }
        
        //Close browser
        sp.closebrowser();
	}

}
