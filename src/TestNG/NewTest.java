package TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NewTest {
	
	WebDriver driver;

	@BeforeSuite
	void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeTest
	void setupTest() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);
	}

	@AfterTest
	void teardown() {
		driver.quit();
	}

	@Test
	public void f() {


		driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
		String title = driver.getTitle();
		assertEquals(title, "Hands-On Selenium WebDriver with Java");
		

	}
}
