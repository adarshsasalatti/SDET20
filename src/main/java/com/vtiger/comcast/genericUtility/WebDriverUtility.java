package com.vtiger.comcast.genericUtility;
import java.util.concurrent.TimeUnit;

/**
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * this method waits for 20 seconds for page loading
	 * @param driver
	 */

	public void waitUntilPageLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * This method waits for the element to be visible
	 */
	
		public void waitForElementVisibility(WebDriver driver, WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		/**
		 * This method waits for the element to be clicked
		 * @throws InterruptedException 
		 */
		public void waitAndClick(WebElement element) throws InterruptedException
		{
			int count=0;
			while(count<20)
			{
				try
				{
					element.click();
					break;
				}
				catch(Throwable e)
				{
					Thread.sleep(1000);
					count++;
				}
			}
		}
		
}
