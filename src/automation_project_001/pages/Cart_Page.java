package automation_project_001.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart_Page {
	
	WebDriver driver;

	public Cart_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Repository
	
	By cartbtn=By.xpath("//a[text()=' Cart']");
	By viewcart=By.linkText("View Cart");
	By productdetails=By.xpath("//table[@id='cart_info_table']//tbody");
	By firstproductdetails=By.id("product-1");
	By secondproductdetails=By.id("product-2");
	By addtocartbtn=By.xpath("//button[@type='button']");
	By quantityincartpage=By.xpath("//td[@class='cart_quantity']/button");
	By productnameincartpage=By.xpath("//a[text()='Blue Top']");
	By proceedtocheckout=By.xpath("//a[text()='Proceed To Checkout']");
	By regorlogin=By.xpath("//div[@class='modal-body']/p[2]");
	By crossbtn=By.xpath("//a[@data-product-id='1']");
	By softstretchjeansdetails=By.id("product-33");
	By regulafitstraightjeans=By.id("product-35");
	By gruntblueslimfitjeans=By.id("product-37");
	By carttable=By.xpath("//table[@id='cart_info_table']//tbody");
	By downloadinvoice=By.xpath("//a[text()='Download Invoice']");
	By continuebtn=By.xpath("//a[text()='Continue']");
	
	public void cartbutton() throws InterruptedException
	{
		driver.findElement(cartbtn).click();
		Thread.sleep(2000);
	}
	
	public void viewcartbutton() throws InterruptedException
	{
		driver.findElement(viewcart).click();
		Thread.sleep(2000);
	}
	
	public boolean verifybothproductsvisible()
	{
		return driver.findElement(secondproductdetails).isDisplayed();
	}
	
	public void productsdetailsincartpage(int expectedNoOfProducts) {

		WebElement element = driver.findElement(productdetails);
		int actualNoOfPruducts = element.findElements(By.tagName("tr")).size();

		for (int i = 1; i <= actualNoOfPruducts; i++) {
			System.out.println(
					"Product details no. " + i + " visible as: " + driver.findElement(By.id("product-" + i)).getText());
		}

		//return expectedNoOfProducts == actualNoOfPruducts;
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
	
	public void addcartbutton() throws InterruptedException
	{
		driver.findElement(addtocartbtn).click();
		Thread.sleep(2000);
	}
	
	public boolean quantityincartpage(String expectedProductName, int expectedQuantity) {
		String productdisplayed = driver.findElement(productnameincartpage).getText();
		if (productdisplayed.equals(expectedProductName)) {
			String qnt = driver.findElement(quantityincartpage).getText();
			if (qnt.equals(String.valueOf(expectedQuantity))) {
				System.out.println("The quantity shown is: " + driver.findElement(quantityincartpage).getText());
				return true;
			}
			return false;
		} else {
			return false;
		}
	}
	
	public void proceedchkout() throws InterruptedException
	{
		driver.findElement(proceedtocheckout).click();
		Thread.sleep(1000);
	}

	
	public void registerorlogin() throws InterruptedException
	{
		driver.findElement(regorlogin).click();
		Thread.sleep(2000);
	}
	
	public void clickoncrossbutton() throws InterruptedException
	{
		driver.findElement(crossbtn).click();
		Thread.sleep(2000);
	}
	
	public boolean verifysoftstretchjeansdetailsadded() {

		return driver.findElement(softstretchjeansdetails).isDisplayed();
	}
	
	public boolean verifyregulafitstraightjeansdetailsadded() {

		return driver.findElement(regulafitstraightjeans).isDisplayed();
	}
	
	public boolean verifygruntblueslimfitjeansdetailsadded() {

		return driver.findElement(gruntblueslimfitjeans).isDisplayed();
	}
	
	public void clickondownloadinvoice() throws InterruptedException
	{
		driver.findElement(downloadinvoice).click();
		Thread.sleep(2000);
	}
	
	public void clickoncontinuebutton() throws InterruptedException
	{
		driver.findElement(continuebtn).click();
		Thread.sleep(2000);
	}
	
}
