package automation_project_001.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Contact_Us_Page {
	
	WebDriver driver;
	public Contact_Us_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	//Repository
	
	By contactus=By.xpath("//a[text()=' Contact us']");
	By getintouch=By.xpath("//h2[text()='Get In Touch']");
	By contactname=By.xpath("//form[@id='contact-us-form']/div[1]/input");
	By contactemail= By.xpath("//form[@id='contact-us-form']/div[2]/input");
	By contactsub= By.xpath("//form[@id='contact-us-form']/div[3]/input");
	By contactmsg= By.id("message");
	By uploadPicture =By.xpath("//form[@id='contact-us-form']/div[5]/input");
	By submitbtn= By.xpath("//input[@name='submit']");
	By successmsg=By.xpath("//div[@class='contact-form']//div[contains(@class,'alert-success')]");
	By homebtn=By.xpath("//span[text()=' Home']");
	
	
	public void contactusbtn() throws InterruptedException
	{
		driver.findElement(contactus).click();
		Thread.sleep(2000);
	}
	
	public boolean verifygetintouchmsg()
	{
		if(driver.findElement(getintouch).isDisplayed()){
			System.out.println("The get in touch is visible as: " + driver.findElement(getintouch).getText());
			return true;
		}else {
			return false;
		}
	}
	
	public void contname(String cname) throws InterruptedException
	{
		driver.findElement(contactname).sendKeys(cname);
		Thread.sleep(1000);
	}
	
	public void contemail(String cemail) throws InterruptedException
	{
		driver.findElement(contactemail).sendKeys(cemail);
		Thread.sleep(1000);
	}
	
	public void subject(String sub) throws InterruptedException
	{
		driver.findElement(contactsub).sendKeys(sub);
		Thread.sleep(1000);
	}
	
	public void message(String msg) throws InterruptedException
	{
		driver.findElement(contactmsg).sendKeys(msg);
		Thread.sleep(1000);
	}
	
	public void uploadfile(String file) throws InterruptedException
	{
		driver.findElement(uploadPicture).sendKeys(file);
		System.out.println("File uploaded successfully"); 
		Thread.sleep(1000);
	}
	
	public void submitbutton() throws InterruptedException
	{
		driver.findElement(submitbtn).click();
		Thread.sleep(1000);
	}
	
	public void alert() throws InterruptedException
	{
		Alert alt=driver.switchTo().alert(); 
		System.out.println(alt.getText());
		alt.accept(); 
		Thread.sleep(1000);
	}
	
	public boolean verifysuccessmsg()
	{
		if(driver.findElement(successmsg).isDisplayed())
        {
			System.out.println("The success msg is visible as: " + driver.findElement(successmsg).getText());
			return true;
	    }else
	    {
	    	return false;
	    }
		
	}
	
	public void homebutton() throws InterruptedException
	{
		driver.findElement(homebtn).click();
		Thread.sleep(1000);
	}
}
