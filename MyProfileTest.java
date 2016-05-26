package dd_testcases;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.Page;
import dd_util.TestUtil;

public class MyProfileTest extends Page {

	LoginTest Lt = new LoginTest();

	@BeforeTest
	public void isSkip() {

		if (!TestUtil.isExecutable("MyProfileTest")) {

			throw new SkipException("Skipping the test as the Run mode is No");

		}

	}

	/*@Test(dataProvider = "getData")
	public void gotoProfile(String name) throws IOException {

		findElement("profile").click();
		System.out.println(LoginTest.GlobalUsername);

	}

	@DataProvider
	public static Object[][] getData() {

		return TestUtil.getData("MyProfileTest");

	}
*/
}
