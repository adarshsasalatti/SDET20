package Practise;

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

public class CreateOrganizationByTestNGTest 
{
	WebDriver driver;
	@BeforeSuite
	public void configBS()
	{
		System.out.println("Connected to Database");
	}
    @BeforeClass
	public void configBC()
	{
        driver = new ChromeDriver();
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
    	String hptitle = driver.getTitle();
		System.out.println(hptitle);
		driver.findElement(By.linkText("Organizations")).click();
	}
    @Test
   	public void orgpagetitle()
   	{
  	  driver.findElement(By.linkText("Organizations")).click();
  	  String orgptitle = driver.getTitle();
  		System.out.println(orgptitle);
   	}
    @AfterMethod
    public void configAM() {
    Actions actions=new Actions(driver);
  	WebElement signoutmenu = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
  	actions.moveToElement(signoutmenu).perform();
  	driver.findElement(By.linkText("Sign Out")).click();
    }
    @AfterClass
    public void configAC() {
  	  driver.quit();
    }
    @AfterSuite
  	public void configAS()
  	{
  		System.out.println("disConnected to Database");
  	}
  }
		
	


