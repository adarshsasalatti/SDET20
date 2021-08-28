package com.vtiger.pomrepositorylib1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CopyBillingAddressIsSelectedOrNotTest {
	
	public CopyBillingAddressIsSelectedOrNotTest(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
		
		@FindBy(name = "cpy")
		private WebElement copyBillingAddressRadioBtn;

		public WebElement getCopyBillingAddressRadioBtn() {
			return copyBillingAddressRadioBtn;
		}

		
	}



