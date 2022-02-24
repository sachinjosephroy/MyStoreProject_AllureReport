package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

import io.qameta.allure.Step;

public class IndexPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath = "//a[@class='login']")
	private WebElement signInBtn;
	
	@FindBy(xpath = "//*[@class='logo img-responsive']")
	private WebElement myStoreLogo;
	
	public IndexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Clicking on Sign in Button")
	public LoginPage clickOnSignIn() {
		action.fluentWait(getDriver(), signInBtn, 10);
		action.click(getDriver(), signInBtn);
		return new LoginPage(getDriver());
	}
	
	@Step("Verifying index page title")
	public String getMyStoreTitle() {
		System.out.println(getDriver().getTitle());
		String myStoreTitel=getDriver().getTitle();
		return myStoreTitel;
	}

	@Step("Validating the logo")
	public Boolean validateLogo() {
		return action.isDisplayed(myStoreLogo);
	}

}
