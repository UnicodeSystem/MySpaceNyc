package dd_rough;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dd_util.TestUtil;

public class TestTitlewithTimestamp {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://facebook.com");

		String timestamp = TestUtil.generateTimeStamp();
		String title = driver.getTitle();

		System.out.println(timestamp + title);

		driver.getPageSource();

	}

}
