package com.vtiger.pomrepositorylib1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	
	WebDriver driver;

	public LogOutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
    private WebElement administratorBtn;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;

	public WebElement getAdministratorBtn() {
		return administratorBtn;
	}

	public WebElement getSignOut() {
		return signOut;
	}
	
	public void logOut() {
	Actions act = new Actions(driver);
	act.moveToElement(administratorBtn).perform();
	signOut.click();
	
    }
}
