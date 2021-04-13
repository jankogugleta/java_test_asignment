package com.alasdoo.developercourseassignment.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StudentCrudTest extends FunctionalTest {

	@Test
	public void studentCrudTest() throws IOException {
		// Typing URL address
		driver.get("http://localhost:3000/");

		// Waiting for web application to load
		assertTrue(wait.until(ExpectedConditions.urlToBe("http://localhost:3000/student")));
		log.info(driver.getCurrentUrl());

		// Checking if HomePage is visible
		HomePage homePage = new HomePage(driver);
		assertTrue(homePage.isInitialized());
		log.info("Home page is displayed");

		// Checking if table of students is visible
		TablePage tablePage = new TablePage(driver);
		assertTrue(tablePage.isInitialized());
		log.info("List of students is empty");

		// Clicking plus button
		FormPage formPage = homePage.plusButon();
		assertTrue(formPage.isInitialized());
		log.info("Form apeared");

		// User typing data
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		formPage.addStudent("Darko", "Markovic", "markomarkovic", "marko@gmail.com", "123123");
		// Forcing TablePage to refresh it's elements
		tablePage.refresh();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		assertEquals("Darko", tablePage.isStudentDisplayed("Darko"));
		log.info("Student is added");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Checking if edit form is visible
		EditPage editPage = new EditPage(driver);
		assertTrue(editPage.isInitialized());
		log.info("Edit form is displayed");

		// User retyping name
		editPage.editStudent("Marko");
		// Forcing TablePage to refresh it's elements
		tablePage.refresh();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		assertEquals("Marko", tablePage.isStudentDisplayed("Marko"));
		log.info("Student is edditet");

		// Deleting student
		editPage.deleteStudent();
		// Forcing TablePAge to refresh it's elements
		tablePage.refresh();
		assertNotEquals("Marko", tablePage.isStudentDisplayed("Marko"));
		log.info("Student deleted");
		
		withoutFailure = true;
	}

}
