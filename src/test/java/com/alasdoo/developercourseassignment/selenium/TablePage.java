package com.alasdoo.developercourseassignment.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TablePage extends PageObject {

	public TablePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div[class='MuiDataGrid-mainGridContainer']")
	private WebElement table;

	@FindBy(css = "div[data-field='name']")
	List<WebElement> allCells;


	public boolean isInitialized() {
		return (table.isDisplayed());
	}
	
	public void refresh() {
		List<WebElement> allCells = driver.findElements(By.cssSelector("div[data-field='name']")); 

	}

	public String isStudentDisplayed(String text) {
		List<WebElement> allCells = driver.findElements(By.cssSelector("div[data-field='name']")); 
		for (WebElement cell : allCells) {
			if (text.equals(cell.getText())) {
				return cell.getText();
			}
		}
		return null;
	}
}
