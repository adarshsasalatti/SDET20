package com.vtiger.comcast.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Login;


public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver sdriver;
	
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	
	@BeforeSuite
	public void configBS()
	{
		System.out.println("======connect to DB=======");
	}
	
	@BeforeClass
	public void configBC() throws Throwable {
		String URL = fLib.getPropertyKeyValue("url");
		System.out.println("=============Launch the Browser=======");
		driver = new ChromeDriver();
		sdriver = driver;
		driver.get(URL);
		wLib.waitUntilPageLoad(driver);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void configBM() throws Throwable {
		/*common Data*/
		String username = fLib.getPropertyKeyValue("username");
		String password = fLib.getPropertyKeyValue("password");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		/* Navigate to app*/
	        /* step 1 : login */
	        Login loginPage = new Login(driver);
	        loginPage.loginToApp(username, password);
	}
	
	@AfterMethod
	public void configAM() {
	      /*step 6 : logout*/
		Home homePage = new Home(driver);
        homePage.signOut();
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("=============Close the Browser=======");
		driver.quit();
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("========================close DB========================");
	}
}



