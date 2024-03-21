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

public class Place_Order_Register_before_Checkout_TC_015 {

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
		sp.semail("ankikap60@gmail.com");
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
		
		
		// Account created msg vissible
		boolean isAccountCreatedMsgIsVissible = sp.verifyacccreatedmsg();
		if (isAccountCreatedMsgIsVissible) {
			System.out.println("Verified 'ACCOUNT CREATED!' is visible");
		} else {
			System.out.println("Failed because account created is not displayed.");
		}

		// Click on continue button
		sp.cntbtn();

		// Verify logged in as username
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
		
		//Click 'View Cart' button
        cp.viewcartbutton();
		
		if(sp.verifyCurrentPageIsExpectedPageOrNot("https://automationexercise.com/view_cart"))
		{
			System.out.println("Verified that cart page is displayed");
		}else
		{
			System.out.println("Failed because that cart page is not displayed");
		}
		
		//Click Proceed To Checkout
		cp.proceedchkout();
		
	    //Verify Address Details 
		List<String> expectedAddressDetails = new ArrayList();
		expectedAddressDetails.add("YOUR DELIVERY ADDRESS");
		expectedAddressDetails.add("Mrs. Ankika Pattanaik");
		expectedAddressDetails.add("Amazon");
		expectedAddressDetails.add("Bagmane Tech Park");
		expectedAddressDetails.add("Mahadevpura");
		expectedAddressDetails.add("Bangalore Karnataka 560048");
		expectedAddressDetails.add("India");
		expectedAddressDetails.add("9876543212");
		if(cop.verifydeliverydetails(expectedAddressDetails))
	       {
	    	   System.out.println("Verified Address Details");
	       }else
	       {
	    	   System.out.println("Failed because Address Details not matched.");
	       }
	         
	    // Verify review your order
		if (cop.isProductPresent("Blue Top") && cop.isProductPresent("Men Tshirt")) {
				System.out.print("Verified Review Your Order");
		   } else 
		   {
				System.out.print("Failed because Review Your Order is not displayed");
		   }
		
		//Enter description in comment text area and click 'Place Order'
		cop.entertextareafield("N/A");
	    cop.clickonplaceorderbutton();
	
	    
	    //Enter payment details: Name on Card, Card Number, CVC, Expiration date
		cop.enternameonCard("Ankika");
		cop.entercardnumber("123456789098");
		cop.entercvvcode("123");
		cop.enterexpiremonth("2");
		cop.enterexpireyear("2029");
		
		//Click 'Pay and Confirm Order' button
		cop.enterpayandconfirmbutton();
		
		// Verify success message 'Congratulations! Your order has been confirmed!'
		if (cop.verifysuccessmsgdisplyed()) {
			System.out.println("Verified success message 'Congratulations! Your order has been confirmed!'");
		} else {
			System.out.println(
					"Failed because success message does not displyed as 'Congratulations! Your order has been confirmed!'");
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
