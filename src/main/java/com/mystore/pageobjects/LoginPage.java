package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getLoginPageTitle() {
		return getDriver().getTitle();
	}

}
