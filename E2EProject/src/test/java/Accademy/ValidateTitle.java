package Accademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Baseclass;

public class ValidateTitle extends Baseclass {
	
	public static Logger log=LogManager.getLogger(Baseclass.class.getName());
	
	@Test
	public void basePageNavigaton() throws IOException {
	
		driver=initializeDriver();
		log.info("Driver is initialize");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
		
		LandingPage l= new LandingPage(driver);
		
		Assert.assertEquals(l.getTitle().getText(), "FATURED COURSES");
		log.info("Successfully validated");
		
	}
	

}
