package Practise;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;

public class SampleScreenShotTest extends BaseClass{
    @Test
	public void verifyHomePage(Method mtd) throws IOException
	{
	System.out.println(mtd.getName());
    
    String currentTestName=(mtd.getName());
    System.out.println("=====Test Start=====");
    
    EventFiringWebDriver edriver = new EventFiringWebDriver(driver); 
    File srcFile = edriver.getScreenshotAs(OutputType.FILE);
    File dstFile = new File("./screenshot/"+currentTestName+".png");
    FileUtils.copyFile(srcFile, dstFile);
    System.out.println("=====Test End=====");

}
}
