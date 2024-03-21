package automation_project_001.testcases;

import java.io.File;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import automation_project_001.pages.Signup_Page;

//import dev.failsafe.internal.util.Assert;

public class Register_User_TC_001 {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("./Extensions/AdBlock.crx"));
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
		
		Signup_Page sp=new Signup_Page(driver);
		
		//Setup the base url for our test
		sp.url();
		String title = "Automation Exercise";
		boolean isHomePageVissible = sp.varifyhomepage(title);
		
		if(isHomePageVissible) {
			System.out.println("Verified home page is visible successfully.");
			System.out.println("The Home page title is: " + title);
		} else {
			System.out.println("Home page is not visible successfully.");
		}
		
	    //click on signup button
		sp.clickonsignup();
	
		//verify new user sign up text is visible
		boolean isNewUserSignUp= sp.varifynewusersignup();
		if(isNewUserSignUp) {
			System.out.println("Verified 'New User Signup!' is visible");
		} else {
			System.out.println("Failed because createAccount isnot displayed.");
		}
	
		//Enter name
		sp.sname("Ankika");
		//Enter email
		sp.semail("ankikap54@gmail.com");
		//click on sign up
		sp.Signup();
		//verify enter account info text is visible
		
		boolean isAccountInfoIsVissible= sp.verifyenteraccinformation();
		if(isAccountInfoIsVissible) {
			System.out.println("Verified 'ENTER ACCOUNT INFORMATION' is visible");
		}else {
			System.out.println("Failed because ENTER ACCOUNT INFORMATION is not displayed.");
		}
		
		//enter title
		sp.stitle();
		//Enter first name
		sp.fstname("Ankika");
		//Enter password
		sp.password("admin@123");
		//Select days
		sp.days("22");
		//select month
		sp.months("2");
		//select year
		sp.years("1993");
		//select newsletter
		sp.newsltr();
		//select optin
		sp.optionin();
		//enter firstname
		sp.firstname("Ankika");
		//enter lastname
		sp.lastname("Pattanaik");
		//Enter company
		sp.companyname("Amazon");
		//Enter address1
		sp.add1("Bagmane Tech Park");
		//Enter address2
		sp.add2("Mahadevpura");
		//select country
		sp.country("India");
		//Enter state
		sp.state("Karnataka");
		//Enter city
		sp.city("Bangalore");
		//Enter zipcode
		sp.zcode("560048");
		//Enter mobile number
		sp.mobilenumber("9876543212");
		//click on account create button
		sp.clickoncreateaccbtn();
		//Account created msg vissible
		boolean isAccountCreatedMsgIsVissible=sp.verifyacccreatedmsg();
		if(isAccountCreatedMsgIsVissible) {
			System.out.println("Verified 'ACCOUNT CREATED!' is visible");
		}else {
			System.out.println("Failed because account created is not displayed.");
		}
	
		//Click on continue button
		sp.cntbtn();
		
		//Verify logged in as username
		boolean isLoggedInAsUsername=sp.varifyloggedinas();
		if(isLoggedInAsUsername) {
			System.out.println("Verified 'Logged in as username' is visible");
		}else {
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
		 
	   //click on continue button
	   sp.continuebtn();
       //Close browser
	   sp.closebrowser();
	
		
		
		
		
	}
	
}
