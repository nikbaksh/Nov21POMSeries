package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class RegisterPage {
	private WebDriver driver;
	private ElementUtil eutil;

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input");

	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
	private By sucessMessg = By.cssSelector("div#content h1");

	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eutil = new ElementUtil(driver);
	}
	
	public boolean accountRegistration(String firstName,String lastName,String email,String telephone,String password,String subscribe) {
		eutil.doSendKeys(this.firstName, firstName);
		eutil.doSendKeys(this.lastName, lastName);
		eutil.doSendKeys(this.email, email);
		eutil.doSendKeys(this.telephone, telephone);
		eutil.doSendKeys(this.password, password);
		
		
		if(subscribe.equalsIgnoreCase("yes")) {
			eutil.doClick(subscribeYes);
		}
		else {
			eutil.doClick(subscribeNo);
		}
		eutil.doClick(agreeCheckBox);
		eutil.doClick(continueButton);
		String msg = eutil.doGetText(sucessMessg);
		if(msg.contains(Constants.REGISTER_SUCCESS_MESSG)) {
			eutil.doClick(logoutLink);
			eutil.doClick(registerLink);
			return true;
		}
		
		return false;
		
	}

}
