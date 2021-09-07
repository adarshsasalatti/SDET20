package com.vtiger.pomtest3;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.vtiger.comcast.pomrepositorylib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Login;
import com.vtiger.comcast.pomrepositorylib.Organization;
import com.vtiger.pomrepositorylib.CopyShippingAddressIsSelectedOrNotTest;

public class CreateOrganizationWithShippingAddressTest {

	public static void main(String[] args) 
	{
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		//common data
		String username = "admin";
		String password = "root";
		String URL = "http://localhost:8888";
		String Browser = "chrome";
		
		//test-script data
		String orgName = "Amazon_"+randomInt;
		String industryType = "Energy";
		String message = "[ CAM** ] abc - Campaign Information   Updated today";
		
		//navigate to app
		//System.setProperty("webdriver.chrome.driver","./target/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(URL);
		
		//step 1 : login
		Login loginpage = new Login(driver);
		loginpage.loginToApp(username, password);
		
		//step 2 : navigate to organization page and click on new organization button to create new organization
		Organization organization = new Organization(driver);
		organization.getOrganizationLink().click();
		organization.getNewOrganizationBtn().click();
		
		//Step 3 : creating new organization 
		CreateNewOrganization createNewOrganizationWithShippingAddress = new CreateNewOrganization(driver);
		createNewOrganizationWithShippingAddress.creatingNewOrganization(orgName, industryType, message);
	
        Home home = new Home(driver);
		
		home.signOut();
		
		//driver.quit();
		
		
		

	}

}
