package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.mystore.base.BaseClass;
import com.mystore.managers.PageObjectManager;
import com.mystore.utility.ListenerClass;
import com.mystore.utility.Log;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({ListenerClass.class})
public class IndexPageTest extends BaseClass {
	
	PageObjectManager pom;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchApp(browser);
		pom = new PageObjectManager(getDriver());
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(priority=1, description = "Verifying index page title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify index page title on Index Page")
	@Story("Story Name: Index page")
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		String actTitle=pom.getIndexPage().getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Store");
	}
	
	@Test(priority=2, description = "Verifying index page logo")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Verify logo on Index Page")
	@Story("Story Name: Index page")
	public void verifyLogo() {
		Log.startTestCase("verifyLogo");
		Boolean value = pom.getIndexPage().validateLogo();
		Assert.assertTrue(value);
	}
	
	@Test(priority=3, description = "Verifying sign in button from index page")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description: Verify sign in button on Index Page")
	@Story("Story Name: Index page")
	public void clickSignInBtn() {
		Log.startTestCase("clickSignInBtn");
		pom.getIndexPage().clickOnSignIn();
		System.out.println("Before: " + pom.getLoginPage().getLoginPageTitle());
		Assert.assertEquals(pom.getLoginPage().getLoginPageTitle(), "Login - My Stores");
		System.out.println("After: " + pom.getLoginPage().getLoginPageTitle());
	}
}
