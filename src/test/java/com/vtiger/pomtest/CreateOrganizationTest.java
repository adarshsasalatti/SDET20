package com.vtiger.pomtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.comcast.pomrepositorylib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Login;
import com.vtiger.comcast.pomrepositorylib.Organization;
import com.vtiger.comcast.pomrepositorylib.OrganizationInfo;

public class CreateOrganizationTest {

	public static void main(String[] args)  {
		
		String expMsg = "Google3331123";
		
		System.setProperty("webdriver.chrome.driver","./target/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		Login loginpage = new Login(driver);
		loginpage.loginToApp("admin", "root");
		
		Organization organization = new Organization(driver);
		organization.getOrganizationLink().click();
		organization.getNewOrganizationBtn().click();
		
		CreateNewOrganization createNewOrganization = new CreateNewOrganization(driver);
		createNewOrganization.creatingNewOrganization("Google3331123");
		
		OrganizationInfo organizationInfo = new OrganizationInfo(driver);
		String actMsg = organizationInfo.getMsgInfo().getText();
		if(actMsg.contains(expMsg))
		System.out.println("::PASS:: ====> NEW ORGANIZATION CREATED SUCCESSFULLY");
		else
		System.out.println("::FAIL:: ====> NEW ORGANIZATION IS NOT CREATED SUCCESSFULLY");
		
		Home home = new Home(driver);
		
		home.signOut();
		
		driver.quit();
	}
}
