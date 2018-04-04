package com.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class SuiteCRMCreateContactPage {
	private WebDriver driver;

	public SuiteCRMCreateContactPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	public WebElement firsName;

	@FindBy(id = "last_name")
	public WebElement lastName;

	@FindBy(id = "phone_work")
	public WebElement officePhoneNumber;

	@FindBy(id = "department")
	public WebElement department;

	@FindBy(id = "SAVE")
	public WebElement save;

	@FindBy(xpath = "//input[@title='Save']")
	public WebElement saveConfirmation;

	@FindBy(id = "phone_mobile")
	public WebElement cellPhone;

	public void save() {
		save.click();
		try {
			Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			saveConfirmation.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

}
