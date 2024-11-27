package com.frameworkfortest.Testframework;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ValidateDynamicTable {

	@Test
	public void TableTest() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/tables");
		
		TablePage tablePage=new TablePage(driver);
		tablePage.validateDynamicTableData();
		
		

	}

}
