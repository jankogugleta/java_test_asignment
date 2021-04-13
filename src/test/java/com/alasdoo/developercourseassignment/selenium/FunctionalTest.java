package com.alasdoo.developercourseassignment.selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunctionalTest {
	
	protected static WebDriver driver;
	protected static Logger log = Logger.getLogger(FunctionalTest.class);
	protected WebDriverWait wait = new WebDriverWait(driver, 10);
	protected static boolean withoutFailure = false;

	@BeforeAll
	public static void setUp() {
		withoutFailure = false;
		
		log.info("Test started ");

		WebDriverManager.firefoxdriver().setup();
		//WebDriverManager.chromedriver().setup();
		//WebDriverManager.edgedriver().setup();
		
		driver = new FirefoxDriver();
		//driver = new FirefoxDriver();
		//driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterEach
	public void cleanUp() throws IOException {
		driver.manage().deleteAllCookies();
		if (!withoutFailure) {
			this.takeScreenShot(getClass().getName());
			log.info("Test "  + getClass().getName()  +" failed!!!!");
		} else {
			log.info("Test sussces");
		}
	}

	@AfterAll
	public static void tearDown() {
		driver.close();
	}
	
	public void takeScreenShot(String fileName) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File targetFile = new File("C:\\java_test_assignment\\Screenshots\\" + fileName + ".png");
		FileUtils.copyFile(scrFile, targetFile);
	}
}