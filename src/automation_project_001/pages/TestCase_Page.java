package automation_project_001.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase_Page {
	
	
	WebDriver driver;
	public TestCase_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Repository
	
	By testcase=By.xpath("//a[text()=' Test Cases']");
	
	
	public void testcasepage() throws InterruptedException
	{
		driver.findElement(testcase).click();
		Thread.sleep(2000);
	}

}
