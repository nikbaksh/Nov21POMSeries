package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public Properties prop;
	public static String highlight;
	public OptionsManager optionsManager;
	
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal();
	
	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		highlight=prop.getProperty("highlight").trim();
		System.out.println("browser name is : " + browserName);
		optionsManager = new OptionsManager(prop);
		System.out.println("browser name is:"+browserName);
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}else if(browserName.equalsIgnoreCase("safari")) {
			
//			driver=new SafariDriver();
			tlDriver.set(new SafariDriver());
		
	}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url").trim());
	
		return getDriver();

	}
	
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public Properties init_prop() {
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream(".//src//test//resources//config//config.properties");
			
				prop.load(ip);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}
	public String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
}
