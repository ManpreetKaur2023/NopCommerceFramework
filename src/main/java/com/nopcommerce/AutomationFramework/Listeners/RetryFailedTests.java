package com.nopcommerce.AutomationFramework.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.nopcommerce.AutomationFramework2.Base.TestBase;

public class RetryFailedTests extends TestBase implements IRetryAnalyzer {
  int maxCounter=1;
  int cnt=0;
	@Override
	public boolean retry(ITestResult result) {
		logger.info("Retrying failed test !!!!!!! "+result.getMethod().getMethodName() + " for " + cnt + " times");
		if(cnt<maxCounter) {
			cnt++;  
			return true;
			
		}
		
		return false;
	}

}
