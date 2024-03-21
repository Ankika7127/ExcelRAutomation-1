package automation_project_001.testcases;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import automation_project_001.pages.Cart_Page;
import automation_project_001.pages.Checkout_Page;
import automation_project_001.pages.Product_Page;
import automation_project_001.pages.Signup_Page;

public class Verify_address_details_in_checkout_page_TC_023 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("./Extensions/AdBlock.crx"));
		
		//Launch browser
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
		Signup_Page sp = new Signup_Page(driver);
		Cart_Page cp=new Cart_Page(driver);
		Product_Page pp=new Product_Page(driver);
		Checkout_Page cop=new Checkout_Page(driver);
		
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

		// click on sign up button
		sp.clickonsignup();
		
		// Enter name
		sp.sname("Ankika");
		// Enter email
		sp.semail("ankikap65@gmail.com");
		// click on sign up
		sp.Signup();
		
		// enter title
		sp.stitle();
		// Enter first name
		sp.fstname("Ankika");
		// Enter password
		sp.password("admin@123");
		// Select days
		sp.days("22");
		// select month
		sp.months("2");
		// select year
		sp.years("1993");
		// select newsletter
		sp.newsltr();
		// select optin
		sp.optionin();
		// enter firstname
		sp.firstname("Ankika");
		// enter lastname
		sp.lastname("Pattanaik");
		// Enter company
		sp.companyname("Amazon");
		// Enter address1
		sp.add1("Bagmane Tech Park");
		// Enter address2
		sp.add2("Mahadevpura");
		// select country
		sp.country("India");
		// Enter state
		sp.state("Karnataka");
		// Enter city
		sp.city("Bangalore");
		// Enter zipcode
		sp.zcode("560048");
		// Enter mobile number
		sp.mobilenumber("9876543212");
		// click on account create button
		sp.clickoncreateaccbtn();
		
		// Verify 'ACCOUNT CREATED!'
		boolean isAccountCreatedMsgIsVissible = sp.verifyacccreatedmsg();
		if (isAccountCreatedMsgIsVissible) {
			System.out.println("Verified 'ACCOUNT CREATED!' is visible");
		} else {
			System.out.println("Failed because account created is not displayed.");
		}

		// Click on continue button
		sp.cntbtn();
		
		// Verify ' Logged in as username' at top
		boolean isLoggedInAsUsername = sp.varifyloggedinas();
		if (isLoggedInAsUsername) {
			System.out.println("Verified 'Logged in as username' is visible");
		} else {
			System.out.println("Failed because 'Logged in as username' is not visible");
		}
		
		// Add products to cart
		pp.clickonfirstproductaddtocart();
		// Click 'Continue Shopping' button
		pp.clickoncontinuebutton();
		pp.clickonsecondproductaddtocart();

		// Click 'Cart' button
		cp.viewcartbutton();
		
		//Verify that cart page is displayed
		if(sp.verifyCurrentPageIsExpectedPageOrNot("https://automationexercise.com/view_cart"))
		{
			System.out.println("Verified that cart page is displayed");
		}else
		{
			System.out.println("Failed because that cart page is not displayed");
		}
		
		//Click Proceed To Checkout
		cp.proceedchkout();
		
		//  Verify that the delivery address is same address filled at the time registration of account
		List<String> expectedDeliveryAddressDetails = new ArrayList();
		expectedDeliveryAddressDetails.add("YOUR DELIVERY ADDRESS");
		expectedDeliveryAddressDetails.add("Mrs. Ankika Pattanaik");
		expectedDeliveryAddressDetails.add("Amazon");
		expectedDeliveryAddressDetails.add("Bagmane Tech Park");
		expectedDeliveryAddressDetails.add("Mahadevpura");
		expectedDeliveryAddressDetails.add("Bangalore Karnataka 560048");
		expectedDeliveryAddressDetails.add("India");
		expectedDeliveryAddressDetails.add("9876543212");
		if (cop.verifydeliverydetails(expectedDeliveryAddressDetails)) {
			System.out.println("Verified delivery Address Details");
		} else {
			System.out.println("Failed because delivery Address Details not matched.");
		}
		
		//Verify that the billing address is same address filled at the time registration of account
		List<String> expectedBillingAddressDetails = new ArrayList();
		expectedBillingAddressDetails.add("YOUR DELIVERY ADDRESS");
		expectedBillingAddressDetails.add("Mrs. Ankika Pattanaik");
		expectedBillingAddressDetails.add("Amazon");
		expectedBillingAddressDetails.add("Bagmane Tech Park");
		expectedBillingAddressDetails.add("Mahadevpura");
		expectedBillingAddressDetails.add("Bangalore Karnataka 560048");
		expectedBillingAddressDetails.add("India");
		expectedBillingAddressDetails.add("9876543212");
		if (cop.verifydeliverydetails(expectedBillingAddressDetails)) {
			System.out.println("Verified billing Address Details");
		} else {
			System.out.println("Failed because billing Address Details not matched.");
		}
		
		//Click 'Delete Account' button
		sp.deletebtn();
		
		//Verify 'ACCOUNT DELETED!' and click 'Continue' button
		if(sp.verifyaccountdeletedmsg())
		{
			System.out.println("Verified account deleted successfully.");
		}else
		{
			System.out.println("Failed because account is not deleted successfully.");
		}
		sp.continuebtn();
		
		//close browser
		sp.closebrowser();
	}

}
