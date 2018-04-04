package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class SuiteCRMLoginPage {
	
	private WebDriver driver;
	
	public SuiteCRMLoginPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_name")
	public WebElement username;
	
	@FindBy(id="username_password")
	public WebElement password;
	
	@FindBy(name="Login")
	public WebElement login;
	
	public void login(String userName, String pwd) {
		username.sendKeys(userName);
		password.sendKeys(pwd);
		login.click();
	}
	
}
