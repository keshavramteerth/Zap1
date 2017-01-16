package com_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ConnectTest 
{
	private WebDriver driver;
	private String site = "http://connectqastg.mheducation.com/";
	String UN="keshav_ins1@gmail.com";
	String PWD="123456";
	
	public void setUp() throws Exception 
	{
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("localhost:5002");
		proxy.setFtpProxy("localhost:5002");
		proxy.setSslProxy("localhost:5002");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PROXY, proxy);
		System.setProperty("webdriver.chrome.driver", "F:\\BrowserDrivers\\chromedriver.exe");
		//driver = new HtmlUnitDriver(capabilities);
		driver = new ChromeDriver(capabilities);
		//driver = new FirefoxDriver(capabilities);
		this.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	protected WebDriver getDriver() 
	{
		return driver;
	}
	protected void setDriver(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	protected String getSite() {
		return site;
	}

	protected void setSite(String site) 
	{
		this.site = site;
	}
	
	private void sleep() 
	{
		try {
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			e.getMessage();
		}		
	}
	
	public void tearDown() throws Exception 
	{
		driver.quit();
	}
	
	public void login()
	{
		driver.get(site);
		sleep();
		driver.findElement(By.id("userName")).sendKeys(UN);
		driver.findElement(By.id("password")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		sleep();
		
	}
	
	public void testAll() 
	{
		login();
	}
	
	public static void main(String[] args) throws Exception {
		ConnectTest test = new ConnectTest();
		test.setUp();
		test.testAll();
		test.tearDown();
		
	}


}
