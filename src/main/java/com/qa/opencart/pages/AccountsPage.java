package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class AccountsPage {
	private WebDriver driver;
	private ElementUtil eutil;
	
	//private By Locators

	private By header = By.cssSelector("div#logo a");
	private By sections = By.cssSelector("div#content h2");
	private By logoutLink = By.linkText("Logout");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	
	
	
	//page constructor
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		eutil = new ElementUtil(driver);
		
		

	}
	
	public String getAccountPageTitle() {
		return eutil.doGetPageTitleContains(Constants.ACCOUNTS_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	public String getAccountPageURl() {
		return eutil.waitForUrlContains(Constants.ACCOUNTS_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
	}
	 public String getAccountPageHeader() {
		 return eutil.doGetText(header);
	 }
	 
	 public boolean isLogoutlinkExist() {
		 return eutil.doIsDisplayed(logoutLink);
	 }
	 
	 public boolean logout() {
		 if(isLogoutlinkExist()) {
			 eutil.doClick(logoutLink);
			 return true;
		 }
		 return false;
		 
		 }
	 
	 
	 
	 
public List<String> getAccountPageSections(){
	List<WebElement> sectList = eutil.waitForElementsVisible(sections, 10);
	List<String> secValueList = new ArrayList<String>();
	for(WebElement e :sectList) {
		String value = e.getText();
		secValueList.add(value);
		
	}
	return secValueList;
	
}

public boolean SearchExist() {
	return eutil.doIsDisplayed(search);
}


public void doSearch(String productName) {
	if(SearchExist()) {
		eutil.doSendKeys(search, productName);
		eutil.doClick(searchIcon);
		
	}
	
}
}

