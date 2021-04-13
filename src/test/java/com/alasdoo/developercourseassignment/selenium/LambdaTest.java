package com.alasdoo.developercourseassignment.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTest {

	public RemoteWebDriver driver = null;
	String username = "jankogugleta";
	String accessKey = "xY7DopTEkKiJeMpTWI5iIRzDSE1Bq3Y9BgEWVEOzfcCvhlkdVo";

	
	public void lambdaTest() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platform", "Windows 10");
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("version", "87.0"); // If this cap isn't specified, it will just get the any
														// available one
		capabilities.setCapability("resolution", "1024x768");
		capabilities.setCapability("build", "First Test");
		capabilities.setCapability("name", "Sample Test");
		capabilities.setCapability("network", true); // To enable network logs
		capabilities.setCapability("visual", true); // To enable step by step screenshot
		capabilities.setCapability("video", true); // To enable video recording
		capabilities.setCapability("console", true); // To capture console logs
		driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"),
				capabilities);

		// Typing URL address
				driver.get("http://localhost:3000/");

				// Checking if HomePage is visible
				HomePage homePage = new HomePage(driver);
				assertTrue(homePage.isInitialized());
				//log.info("Home page is displayed");

				// Checking if table of students is visible
				TablePage tablePage = new TablePage(driver);
				assertTrue(tablePage.isInitialized());
				//log.info("List of students is empty");

				// Clicking plus button
				FormPage formPage = homePage.plusButon();
				assertTrue(formPage.isInitialized());
				//log.info("Form apeared");

				// User typing data
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				formPage.addStudent("Darko", "Markovic", "markomarkovic", "marko@gmail.com", "123123");
				// Forcing TablePage to refresh it's elements
				tablePage.refresh();
				assertEquals("Darko", tablePage.isStudentDisplayed("Darko"));
				//log.info("Student is added");
				
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				// Checking if edit form is visible
				EditPage editPage = new EditPage(driver);
				assertTrue(editPage.isInitialized());
				//log.info("Edit form is displayed");

				// User retyping name
				editPage.editStudent("Marko");
				// Forcing TablePage to refresh it's elements
				tablePage.refresh();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				assertEquals("Marko", tablePage.isStudentDisplayed("Marko"));
				//log.info("Student is edditet");

				// Deleting student
				editPage.deleteStudent();
				// Forcing TablePAge to refresh it's elements
				tablePage.refresh();
				assertNotEquals("Marko", tablePage.isStudentDisplayed("Marko"));
				//log.info("Student deleted");
				
				//withoutFailure = true;
			}
	

}