package Practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;

public class SampleAssertionTest extends BaseClass{
	/*WebDriver driver;

	@BeforeSuite
	void configBS() {
		System.out.println("=== connect to db ===");
	}

	@AfterSuite
	void configAS() {
		System.out.println(" === disconnect from db ====");
	}

	@BeforeClass
	void configBC() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
	}

	@BeforeMethod
	public void configBM() throws Throwable {
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
	}

	@AfterMethod
	public void configAM() {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}*/

	@Test
	public void verifyHomePage() {
		System.out.println("=====Test Start=====");
		String expectedTitle = " Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM".trim();
		System.out.println("capture page title");
		String actTitle = driver.getTitle().trim();
		Assert.assertEquals(actTitle, expectedTitle);
		System.out.println("=====Test End=====");
	}

	@Test
	public void verifyHomePageLogo() {
		System.out.println("=====Test Start=====");
		System.out.println("capture the logo");
		boolean actStatus = driver.findElement(By.xpath("//img[@src='test/logo/vtiger-crm-logo.gif']")).isDisplayed();
		Assert.assertTrue(actStatus);
		System.out.println("=====Test End=====");

	}

}
