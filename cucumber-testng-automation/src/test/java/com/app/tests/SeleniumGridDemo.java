package com.app.tests;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Demo how to run Selenium tests in Remote Cloud machine using Grid
 * 
 * @author Halil
 *
 */
public class SeleniumGridDemo {
	WebDriver driver;

	public static final String URL = "http://18.220.207.215:4444/wd/hub";

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setPlatform(Platform.ANY);
		//caps.setCapability("version", "latest");
		// *WebDriver driver = new RemoteWebDriver(new URL(urlOfHub), caps);
		driver = new RemoteWebDriver(new URL(URL), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void testGoogle() throws InterruptedException {
		driver.get("https://google.com");
		driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div/div[1]/div/div[1]/input")).sendKeys("Halo" + Keys.ENTER);
		System.out.println(driver.getTitle());
		assertTrue(driver.getTitle().startsWith("Halo"));

		Thread.sleep(1000);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
