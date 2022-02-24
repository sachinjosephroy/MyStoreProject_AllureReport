package com.mystore.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ListenerClass extends ExtentManager implements ITestListener {
	
	Action action= new Action();
	
	public void onTestStart(ITestResult result) {
//		test = extent.createTest(result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			action.screenShot(BaseClass.getDriver(), result.getName());
		}
	}

}
