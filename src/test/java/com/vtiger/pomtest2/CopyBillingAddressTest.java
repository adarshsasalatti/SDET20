package com.vtiger.pomtest2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pomrepositorylib.LogOut;
import com.vtiger.pomrepositorylib.LoginPage;
import com.vtiger.pomrepositorylib.OrganizationPage;
import com.vtiger.pomrepositorylib1.CopyBillingAddressIsSelectedOrNotTest;
import com.vtiger.pomrepositorylib1.LogOutPage;
import com.vtiger.pomrepositorylib1.LoginPage1;
import com.vtiger.pomrepositorylib1.OrganizationPage1;

public class CopyBillingAddressTest {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\eclipse-workspace\\Sample1\\target\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		
		LoginPage1 loginpage = new LoginPage1(driver);
		loginpage.loginToApp("admin", "root");
		
		OrganizationPage1 organization = new OrganizationPage1(driver);
		organization.getOrganizationLink().click();
		organization.getNewOrganizationBtn().click();
		
		CopyBillingAddressIsSelectedOrNotTest copyBillingAddressIsSelectedOrNotTest = new CopyBillingAddressIsSelectedOrNotTest(driver);
		WebElement radioBtn = copyBillingAddressIsSelectedOrNotTest.getCopyBillingAddressRadioBtn();
		if(radioBtn.isSelected())
		{
		System.out.println("::PASS:: ELEMENT IS ENABLED");
		}
		else
		{
		System.out.println("::FAIL:: ELEMENT IS NOT ENABLED");
		}
		
		LogOutPage logOut = new LogOutPage(driver);
		logOut.getSignOut();
		
		driver.quit();

	}

}
