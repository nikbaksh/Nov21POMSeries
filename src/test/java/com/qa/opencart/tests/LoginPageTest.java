package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;

@Epic("Epic 100:Design LogiPage for opencart test")
@Story("US-101:LoginPage url test")
public class LoginPageTest extends BaseTest {
	@Description("LoginPage title test")
	@Test
	public void loginPageTitletest() {
		
	String title=	loginPage.getLoginPageTitle();
	System.out.println(title);
	Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("LoginPage url test")
	@Test
	public void loginPageURLtest() {
	String url =loginPage.getLoginPageUrl();
	Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_FRACTION));
	}
	
	@Description("LoginPage forgotpassword test")
	@Test
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isLoginForgotPaswdLnkExist());
	}
	
	@Description("Login with positive credential")
	@Test
	public void noLogin() {
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

}
