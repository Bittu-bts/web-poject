package Accademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Baseclass;

public class HomePage extends Baseclass {

	public static Logger log=LogManager.getLogger(Baseclass.class.getName());


	@Test(dataProvider="getData")
	public void basePageNavigaton(String Username, String Password,String text) throws IOException {

		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		LandingPage l= new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		//System.out.println(text);
		lp.getGo().click();
		log.info(text);
	}


	@DataProvider
	public Object[][] getData() {
		Object[][] data=new Object[2][3];
		data[0][0]="nonrestricted@gmail.com";
		data[0][1]="1234567";
		data[0][1]="Restricted User";

		data[1][0]="restricted@gmail.com";
		data[1][1]="1234567";
		data[1][2]="Non Restricted user";

		return data;
	}

	
}
