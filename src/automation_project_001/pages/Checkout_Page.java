package automation_project_001.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout_Page {

	private static final WebDriver WebDriver = null;
	WebDriver driver;
	public Checkout_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	//Repository
	
	By addressdetails=By.xpath("//h2[text()='Address Details']");
	By deliverydetailslist=By.xpath("//ul[@id='address_delivery']");
	By reviewurorder=By.xpath("//table[@class='table table-condensed']//tbody");
	By entertextarea=By.xpath("//textarea[@name='message']");
	By placeorder=By.xpath("//a[text()='Place Order']");
	By enternameoncard=By.xpath("//form[@id='payment-form']/div[1]/div/input");
	By cardnumber=By.xpath("//form[@id='payment-form']/div[2]/div/input");
	By cvv=By.xpath("//form[@id='payment-form']/div[3]/div[1]/input");
	By expirationmonth=By.xpath("//input[@name='expiry_month']");
	By expirationyear=By.xpath("//input[@name='expiry_year']");
	By submit=By.id("submit");
	By successmsg=By.xpath("//p[text()='Congratulations! Your order has been confirmed!']");
	
	public boolean verifydeliverydetails(List<String> expectedAddressDetails)
	{	
		WebElement dDetails=driver.findElement(deliverydetailslist);
		List<WebElement> li = dDetails.findElements(By.tagName("li"));
		for(int i=0;i<li.size();i++) 
		{
			if(!(li.get(i).getText().equals(expectedAddressDetails.get(i))))
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean isProductPresent(String productName) {
		By productnameincartpage = By.xpath("//a[text()='" + productName + "']");
		try {
			if (driver.findElement(productnameincartpage) != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}
	
	public void entertextareafield(String s)
	{
		driver.findElement(entertextarea).sendKeys(s);
	}

	public void clickonplaceorderbutton() throws InterruptedException
	{
		driver.findElement(placeorder).click();
		Thread.sleep(2000);
	}
	
	public void enternameonCard(String noc) throws InterruptedException 
	{
		driver.findElement(enternameoncard).sendKeys(noc);
		Thread.sleep(1000);
	}
	
	public void entercardnumber(String cdn) throws InterruptedException 
	{
		driver.findElement(cardnumber).sendKeys(cdn);
		Thread.sleep(1000);
	}
	
	public void entercvvcode(String cv) throws InterruptedException 
	{
		driver.findElement(cvv).sendKeys(cv);
		Thread.sleep(1000);
	}
	
	public void enterexpiremonth(String exmonth) throws InterruptedException 
	{
		driver.findElement(expirationmonth).sendKeys(exmonth);
		Thread.sleep(1000);
	}
	
	public void enterexpireyear(String exyear) throws InterruptedException 
	{
		driver.findElement(expirationyear).sendKeys(exyear);
		Thread.sleep(1000);
	}
	
	public void enterpayandconfirmbutton() throws InterruptedException 
	{
		driver.findElement(submit).click();;
		Thread.sleep(2000);
	}
	
	public boolean verifysuccessmsgdisplyed()
	{
		return driver.findElement(successmsg).isDisplayed();		
	}
	
	
	
}
