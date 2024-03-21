package automation_project_001.testcases;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import automation_project_001.pages.Signup_Page;
import automation_project_001.pages.TestCase_Page;

public class Verify_Test_Cases_Page_TC_007 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("./Extensions/AdBlock.crx"));
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
		Signup_Page sp = new Signup_Page(driver);
		TestCase_Page tcp=new TestCase_Page(driver);
		
		// Navigate to url 'http://automationexercise.com'
		sp.url();

		// Verify that home page is visible successfully
		String title = "Automation Exercise";
		boolean isHomePageVissible = sp.varifyhomepage(title);

		if (isHomePageVissible) {
			System.out.println("Verified home page is visible successfully.");
			System.out.println("The Home page title is: " + title);
		} else {
			System.out.println("Home page is not visible successfully.");
		}

        //Click on 'Test Cases' button
		tcp.testcasepage();
		
		//Verify user is navigated to test cases page successfully
		boolean isValidUrl=sp.verifyCurrentPageIsExpectedPageOrNot("https://automationexercise.com/test_cases");

		if(isValidUrl)
		{
			System.out.println("Verified user is navigated to test cases page successfully.");
			System.out.println("current url is:" + driver.getCurrentUrl());
		}else {
			System.out.println("Failed because user is not navigated to test cases page.");
		}
				
		//Close browser
		sp.closebrowser();
	}

}
