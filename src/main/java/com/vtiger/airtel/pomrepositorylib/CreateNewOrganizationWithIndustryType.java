package com.vtiger.airtel.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;      //this program is not required
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationWithIndustryType {
	
	public CreateNewOrganizationWithIndustryType(WebDriver driver) {
		PageFactory.initElements(driver,this);
		}
		
		@FindBy(name = "accountname")
		private WebElement organizationNameTextFiled;
		
		@FindBy(name = "industry")
		private WebElement industryDropDown;
		
		@FindBy(xpath = "//input[@title = 'Save [Alt+S]']")
		private WebElement saveBtn;

		public WebElement getOrganizationNameTextFiled() {
			return organizationNameTextFiled;
		}
		
		
		public WebElement getIndustryDropDown() {
			return industryDropDown;
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



		
	}


