package automation_project_001.testcases;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import automation_project_001.pages.Signup_Page;

public class Register_User_with_existing_email_TC_005 {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("./Extensions/AdBlock.crx"));
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
				
		Signup_Page sp = new Signup_Page(driver);

		// Setup the base URL for our test
		sp.url();

		// Home page verification
		String title = "Automation Exercise";
		boolean isHomePageVissible = sp.varifyhomepage(title);

		if (isHomePageVissible) {
			System.out.println("Verified home page is visible successfully.");
			System.out.println("The Home page title is: " + title);
		} else {
			System.out.println("Home page is not visible successfully.");
		}


		// click on sign up button
		sp.clickonsignup();
		
		// verify new user sign up text is visible
		boolean isNewUserSignUp = sp.varifynewusersignup();
		if (isNewUserSignUp) {
			System.out.println("Verified 'New User Signup!' is visible");
		} else {
			System.out.println("Failed because createAccount isnot displayed.");
		}
		
		
		// Enter name
		sp.sname("Ankika");
		// Enter email
		sp.semail("ankikap17@gmail.com");
		// click on sign up
		sp.Signup();
		
	    //verify email id already exist
		boolean isEmailAddressAlreadyExistIsVisible=sp.emailalreadyexisterrormsg();
		
		if(isEmailAddressAlreadyExistIsVisible)
		{
			System.out.println("Verified error 'Email Address already exist!' is visible");
		}
		else
		{
			System.out.println("Success");
		}
		
		//Close browser
		sp.closebrowser();
	}

}
