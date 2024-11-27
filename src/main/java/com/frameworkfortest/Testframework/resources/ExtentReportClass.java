package com.frameworkfortest.Testframework.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportClass {
	
	public static ExtentReports reporting() {
		String pathString=System.getProperty("user.dir")+"//reports//index.html";
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(pathString);
		reporter.config().setDocumentTitle("Test Report");
		reporter.config().setReportName("Automation Test Report");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Pratiksha Ghotkar");
		return extent;
		
	}
	

}
