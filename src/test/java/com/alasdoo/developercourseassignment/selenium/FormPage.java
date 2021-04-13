package com.alasdoo.developercourseassignment.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage extends PageObject{

	public FormPage(WebDriver driver) {
		super(driver);
	}
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
	private WebElement saveButton;// = driver.findElement(By.cssSelector("button[data-test-id='save']"));
	
	public boolean isInitialized() {
		return name.isDisplayed();
	}

	public void addStudent(String name, String surname, String accountName, String email, String bankCardNumber ){
		this.name.clear();
		this.name.sendKeys(name);
		this.surname.clear();
		this.surname.sendKeys(surname);
		this.accountName.clear();
		this.accountName.sendKeys(accountName);
		this.email.clear();
		this.email.sendKeys(email);
		this.bankCardNumber.clear();
		this.bankCardNumber.sendKeys(bankCardNumber);
		this.saveButton.click();
	}
	
	
	
}
