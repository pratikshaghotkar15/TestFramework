package com.frameworkfortest.Testframework.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src\\test\\java\\com\\frameworkfortest\\Testframework\\cucumber",
		glue = "com\\frameworkfortest\\Testframework\\stepdefination",
		monochrome = true,
		plugin = {"html:target/cucumber.html"}
		
		)
public class E2ERunner extends AbstractTestNGCucumberTests{

}
