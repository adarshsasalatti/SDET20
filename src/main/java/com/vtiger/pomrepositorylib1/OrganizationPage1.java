package com.vtiger.pomrepositorylib1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage1 {
	
	public OrganizationPage1(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(xpath = "//img[@src = 'themes/softed/images/btnL3Add.gif']")
	private WebElement newOrganizationBtn;

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getNewOrganizationBtn() {
		return newOrganizationBtn;
	}
}



