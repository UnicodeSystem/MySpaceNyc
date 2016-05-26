package dd_testcases;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import dd_core.Page;
import dd_util.TestUtil;

public class LoginTest extends Page {
	String expectedTitle = "Myspace | Log in";
	String actualTitle = "";
	boolean flag = false;
	public static String GlobalUsername;
	public int i;

	@BeforeTest
	public void isSkip() {
		do {
			flag = true;
			try {
				i = Integer.parseInt(JOptionPane.showInputDialog("Enter 1 for valid Login \n"
						+ "Enter 2 for login without credentials\n" + "Enter 3 for PreSpaces in email \n"
						+ "Enter 4 for Post spaces in email \n" + "Enter 5 for Forgot Password \n"));

			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
				flag = false;
			}
		} while (!flag);

		if (!TestUtil.isExecutable("LoginTest")) {

			throw new SkipException("Skipping the test as the Run mode is No");

		}

	}

	@Test(dataProvider = "getData")
	public void doLogin(String username, String password) throws IOException {
		if (i == 1 || i == 0) {
			logs.debug("Inside Login Test");

			findElement("username").sendKeys(username);
			findElement("password").sendKeys(password);
			findElement("login").click();
			// TestUtil.CaptureScreenshot();
			GlobalUsername = username;

		}
	}

	@Test
	public void doLoginWithoutCred() {
		if (i == 2) {
			{
				try {
					findElement("username").sendKeys("");
					findElement("password").sendKeys("");
					findElement("login").click();
					actualTitle = driver.getTitle();

					String Text = findElement("Inncoorect").getText();
					String ActualText = "Incorrect Username and Password.";

					// compare the actual title of the page with the expected
					// one and print
					// the result as "Passed" or "Failed"

					if (actualTitle.contentEquals(expectedTitle)) {
						System.out.println("Test Passed!");
					} else {
						System.out.println("Test Failed");
					}
					if (Text.contentEquals(ActualText)) {
						System.out.println("Validation Passed");
					} else {
						System.out.println("Validation Failed" + " " + Text);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Test(dataProvider = "getData")
	public void doLoginIdWithPreSpace(String username, String password) throws IOException {
		if (i == 3) {
			logs.debug("Inside Login Test");

			findElement("username").sendKeys(" " + username);
			findElement("password").sendKeys(password);
			findElement("login").click();
			// TestUtil.CaptureScreenshot();
			GlobalUsername = username;

		}
	}

	@Test(dataProvider = "getData")
	public void doLoginIdWithPostSpace(String username, String password) throws IOException {
		if (i == 4) {
			logs.debug("Inside Login Test");

			findElement("username").sendKeys(username + " ");
			findElement("password").sendKeys(password);
			findElement("login").click();
			// TestUtil.CaptureScreenshot();
			GlobalUsername = username;

		}
	}

	@Test(dataProvider = "getData")
	public void ForgotPass(String username, String password) throws IOException, InterruptedException {
		if (i == 5) {
			findElement("Forgot").click();
			Thread.sleep(100);
			findElement("email").sendKeys(username);
			findElement("submit").click();
			try {

				String TextMatch = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible"))
						.getText();
				String ToBeMatch = "Success";

				if (TextMatch.contains(ToBeMatch)) {
					// TestUtil.CaptureScreenshot();
					System.out.println("Test Case Passed " + TextMatch);
				} else
					System.out.println("Test case Faild " + TextMatch);
			} catch (Throwable t) {
				System.out.println(t);
			}
			GlobalUsername = username;
		}
	}

	@DataProvider
	public static Object[][] getData() {

		return TestUtil.getData("LoginTest");

	}

}
