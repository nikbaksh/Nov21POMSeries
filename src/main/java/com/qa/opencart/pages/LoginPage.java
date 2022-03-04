package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eutil;
	
	//private By Locators
	private By emailID = By.id("input-email");
	private By password = By.id("input-password");
	private By LoginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLknk = By.linkText("Forgotten Password11");
	private By registerLnk = By.linkText("Register");
	
	
	//page constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eutil = new ElementUtil(driver);
		
		
	}
	
	//public methods
	@Step("getting the login page title")
	public String getLoginPageTitle() {
		return eutil.doGetPageTitleIs(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
		
	}
	
	@Step("getting the login page url")
	public String getLoginPageUrl() {
		return eutil.waitForUrlContains(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
	}
	@Step("check forgot password link is displayed or not")
	public boolean isLoginForgotPaswdLnkExist() {
		return eutil.doIsDisplayed(forgotPwdLknk);
	}
	
	@Step("login with username:{0} and password:{1}")
	public AccountsPage doLogin(String userName,String pwd) {
		eutil.doSendKeys(emailID, userName);
		eutil.doSendKeys(password, pwd);
		eutil.doClick(LoginBtn);
		return new AccountsPage(driver);
		
	}
	
	@Step("navigating to register page")
	public RegisterPage goToRegisterPage() {
		eutil.doClick(registerLnk);
		return new RegisterPage(driver);
	}
	
	
	

}
