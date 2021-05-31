package Academy;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base {
	public WebDriver driver;
	LandingPage l;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		log.info("Driver is initialized");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
	}

	@Test

	public void validateAppTitle() throws IOException {

		// one is inheritance
		// creating object to that class and invoke methods of it
		l = new LandingPage(driver);
		// compare the text from the browser with actual text.- Error..
		AssertJUnit.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated Text message");
		System.out.println("Test completed");

		;

	}

	@Test(priority = 1)
	public void validateAppHeader() throws IOException {

		// one is inheritance
		// creating object to that class and invoke methods of it
		// driver revive from above
		// compare the text from the browser with actual text.- Error..
		AssertJUnit.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING"); // landingpage
																											// css
		log.info("Successfully validated Text message");
		System.out.println("Test completed");

		// ("div[class*='video-banner'] h3")

	}

	@AfterTest
	public void teardown() {

		driver.close();

	}

}