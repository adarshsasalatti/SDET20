package com.vtiger.airtel;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.pomrepositorylib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Login;
import com.vtiger.comcast.pomrepositorylib.Organization;
import com.vtiger.comcast.pomrepositorylib.OrganizationInfo;

public class CreatingOrganizationWithRatingTypeTest {

	public static void main(String[] args) 
	{
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		
		JavaUtility jLib = new JavaUtility();
		int randomInt1 = jLib.getRandomNumber();
		//common data
		
		String username = "admin";
		String password = "root";
		String URL = "http://localhost:8888";
		String Browser = "chrome";
		
		//test-script data
		String orgName = "Google_"+randomInt1;
		String ratingType = "Active";
		
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
				CreateNewOrganization createNewOrganizationWithRatingType = new CreateNewOrganization(driver);
				createNewOrganizationWithRatingType.creatingNewOrganization(orgName, ratingType, true);
				
				//verify the successful message with orgname 
				OrganizationInfo organizationInfo = new OrganizationInfo(driver);
				String actMsg = organizationInfo.getMsgInfo().getText();
				if(actMsg.contains(orgName))
				{
				System.out.println("::PASS:: ====> NEW ORGANIZATION CREATED SUCCESSFULLY");
				}
				else
				{
				System.out.println("::FAIL:: ====> NEW ORGANIZATION IS NOT CREATED SUCCESSFULLY");
				}
				
				String actRatingType = organizationInfo.getRatingTypeInfo().getText();
				if(actRatingType.contains(ratingType))
				{
				System.out.println("::PASS:: ====> CORRECT RATINGTYPE SELECTED");
				}
				else
				{
				System.out.println("::FAIL:: ====> INCORRECT RATINGTYPE SELECTED");
				}
				
				Home home = new Home(driver);
				
				home.signOut();
				
				driver.quit();
				
	}
}










