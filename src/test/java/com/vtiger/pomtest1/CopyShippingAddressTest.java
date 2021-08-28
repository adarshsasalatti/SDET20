package com.vtiger.pomtest1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pomrepositorylib.CopyShippingAddressIsSelectedOrNotTest;
import com.vtiger.pomrepositorylib.LogOut;
import com.vtiger.pomrepositorylib.LoginPage;
import com.vtiger.pomrepositorylib.OrganizationPage;


public class CopyShippingAddressTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\eclipse-workspace\\Sample1\\target\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApp("admin", "root");
		
		OrganizationPage organization = new OrganizationPage(driver);
		organization.getOrganizationLink().click();
		organization.getNewOrganizationBtn().click();
		
		CopyShippingAddressIsSelectedOrNotTest copyShippingAddressIsSelectedOrNotTest = new CopyShippingAddressIsSelectedOrNotTest(driver);
		WebElement radioBtn = copyShippingAddressIsSelectedOrNotTest.getCopyShippingAddressRadioBtn();
		if(radioBtn.isSelected())
		System.out.println("::PASS:: ELEMENT IS ENABLED");
		else
		System.out.println("::FAIL:: ELEMENT IS NOT ENABLED");
		
		LogOut logOut = new LogOut(driver);
		logOut.signOut();
		
		driver.quit();
	}
}
