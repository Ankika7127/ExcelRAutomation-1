package automation_project_001.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Product_Page {
	
	WebDriver driver;
	
	public Product_Page(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	
   //Repository
	
	By product=By.xpath("//a[text()=' Products']");
	By allproducts=By.xpath("//h2[text()='All Products']");
	By viewbuttonoffirstproduct=By.xpath("//div[@class='features_items']/div[2]/div/div[2]/ul/li/a");
	By productname=By.xpath("//h2[text()='Blue Top']");
	By productcatagory=By.xpath("//p[text()='Category: Women > Tops']");
	By productprice=By.xpath("//span[text()='Rs. 500']");
	By productavailability=By.xpath("//div[@class='product-information']/p[2]");
	By productcondition= By.xpath("//div[@class='product-information']/p[3]");
	By productbrand=By.xpath("//div[@class='product-information']/p[4]");
	By search=By.id("search_product");
	By searchbutton=By.id("submit_search");
    By searchedproducts=By.xpath("//h2[text()='Searched Products']");
    By items=By.xpath("//div[contains(@class,'productinfo')]//p");
    By firstproductaddtocart=By.xpath("//a[@data-product-id='1']");
    By continbtn=By.xpath("//button[text()='Continue Shopping']");
    By secondproductaddtocart=By.xpath("//a[@data-product-id='2']");
    By quantity=By.id("quantity");
    By brands=By.xpath("//h2[text()='Brands']");
    By polobrand=By.xpath("//a[text()='Polo']");
    By polobrandproducts=By.xpath("//h2[text()='Brand - Polo Products']");
    By hnmbrand=By.xpath("//a[text()='H&M']");
    By hnmbrandproducts=By.xpath("//h2[text()='Brand - H&M Products']");
    By softstretchjeans =By.xpath("//div[@class='col-sm-9 padding-right']/div/div[2]/div/div[1]/div[1]/a");
    By regulafitstraightjeans=By.xpath("//div[@class='col-sm-9 padding-right']/div/div[3]/div/div[1]/div[1]/a");
    By gruntblueslimfitjeans=By.xpath("//div[@class='col-sm-9 padding-right']/div/div[4]/div/div[1]/div[1]/a");
    By review=By.xpath("//a[text()='Write Your Review']");
    By reviewname=By.xpath("//input[@id='name']");
    By reviewemail=By.xpath("//input[@id='email']");
    By addreview=By.xpath("//textarea[@name='review']");
    By submitreviewbtn=By.xpath("//button[@id='button-review']");
    By reviewsuccessmsg=By.xpath("//div[@class='alert-success alert']/span");
    
    
	public void productbtn() throws InterruptedException
	{
		driver.findElement(product).click();
		Thread.sleep(2000);
	}
	
	public boolean allproduct()
	{
		return (driver.findElement(allproducts).isDisplayed());
	}
	
	public void clickonviewoffirstproduct() throws InterruptedException
	{
		driver.findElement(viewbuttonoffirstproduct).click();
		Thread.sleep(2000);
	}

	
	public boolean verifyproductname()
	{
		return (driver.findElement(productname).isDisplayed());
		
	}
	
	public boolean verifyproductcatagory()
	{
		return (driver.findElement(productcatagory).isDisplayed());
	}
	
	public boolean verifyproductprice()
	{
		return (driver.findElement(productprice).isDisplayed());
	}
	
	public boolean verifyproductavailability()
	{
		return (driver.findElement(productavailability).isDisplayed());
	}
	
	public boolean verifyproductavcondition()
	{
		return (driver.findElement(productcondition).isDisplayed());
	}
	
	public boolean verifyproductavbrand()
	{
		return (driver.findElement(productbrand).isDisplayed());
	}
	
	public void searcharea(String j)
	{
		driver.findElement(search).sendKeys(j);
	}
	
	public void searchbutton() throws InterruptedException
	{
		driver.findElement(searchbutton).click();
		Thread.sleep(2000);
	}
	
	public boolean verifysearchedproductstext()
	{
		return driver.findElement(searchedproducts).isDisplayed();
	}
	
	public void relatedsearcheditems()
	{
		List<WebElement> iteams =driver.findElements(items);
		for(int i=0;i<iteams.size();i++) {
			if(iteams.get(i).getText().contains("Jeans")) {
				System.out.println("Print related product name as: "+iteams.get(i).getText());
			}else {
				System.out.println("No products found");
			}
		}
	}
	
	public void clickonfirstproductaddtocart() throws InterruptedException
	{
		driver.findElement(firstproductaddtocart).click();
		Thread.sleep(2000);
	}
	
	public void clickoncontinuebutton() throws InterruptedException
	{
		driver.findElement(continbtn).click();
		Thread.sleep(2000);
	}
	
	public void clickonsecondproductaddtocart() throws InterruptedException
	{
		driver.findElement(secondproductaddtocart).click();
		Thread.sleep(2000);
	}
	
	public void quantitybtn(int quanity) throws InterruptedException
	{
		driver.findElement(quantity).clear();
		driver.findElement(quantity).sendKeys(String.valueOf(quanity));
		Thread.sleep(1000);
	}
	
	
	public boolean verifybrands()
	{
		return driver.findElement(brands).isDisplayed();
	}
	
	public void clickonpolobrandname() throws InterruptedException
	{
		driver.findElement(polobrand).click();
		Thread.sleep(2000);
	}

	public boolean verifypolobrandsproducts()
	{
		return driver.findElement(polobrandproducts).isDisplayed();
	}
	
	public void clickonhnmbrandname() throws InterruptedException
	{
		driver.findElement(hnmbrand).click();
		Thread.sleep(2000);
	}

	public boolean verifyhnmbrandsproducts()
	{
		return driver.findElement(hnmbrandproducts).isDisplayed();
	}
	
	public void addtocartsoftstretchjeans() throws InterruptedException
	{
		driver.findElement(softstretchjeans).click();
		Thread.sleep(2000);
	}
	
	public void addtocartregulafitstraightjeans() throws InterruptedException
	{
		driver.findElement(regulafitstraightjeans).click();
		Thread.sleep(2000);
	}
	
	public void clickongruntblueslimfitjeans() throws InterruptedException
	{
		driver.findElement(gruntblueslimfitjeans).click();
		Thread.sleep(2000);
	}
	
	public boolean verifywriteyourreview()
	{
		return driver.findElement(review).isDisplayed();
	}
	
	
	public void nameinreview(String rname)
	{
		driver.findElement(reviewname).sendKeys(rname);
	}
	public void emailinreview(String remail)
	{
		driver.findElement(reviewemail).sendKeys(remail);
	}
	public void textinreview(String rtext)
	{
		driver.findElement(addreview).sendKeys(rtext);
	}
	
	public void clickonreviewsubmitbutton() throws InterruptedException
	{
		driver.findElement(submitreviewbtn).click();
		Thread.sleep(2000);
	}
	
	public boolean verifyreviewsuccessmessage()
	{
		return driver.findElement(reviewsuccessmsg).isDisplayed();
	}
	
    
	 
}
