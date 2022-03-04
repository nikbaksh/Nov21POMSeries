package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.util.Constants;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void accountPagesetUP() {
		accountPage=	loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void accntPageTitleTest() {
		String actTitle = accountPage.getAccountPageTitle();
		Assert.assertEquals(actTitle, Constants.ACCOUNTS_PAGE_TITLE);
		
	}
	
	@Test
	public void accntPageURLTest() {
		String url = accountPage.getAccountPageURl();
		Assert.assertTrue(url.contains(Constants.ACCOUNTS_PAGE_URL_FRACTION));
	}
	
	
	@Test
	public void accntHeaderTest() {
		String header = accountPage.getAccountPageHeader();
		Assert.assertEquals(header, Constants.ACCOUNTS_PAGE_HEADER);
	}
	
	
	@Test
	public void LogoutLinkTest() {
		Assert.assertTrue(accountPage.isLogoutlinkExist());
	}
	@Test
	public void searchExistTest() {
		Assert.assertTrue(accountPage.SearchExist());
	}
	
	
	@Test
	public void sectionListExist() {
		List<String> actAccountList = accountPage.getAccountPageSections();
		Assert.assertEquals(actAccountList,Constants.PAGE_ACCOUNTS_SECTIONLIST);
	}
	
	

}
