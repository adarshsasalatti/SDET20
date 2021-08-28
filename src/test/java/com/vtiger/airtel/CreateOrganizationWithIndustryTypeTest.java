package com.vtiger.airtel;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.pomrepositorylib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Login;
import com.vtiger.comcast.pomrepositorylib.Organization;
import com.vtiger.comcast.pomrepositorylib.OrganizationInfo;

@Listeners(com.vtiger.comcast.genericUtility.ListenerImplementationClass.class)
public class CreateOrganizationWithIndustryTypeTest extends BaseClass {
	//boolean tie;
     @Test
     public void createOrganizationWithIndustryTypeTest()
	//public static void main(String[] args) 
	{
		Assert.assertTrue(false);
    	Random random = new Random();
		int randomInt = random.nextInt(1000);
		
		/*Object Creation For Lib*/
		JavaUtility jLib = new JavaUtility();
		int randomInt1 = jLib.getRandomNumber();
		
		//common data
		String username = "admin";
		String password = "root";
		String URL = "http://localhost:8888";
		String Browser = "chrome";
		
		//test-script data
		String orgName = "Google"+randomInt1;
		String industryType = "Energy";
		
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
				CreateNewOrganization createNewOrganizationWithIndustryType = new CreateNewOrganization(driver);
				createNewOrganizationWithIndustryType.creatingNewOrganization(orgName, industryType);
				
				//verify the successful message with orgname 
				OrganizationInfo organizationInfo = new OrganizationInfo(driver);
				boolean actMsg = organizationInfo.getMsgInfo().getText().contains("Apple");
				Assert.assertTrue(actMsg);
				/*if(actMsg.contains(orgName))
				{
				System.out.println("::PASS:: ====> NEW ORGANIZATION CREATED SUCCESSFULLY");
				}
				else
				{
				System.out.println("::FAIL:: ====> NEW ORGANIZATION IS NOT CREATED SUCCESSFULLY");
				}*/
				
				String actIndustryType = organizationInfo.getIndustryTypeInfo().getText();
				
				boolean isIndustryType=actIndustryType.contains(industryType);
				Assert.assertTrue(isIndustryType);
				/*if(actIndustryType.contains(industryType))
				{
				System.out.println("::PASS:: ====> CORRECT INDUSTRYTYPE SELECTED");
				}
				else
				{
				System.out.println("::FAIL:: ====> INCORRECT INDUSTRYTYPE SELECTED");
				}
				*/
				Home home = new Home(driver);
				
				home.signOut();
				
				driver.quit();
				
	}




	}


