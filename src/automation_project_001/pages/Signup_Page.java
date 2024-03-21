package automation_project_001.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Signup_Page {
	WebDriver driver;

	public Signup_Page(WebDriver driver)// constructor
	{
		this.driver = driver;
	}

	// Repository

	By signupbtn = By.xpath("//a[text()=' Signup / Login']");
	By newusersignup = By.xpath("//div[@class='signup-form']//h2");
	By signupname = By.xpath("//div[@class='signup-form']//input[2]");
	By signupemail = By.xpath("//div[@class='signup-form']//input[3]");
	By signup = By.xpath("//div[@class='signup-form']//button");
	By enteraccinfo = By.xpath("//b[text()='Enter Account Information']");
	By title = By.id("id_gender2");
	By fname = By.id("name");
	By pass = By.id("password");
	By day = By.id("days");
	By month = By.id("months");
	By year = By.id("years");
	By newsletter = By.id("newsletter");
	By optin = By.id("optin");
	By firstname = By.id("first_name");
	By lastname = By.id("last_name");
	By companyname = By.id("company");
	By addres1 = By.id("address1");
	By addres2 = By.id("address2");
	By country = By.id("country");
	By state = By.id("state");
	By city = By.id("city");
	By zipcode = By.id("zipcode");
	By mobile = By.id("mobile_number");
	By creataccbtn = By.xpath("//button[text()='Create Account']");
	By acccreated = By.xpath("//b[text()='Account Created!']");
	By continuebtn = By.linkText("Continue");
	By loggedinas = By.xpath("//a[text()=' Logged in as ']/b[text()='Ankika']");
	By deletbtn = By.xpath("//a[text()=' Delete Account']");
	By accdeleted = By.xpath("//b[text()='Account Deleted!']");
	By contbtn = By.xpath("//a[text()='Continue']");
	By logintouracc = By.xpath("//div[@class='login-form']/h2");
	By loginemail = By.xpath("//div[@class='login-form']//input[2]");
	By loginpass = By.xpath("//div[@class='login-form']//input[3]");
	By loginbtn = By.xpath("//div[@class='login-form']//button");
	By incorrectemailpasserror = By.xpath("//p[text()='Your email or password is incorrect!']");
	By logoutbtn = By.xpath("//a[text()=' Logout']");
	By emailaddressalreadyexisterrorMessage = By.xpath("//p[text()='Email Address already exist!']");
	By subscription=By.xpath("//h2[text()='Subscription']");
	By subscriptionemail=By.id("susbscribe_email");
	By arrowbtn=By.id("subscribe");
	By successmsg=By.xpath("//div[text()='You have been successfully subscribed!']");
	By catagoies=By.xpath("//div[@id='accordian']");
	By womencatagory=By.xpath("//div[@id='accordian']/div[1]/div[1]/h4/a");
	By dress=By.xpath("//div[@id='Women']/div/ul/li[1]/a");
	By womendressproducts=By.xpath("//h2[text()='Women - Dress Products']");
	By mencatagory=By.xpath("//div[@id='accordian']/div[2]/div[1]/h4/a");
	By jeans=By.xpath("//a[text()='Jeans ']");
	By menjeansproducts=By.xpath("//h2[text()='Men - Jeans Products']");
	By recommendeditems=By.xpath("//h2[text()='recommended items']");
	By recommendeditemtocart=By.xpath("//a[@data-product-id='3']");
	By recommendeditemincart=By.xpath("//a[text()='Sleeveless Dress']");
	By arrowtoup=By.xpath("//a[@id='scrollUp']");
	By fulltext=By.xpath("//div[@id='slider-carousel']/div/div[1]/div[1]/h2");
	
	public void url() throws InterruptedException {
		driver.get("http://automationexercise.com");
		Thread.sleep(2000);
	}

	public boolean varifyhomepage(String exptitle) {
		String actualtitle = driver.getTitle();

		if (actualtitle.equals(exptitle)) {
			return true;
		} else {
			return false;
		}
	}

	public void clickonsignup() {
		driver.findElement(signupbtn).click();
	}

	public boolean varifynewusersignup()

	{
		if (driver.findElement(newusersignup).isDisplayed()) {
			System.out.println("The new user sign up is vissible as: " + driver.findElement(newusersignup).getText());
			return true;
		} else {
			return false;
		}
	}

	public void sname(String un) {
		driver.findElement(signupname).sendKeys(un);
	}

	public void semail(String em) {
		driver.findElement(signupemail).sendKeys(em);
	}

	public void Signup() {
		driver.findElement(signup).click();
	}

	public boolean verifyenteraccinformation() {
		if (driver.findElement(enteraccinfo).isDisplayed()) {
			System.out.println("The enter account info vissible as: " + driver.findElement(enteraccinfo).getText());
			return true;
		} else {
			return false;
		}
	}

	public void stitle() {
		driver.findElement(title).click();
	}

	public void fstname(String fnm) {
		driver.findElement(fname).clear();
		driver.findElement(fname).sendKeys(fnm);
	}

	public void password(String psw) {
		driver.findElement(pass).sendKeys(psw);
	}

	public void days(String dy) throws InterruptedException {
		Select selectDay = new Select(driver.findElement(day));
		selectDay.selectByVisibleText(dy);
		Thread.sleep(2000);
	}

	public void months(String mn) throws InterruptedException {
		Select selectMonth = new Select(driver.findElement(month));
		selectMonth.selectByValue(mn);
		Thread.sleep(2000);
	}

	public void years(String yr) throws InterruptedException {
		Select selectYear = new Select(driver.findElement(year));
		selectYear.selectByVisibleText(yr);
		Thread.sleep(2000);
	}

	public void newsltr() throws InterruptedException {
		driver.findElement(newsletter).click();
		Thread.sleep(2000);
	}

	public void optionin() throws InterruptedException {
		driver.findElement(optin).click();
		Thread.sleep(2000);
	}

	public void firstname(String fname) {
		driver.findElement(firstname).sendKeys(fname);
	}

	public void lastname(String lname) {
		driver.findElement(lastname).sendKeys(lname);
	}

	public void companyname(String cname) {
		driver.findElement(companyname).sendKeys(cname);
	}

	public void add1(String add1) {
		driver.findElement(addres1).sendKeys(add1);
	}

	public void add2(String add2) {
		driver.findElement(addres2).sendKeys(add2);
	}

	public void country(String cnt) throws InterruptedException {
		Select selectCountry = new Select(driver.findElement(country));
		selectCountry.selectByVisibleText(cnt);
		Thread.sleep(2000);
	}

	public void state(String st) {
		driver.findElement(state).sendKeys(st);
	}

	public void city(String cty) {
		driver.findElement(city).sendKeys(cty);
	}

	public void zcode(String zip) {
		driver.findElement(zipcode).sendKeys(zip);
	}

	public void mobilenumber(String num) {
		driver.findElement(mobile).sendKeys(num);
	}

	public void clickoncreateaccbtn() throws InterruptedException {
		driver.findElement(creataccbtn).click();
		Thread.sleep(1000);
	}

	public boolean verifyacccreatedmsg() {
		if (driver.findElement(acccreated).isDisplayed()) {
			System.out.println("The account created vissible as: " + driver.findElement(acccreated).getText());
			return true;
		} else {
			return false;
		}
	}

	public void cntbtn() throws InterruptedException {
		driver.findElement(continuebtn).click();
		Thread.sleep(1000);
	}

	public boolean varifyloggedinas() throws InterruptedException {

		if (driver.findElement(loggedinas).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void deletebtn() throws InterruptedException {
		driver.findElement(deletbtn).click();
		Thread.sleep(1000);
	}

	public boolean verifyaccountdeletedmsg() {
		if (driver.findElement(accdeleted).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void continuebtn() throws InterruptedException {
		driver.findElement(contbtn).click();
		Thread.sleep(1000);

	}

	public void closebrowser() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}

	public boolean verifylogintoacc() throws InterruptedException {
		if (driver.findElement(logintouracc).isDisplayed()) {
			System.out.println("Log in to your account is vissible as: " + driver.findElement(logintouracc).getText());
			return true;
		} else {
			return false;
		}
	}

	public void loginemail(String lemail) {
		driver.findElement(loginemail).sendKeys(lemail);
	}

	public void loginpass(String lpass) {
		driver.findElement(loginpass).sendKeys(lpass);
	}

	public void clickonloginbtn() throws InterruptedException {
		driver.findElement(loginbtn).click();
		Thread.sleep(2000);
	}

	public boolean incorrectcredentialerror() {
		return driver.findElement(incorrectemailpasserror).getText().equals("Your email or password is incorrect!");
	}
	
	public boolean verifyCurrentPageIsExpectedPageOrNot(String url) {
		String currenturl=driver.getCurrentUrl();
		return currenturl.equals(url);
	}

	public void clickonlogoutbtn() throws InterruptedException {
		driver.findElement(logoutbtn).click();
		Thread.sleep(2000);
	}

	
	public boolean emailalreadyexisterrormsg()
	{
		return driver.findElement(emailaddressalreadyexisterrorMessage).getText().equals("Email Address already exist!");
		
	}
	
	public boolean verifysubscription()
	{
		return driver.findElement(subscription).isDisplayed();
	}
	
	public void subscriptionemailid(String e) throws InterruptedException{
		driver.findElement(subscriptionemail).sendKeys(e);
		Thread.sleep(1000);
	}

	public void subscriptionarrow() throws InterruptedException
	{
		driver.findElement(arrowbtn).click();
		Thread.sleep(1000);
	}
	
	public boolean verifysuccessmsgtext()
	{
		return driver.findElement(successmsg).isDisplayed();
	}
	
	public boolean verifycatagories()
	{
		return driver.findElement(catagoies).isDisplayed();
	}
	
	public void clickonwomencatagory() throws InterruptedException
	{
		driver.findElement(womencatagory).click();
		Thread.sleep(1000);
	}
	public void clickondresssubcatagory() throws InterruptedException
	{
		driver.findElement(dress).click();
		Thread.sleep(1000);
	}
	
	public boolean verifywomendressproductsvisible()
	{
		return driver.findElement(womendressproducts).isDisplayed();
	}
	
	public void clickonmencatagory() throws InterruptedException
	{
		driver.findElement(mencatagory).click();
		Thread.sleep(1000);
	}
	
	public void clickonjeanssubcatagory() throws InterruptedException
	{
		driver.findElement(jeans).click();
		Thread.sleep(1000);
	}
	
	public boolean verifymenjeansproductspagevisible()
	{
		return driver.findElement(menjeansproducts).isDisplayed();
	}
	
	public boolean verifyrecommendeditems()
	{
		return driver.findElement(recommendeditems).isDisplayed();
	}
	
	public void clickonaddtocatofrecommendeditem() throws InterruptedException
	{
		driver.findElement(recommendeditemtocart).click();
		Thread.sleep(1000);
	}
	
	public boolean verifyrecommendeditemincart()
	{
		return driver.findElement(recommendeditemincart).isDisplayed();
	}
	
	public void clickonarrowbutton() throws InterruptedException
	{
		driver.findElement(arrowtoup).click();
		Thread.sleep(1000);
	}
	
	public boolean verifyfullfledgedtext()
	{
		return driver.findElement(fulltext).isDisplayed();
	}
}
