package Practise;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportsTest 
{
	public WebDriver driver;
	
	ExtentHtmlReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeSuite
	public void configBS()
	{
		String timeStamp = LocalDateTime.now().toString().replace(":", "-");
		reporter=new 
        ExtentHtmlReporter("..//Sample1/ExtentReports/Sample"+timeStamp+".html");
	reports=new ExtentReports();
	reports.attachReporter(reporter);
	
	System.out.println("Connected to Database");
}
@BeforeClass

public void configBC()
{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@BeforeMethod
public void configBM()
{
	driver.get("http://localhost:8888/");
	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("root");
	driver.findElement(By.id("submitButton")).click();
}
@Test
public void Homepagetitle()
{
	test=reports.createTest("Homepagetitle");
	String hptitle = driver.getTitle();
	System.out.println(hptitle);
	driver.findElement(By.linkText("Organizations")).click();

}
	@Test
	public void orgpagetitle()
	{
		test=reports.createTest("orgpagetitle");
		driver.findElement(By.linkText("Organizations")).click();
		String orgptitle = driver.getTitle();
	System.out.println(orgptitle);
	}
	@AfterMethod
	public void configAM()
	{
		Actions actions=new Actions(driver);
		WebElement signoutmenu = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		actions.moveToElement(signoutmenu).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}
	@AfterClass
	public void configAC() 
	{
  driver.quit();
	}
	@AfterSuite
public void configAS()
{
		reports.flush();
	System.out.println("disConnected to Database");
}
	
}
