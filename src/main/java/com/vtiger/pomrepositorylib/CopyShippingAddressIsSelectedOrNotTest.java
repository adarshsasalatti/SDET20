package com.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CopyShippingAddressIsSelectedOrNotTest {
	
	public CopyShippingAddressIsSelectedOrNotTest(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "cpy")
	private WebElement copyShippingAddressRadioBtn;

	public WebElement getCopyShippingAddressRadioBtn() {
		return copyShippingAddressRadioBtn;
	}
}
