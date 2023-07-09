package com.nopcommerce.AutomationFramework.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.nopcommerce.AutomationFramework2.Base.TestBase;

public class Utils extends TestBase{
	public static void takeScreenshot(String testName) {
	
	//time stamp
	String timeStaamp=new SimpleDateFormat("dd.MM.yyyy HH.mm.ss").format(new Date());
	
	//take screenshots
	 
	File screenshotFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(screenshotFile, new File("./FailedTestsScreenshots/"+" " +testName+ " "+ timeStaamp +" "+".jpg"));;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}
}