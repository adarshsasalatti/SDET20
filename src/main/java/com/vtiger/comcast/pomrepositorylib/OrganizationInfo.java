package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo {

	public OrganizationInfo(WebDriver driver) {
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[@class = 'dvHeaderText']")
	private WebElement msgInfo;
	
	@FindBy(xpath = "//font[text()='Energy']")
	private WebElement industryTypeInfo;
	
	@FindBy(xpath = "//span[@id='dtlview_Rating']")
	private WebElement ratingTypeInfo;

	public WebElement getMsgInfo() {
		return msgInfo;
	}

	public WebElement getIndustryTypeInfo() {
		return industryTypeInfo;
	}

	public WebElement getRatingTypeInfo() {
		return ratingTypeInfo;
	}

	
	
	
}
