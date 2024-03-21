package automation_project_001.testcases;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import automation_project_001.pages.Signup_Page;

public class Verify_Scroll_Up_using_Arrow_button_and_Scroll_Down_functionality_TC_025 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("./Extensions/AdBlock.crx"));
		
		//Launch browser
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
		Signup_Page sp = new Signup_Page(driver);
		
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

		
		//Scroll down page to bottom
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		
		//Verify 'SUBSCRIPTION' is visible
		if(sp.verifysubscription())
		{
			System.out.println("Verified 'SUBSCRIPTION' is visible");
		}else {
			System.out.println("Failed because 'SUBSCRIPTION' is not visible");
		}
		
		//Click on arrow at bottom right side to move upward
		sp.clickonarrowbutton();
		
		//Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
		if(sp.verifyfullfledgedtext())
		{
			System.out.println("Verified that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen");	
		}else {
			System.out.println("Failed because that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is not visible on screen");
		}
		
		//Close browser
		sp.closebrowser();
	}

}
