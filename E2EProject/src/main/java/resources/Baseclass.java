package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Baseclass {


	public static WebDriver driver;
	public Properties prop;
	public ExtentReports extent;
	public ExtentSparkReporter	spark;

	public Baseclass() {
	    spark  = new ExtentSparkReporter("Bittu\\index.html");
	    extent = new ExtentReports();
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("1ExetentforE2E");
		spark.config().setReportName("E2EExtentreport");
		extent.attachReporter(spark);
	}

	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\vivek\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);

		String browserName=prop.getProperty("browser");

		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vivek\\Documents\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();

		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\vivek\\Documents\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\vivek\\Documents\\edgedriver_win64\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public void getScreenshot(String result) throws IOException {
		// TODO Auto-generated method stub
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\vivek\\eclipse-workspace\\E2EProject\\snapshot\\"+result+"screnshot.png"));
	}

} //(src, new File("D:\\test\\screnshot.png"));
