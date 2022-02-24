package com.mystore.managers;

import org.openqa.selenium.WebDriver;

import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class PageObjectManager {
	
	private WebDriver driver;
	private IndexPage indexPage;
	private LoginPage loginPage;
	
	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}
	
	public IndexPage getIndexPage(){

		return (indexPage == null) ? indexPage = new IndexPage(driver) : indexPage;

	}
	
	public LoginPage getLoginPage(){

		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;

	}

}
