package dd_core;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.management.StringValueExp;

import org.apache.log4j.Logger;
import org.apache.poi.ss.formula.eval.StringValueEval;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import dd_util.Xls_Reader;

public class Page {

	public static WebDriver driver;
	public static Properties Config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Xls_Reader excel = new Xls_Reader(System.getProperty("user.dir")
			+ "//src//dd_properties//testdata.xlsx");
	public static Logger logs = Logger.getLogger("devpinoyLogger");

	@BeforeSuite
	public void init() throws IOException, AddressException, SQLException, ClassNotFoundException, MessagingException {

		if (driver == null) {

			fis = new FileInputStream(System.getProperty("user.dir") + "/src/dd_properties/Config.properties");
			Config.load(fis);
			logs.debug("Loaded the Config property file");

			fis = new FileInputStream(System.getProperty("user.dir") + "//src//dd_properties//OR.properties");
			OR.load(fis);
			logs.debug("loaded the OR property file");

			if (Config.getProperty("browser").equals("firefox")) {

				driver = new FirefoxDriver();
				logs.debug("Loaded Firefox");

			} else if (Config.getProperty("browser").equals("ie")) {

				System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			} else if (Config.getProperty("browser").equals("chrome")) {

				System.setProperty("webdriver.chrome.driver", "/usr/local/share/chromedriver");
				driver = new ChromeDriver();
			} else if (Config.getProperty("browser").equals("opera")) {
				new DesiredCapabilities();
				DesiredCapabilities c = DesiredCapabilities.operaBlink();
				c.setCapability("opera.binary", "/usr/local/share/operadriver");
				driver = new OperaDriver();
			}
			driver.manage().window().maximize();
			driver.get(Config.getProperty("testsiteurl"));
			driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
			// DbManager.setMysqlDbConnection();
		}

	}

	public static WebElement fluentWait(String key) throws IOException{
		WebDriverWait wait = new WebDriverWait(driver,30);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(key))));

	}
	public static void  Select(WebElement wE, int index) throws IOException{
		Select s =new Select(wE);
		s.selectByIndex(index);
	}

	public static void click(String key) {
		try {
			driver.findElement(By.xpath(OR.getProperty(key))).click();
		} catch (Throwable t) {
			
		}

	}

	public static void input(String key, String value) throws IOException {

		try {
			driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static WebElement findElement(String key) throws IOException {

		try {

			return driver.findElement(By.xpath(OR.getProperty(key)));

		} catch (Throwable t) {

			// TestUtil.CaptureScreenshot();
			return null;

		}

	}
	public static  void spanSelect(String key1, String key2, int i) throws IOException{
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(key1)+i+OR.getProperty(key2)))).click();
		
	}
	@AfterSuite
	public void QuitDriver() {

		// send mail
		// driver.quit();

	}

}
