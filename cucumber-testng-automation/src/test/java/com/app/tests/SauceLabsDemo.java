package com.app.tests;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SauceLabsDemo {

	WebDriver driver;
	public static final String USERNAME = "tommymiciah";
	public static final String ACCESS_KEY = "204a7c09-879c-4390-8e66-a3c8ff794058";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setPlatform(Platform.MAC);
		caps.setCapability("version", "latest");
		// *WebDriver driver = new RemoteWebDriver(new URL(urlOfHub), caps);
		driver = new RemoteWebDriver(new URL(URL), caps);

	}

	@Test
	public void testGoogle() throws InterruptedException {
		driver.get("https://google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("Halo" + Keys.ENTER);
		System.out.println(driver.getTitle());
		assertTrue(driver.getTitle().startsWith("Halo"));

		Thread.sleep(1000);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
