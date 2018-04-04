package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class SuiteCRMCreateTaskPage {
	private WebDriver driver;
	
	public SuiteCRMCreateTaskPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="name")
	public WebElement subject;
	
	public WebElement status;
	
	public WebElement date_start_date;
	
	public WebElement date_due_date;
	
	public WebElement priority;
	
	public WebElement description;
	
	public WebElement SAVE;
	
}
