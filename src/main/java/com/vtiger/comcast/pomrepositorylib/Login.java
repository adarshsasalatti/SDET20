package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	public Login(WebDriver driver) {
	PageFactory.initElements(driver, this);
    }
	
	@FindBy(name = "user_name") 
	private WebElement usernameField;
	
	@FindBy(name = "user_password")
	private WebElement passwordField;
	
	@FindBy(id = "submitButton")
	private WebElement loginButton;

	public WebElement getUsernameField() {
		return usernameField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void loginToApp(String username, String password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
	}
}

	
