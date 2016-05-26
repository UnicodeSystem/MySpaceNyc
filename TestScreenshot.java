package dd_rough;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestScreenshot {

	public static WebDriver driver;
	public static String mailscreenshotpath;

	public static void CaptureScreenshot() throws IOException {

		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH); // 3
		int year = cal.get(Calendar.YEAR); // 2014
		int sec = cal.get(Calendar.SECOND);
		int min = cal.get(Calendar.MINUTE);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.HOUR_OF_DAY);

		mailscreenshotpath = System.getProperty("user.dir") + "\\screenshots\\" + year + "_" + date + "_" + (month + 1)
				+ "_" + day + "_" + min + "_" + sec + ".jpeg";

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(mailscreenshotpath));

	}

	public static void main(String[] args) throws IOException {

		driver = new FirefoxDriver();
		driver.get("http://facebook.com");

		CaptureScreenshot();

	}

}
