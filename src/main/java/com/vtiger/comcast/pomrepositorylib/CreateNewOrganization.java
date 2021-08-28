package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganization {
	
	public CreateNewOrganization(WebDriver driver) {
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "accountname")
	private WebElement organizationNameTextFiled;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "rating")
	private WebElement ratingDropDown;
	
	@FindBy(name = "cpy")
	private WebElement copyShippingAddressRadioBtn;
	
	@FindBy(name = "description")
	private WebElement descriptionBox;
	
	@FindBy(xpath = "//input[@title = 'Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getOrganizationNameTextFiled() {
		return organizationNameTextFiled;
	}
	
    public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
    
    public WebElement getRatingDropDown() {
		return ratingDropDown;
	}

	public WebElement getCopyShippingAddressRadioBtn() {
		return copyShippingAddressRadioBtn;
	}
    
    
    public WebElement getDescriptionBox() {
		return descriptionBox;
	}
	
	
    public WebElement getSaveBtn() {
		return saveBtn;
	}
	

    public void creatingNewOrganization(String orgName) {
		organizationNameTextFiled.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void creatingNewOrganization(String orgName, String industryType) {
		organizationNameTextFiled.sendKeys(orgName);
		Select sel = new Select(industryDropDown);
		sel.selectByVisibleText(industryType);
		saveBtn.click();
	}
	
	public void creatingNewOrganization(String orgName, String ratingType, boolean flag) {
		organizationNameTextFiled.sendKeys(orgName);
		Select sel = new Select(ratingDropDown);
		sel.selectByVisibleText(ratingType);
		saveBtn.click();
	}
	
	public void creatingNewOrganization(String orgName, String industryType, String message) {
		organizationNameTextFiled.sendKeys(orgName);
		Select sel = new Select(industryDropDown);
		sel.selectByVisibleText(industryType);
		copyShippingAddressRadioBtn.click();
		descriptionBox.sendKeys(message);
		saveBtn.click();
		
	}
}



	


