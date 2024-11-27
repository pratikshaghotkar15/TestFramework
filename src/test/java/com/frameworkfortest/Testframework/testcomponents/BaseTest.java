package com.frameworkfortest.Testframework.testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	public static WebDriver driver;

	public static WebDriver initBrowser() throws IOException {
		FileInputStream fis = new FileInputStream(
				"D:\\QA\\Testframework\\src\\main\\java\\com\\frameworkfortest\\Testframework\\resources\\properties.properties");
		Properties prop = new Properties();
		prop.load(fis);
		// String browsername = prop.getProperty("browser");
		String browsername = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String baseUrl = prop.getProperty("baseUrl");
		driver.get(baseUrl);
		return driver;
	}

	
	public static void tearDown() {
		driver.close();
	}
}
