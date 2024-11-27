package com.frameworkfortest.Testframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitbutton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginAction(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		submitbutton.click();
	}

	public void enterUsername(String uname) {

		username.sendKeys(uname);
	}
	
	public void enterPwd(String pwd) {

		password.sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		submitbutton.click();
	}
	
	public void clearusername() {
		username.clear();
	}
	
	public void clearpwd() {
		password.clear();
	}
}
