package com.frameworkfortest.Testframework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EndToEndTestCase {

	@Test
	public void LoginTest() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Login Page
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}
	
	@Test
	public void TableTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/tables");
		
		WebElement table = driver.findElement(By.id("table1"));
		
		
	     List<WebElement> dueColumn = table.findElements(By.xpath(".//tbody/tr/td[4]"));
         int totaldue = 0;
         for (WebElement salaryCell : dueColumn) {
        	 String text = salaryCell.getText();
        	 String substring = text.substring(1);
        	 String regex = "[,\\.\\s]";
        	 String[] split = substring.split(regex);
             int salary = Integer.parseInt(split[0]);
             System.out.println(salary);
             totaldue += salary;
         }
         System.out.println("Total Salary: " + totaldue);
		
		
		
	}
	
	
	@Test
	public void TestDropdown() {
		
	}

}
