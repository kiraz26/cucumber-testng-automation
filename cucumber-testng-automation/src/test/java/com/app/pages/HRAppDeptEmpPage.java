package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class HRAppDeptEmpPage {
	private WebDriver driver;

	public HRAppDeptEmpPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "pt1:ot1")
	public WebElement departmentID;

	@FindBy(id = "pt1:ot2")
	public WebElement deparmentName;

	@FindBy(id = "pt1:ot3")
	public WebElement managerID;

	@FindBy(id = "pt1:ot4")
	public WebElement locationID;

	@FindBy(id = "pt1:cb3")
	public WebElement Next;

	@FindBy(id = "pt1:r1:0:it1::content")
	public WebElement email;

	@FindBy(id = "pt1:r1:0:cb1")
	public WebElement FindDetails;

	@FindBy(id = "pt1:r1:0:ot1")
	public WebElement firstname;

	@FindBy(id = "pt1:r1:0:ot2")
	public WebElement lastname;

}
