package com.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class SuiteCSRMSearchResultsPage {
	private WebDriver driver;

	public SuiteCSRMSearchResultsPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	public WebElement resultLink(String string) {
		return driver.findElement(By.linkText(string));
	}
	
	public List<WebElement> resultsLink(String string) {
		return driver.findElements(By.linkText(string));
	}


}
