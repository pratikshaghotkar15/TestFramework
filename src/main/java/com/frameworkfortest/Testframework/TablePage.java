package com.frameworkfortest.Testframework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TablePage {
	
	@FindBy(id =   "table1")
	private WebElement table;
	
	By column=By.xpath(".//tbody/tr/td[4]");
	
	public TablePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void validateDynamicTableData() {
		List<WebElement> dueColumn = table.findElements(column);
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
	
	

}
