package automation_project_001.testcases;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import automation_project_001.pages.Contact_Us_Page;
import automation_project_001.pages.Signup_Page;



public class Contact_Us_Form_TC_006 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("./Extensions/AdBlock.crx"));
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
		Signup_Page sp = new Signup_Page(driver);
		Contact_Us_Page cup=new Contact_Us_Page(driver);
		
		
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
		
		//Click on contact us
        cup.contactusbtn();
		
		//Verify get in touch text visible
        boolean isGetInTouchMsgIsVisible=cup.verifygetintouchmsg();
		if(isGetInTouchMsgIsVisible) {
			System.out.println("Verified 'GET IN TOUCH' is visible");
		}else{
			System.out.println("Failed because 'GET IN TOUCH' is not visible");
		}
		
		//Enter name
		cup.contname("Ankika");
		
		//Enter email
		cup.contemail("ankikap12@gmail.com");
		
		//Enter Subject
		cup.subject("Testing");
		
		//Enter message
		cup.message("I like Testing");
		
		//upload a file
		cup.uploadfile("D:\\Screenshots\\draganddrop.jpeg");
		
		//Click on submit button
		cup.submitbutton();
		
		//Handle alert
		cup.alert();
		
		//Verify success msg text visible
        boolean isSuccessMsgIsVisible=cup.verifysuccessmsg();
		if(isSuccessMsgIsVisible) {
			System.out.println("Verified success message 'Success! Your details have been submitted successfully.' is visible");
		}else{
			System.out.println("Failed because success message 'Success! Your details have been submitted successfully.' is not visible");
		}
		
		//click on home button
		cup.homebutton();
		
		
		boolean isValidUrl=	sp.verifyCurrentPageIsExpectedPageOrNot("https://automationexercise.com/");
				
			if(isValidUrl){
			    System.out.println("verify that landed to home page successfully");
			}else {
				System.out.println("Failed because not landed to home page.");
			}
		
		//Close browser
		sp.closebrowser();
	}

}
