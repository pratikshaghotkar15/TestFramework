package com.frameworkfortest.Testframework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.frameworkfortest.Testframework.testcomponents.BaseTest;

public class ValidateLogin extends BaseTest {

	@Test(dataProvider = "getdata")
	public void LoginTest(String username, String password) throws IOException, InterruptedException {

		WebDriver driver = initBrowser();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginAction(username, password);

		Thread.sleep(2000);
		tearDown();

	}

	@DataProvider(name = "getdata")
	public Object[][] getdata() {
		return new Object[][] { { "Admin", "admin123" }, { "ghotkarpratiksha1513@gmail.comm", "Pratiksha@156" }

		};
	}

}
