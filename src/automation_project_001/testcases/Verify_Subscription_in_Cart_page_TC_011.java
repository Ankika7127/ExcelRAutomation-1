package automation_project_001.testcases;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import automation_project_001.pages.Cart_Page;
import automation_project_001.pages.Signup_Page;

public class Verify_Subscription_in_Cart_page_TC_011 {

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

		//Verify that home page is visible successfully
		String title = "Automation Exercise";
		boolean isHomePageVissible = sp.varifyhomepage(title);

		if (isHomePageVissible) {
			System.out.println("Verified home page is visible successfully.");
			System.out.println("The Home page title is: " + title);
		} else {
			System.out.println("Home page is not visible successfully.");
		}
		
		//Click 'Cart' button
		cp.cartbutton();

		//Scroll down to footer
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		
		//Verify text 'SUBSCRIPTION'
		boolean isSubscriptiontextIsVisible=sp.verifysubscription();
		if(isSubscriptiontextIsVisible) {
			System.out.println("Verify text 'SUBSCRIPTION'");
		}else {
			System.out.println("Failed because text 'SUBSCRIPTION'is not visible");	
		}
		
		//Enter email address in input and click arrow button
		sp.subscriptionemailid("ankikap33@gmail.com");
		sp.subscriptionarrow();
		
		//Verify success message 'You have been successfully subscribed!' is visible
		boolean isSuccessMsgIsVisible=sp.verifysuccessmsgtext();
		if(isSuccessMsgIsVisible) {
			System.out.println("Verify success message 'You have been successfully subscribed!' is visible");
		}else {
			System.out.println("Failed because success message 'You have been successfully subscribed!' is not visible");
		}
		
		//Close browser
		sp.closebrowser();
	

	}

}
