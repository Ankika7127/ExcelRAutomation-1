package automation_project_001.testcases;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import automation_project_001.pages.Signup_Page;

public class Login_User_with_correct_email_and_password_TC_002 {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("./Extensions/AdBlock.crx"));

		WebDriver driver = new ChromeDriver(options);
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

		//verify login to account is visible
		boolean isLogInToYourAccountIsVisible = sp.verifylogintoacc();
		if (isLogInToYourAccountIsVisible) {
			System.out.println("Verified 'Login to your account' is visible");
		} else {
			System.out.println("Failed because Login to your account is not displayed.");
		}

		// Enter login email
		sp.loginemail("ankikap5@gmail.com");

		// Enter login pass
		sp.loginpass("admin@123");

		// click on login button
		sp.clickonloginbtn();

		// Verify logged in as user name
		boolean isLoggedInAsUsername = sp.varifyloggedinas();
		if (isLoggedInAsUsername) {
			System.out.println("Verified 'Logged in as username' is visible");
		} else {
			System.out.println("Failed because 'Logged in as username' is not visible");
		}
		
		//Click on delete button
        sp.deletebtn();
        
       //verify account deleted msg
        boolean isAccountDeletedMsgIsVissible= sp.verifyaccountdeletedmsg();
 	   if(isAccountDeletedMsgIsVissible) {
 		   System.out.println("Verified 'ACCOUNT DELETED!' is visible");
 	   }else  { 
 		   System.out.println("Failed because 'ACCOUNT DELETED!' is not visible");
 	   }
		
 	   sp.closebrowser();
	}

	 
}
