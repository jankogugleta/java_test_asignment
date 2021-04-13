package com.alasdoo.developercourseassignment.selenium;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPage extends PageObject{

	@FindBy(name = "name")
	private WebElement name;
	
	@FindBy(name="surname")
	private WebElement surname;

	@FindBy(name="accountName")
	private WebElement accountName;

	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="bankCardNumber")
	private WebElement bankCardNumber;
	
	@FindBy(css  = "button[data-test-id='save']")
	private WebElement saveButton;
	
	@FindBy(css  = "button[data-test-id='delete']")
	private WebElement deleteButton;
	
	@FindBy(css  = "button[data-test-id='courses']")
	private WebElement tooglecourses;
	
	public EditPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isInitialized() {
		return tooglecourses.isDisplayed();
	}
	
	public void editStudent(String name){
		//Comment next line with to cause test fail and generate screenshot
		this.name.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		this.name.sendKeys(name);
		this.saveButton.click();
	}
	
	public void deleteStudent(){
		this.deleteButton.click();
	}
		
	
}
