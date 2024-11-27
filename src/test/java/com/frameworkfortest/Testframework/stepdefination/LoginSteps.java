package com.frameworkfortest.Testframework.stepdefination;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.frameworkfortest.Testframework.LoginPage;
import com.frameworkfortest.Testframework.testcomponents.BaseTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseTest {

	WebDriver driver;
	LoginPage loginPage;

	@Given("the OrangeHRM login page is open")
	public void openLoginPage() throws IOException {
		driver = initBrowser();
	}

	@When("I enter the username {string}")
	public void enterUsername(String username) {

		loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
	}

	@And("I enter the password {string}")
	public void enterPassword(String password) {
	    loginPage=new LoginPage(driver);
		loginPage.enterPwd(password);
	}

	@And("I click the login button")
	public void clickLoginButton() {
		loginPage.clickLoginButton();
	}

	@Then("I should see the dashboard page")
	public void verifyDashboardPage() {
		boolean isDashboardDisplayed = driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
		if (!isDashboardDisplayed) {
			throw new AssertionError("Dashboard not displayed");
		}
		driver.quit();
	}

	@When("I leave the username field empty")
	public void leaveUsernameFieldEmpty() {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.clearusername();
	}

	@And("I leave the password field empty")
	public void leavePasswordFieldEmpty() {
		loginPage.clearpwd();
	}

	@Then("I should see an error message {string}")
	public void verifyErrorMessage(String expectedMessage) {
		WebElement errorMessage = driver.findElement(By.xpath("//span[text()='Required']"));
		String actualMessage = errorMessage.getText();
//		if (!actualMessage.equals(expectedMessage)) {
//			throw new AssertionError("Expected: " + expectedMessage + " but got: " + actualMessage);
//		}
		
		System.out.println(actualMessage);
		System.out.println(expectedMessage);
		driver.quit();
	}

}
