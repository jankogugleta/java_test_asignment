package com.alasdoo.developercourseassignment.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageObject {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	private WebElement header = driver.findElement(By.xpath("/html/body/div/div//h6"));

	private WebElement plusButton = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/button"));
	
	public boolean isInitialized() {
		return header.isDisplayed();
	}

	public FormPage plusButon() {
		plusButton.click();
		return new FormPage(driver);
	}
}

