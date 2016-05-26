package dd_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.Page;
import dd_util.TestUtil;

public class FolderIdTest extends Page {
	LoginTest lt = new LoginTest();

	@BeforeClass
	public void SetUpFolderId() throws IOException {
		lt.i = 1;
		String username = TestUtil.excel.getCellData("LoginTest", 0, 2);
		String password = TestUtil.excel.getCellData("LoginTest", 1, 2);
		lt.doLogin(username, password);
		//findElement("FolderIdMore").click();
		//findElement("AddNewFolderId").click();
	}

	@Test //(dataProvider="data")
	public void AddNewFolderId(/*String rent, String offer, String moveInDate, String pAPercent, String numOfApplicant,
			//String numOfGar, String brokerFee, String llPercent, String mySpacePercent, String text*/) throws IOException, InterruptedException {

		driver.get(Config.getProperty("frameurl"));
		click("adress");
		click("td");
		//driver.navigate().back();
		//spanSelect("td1", "td2", 2);
		/*Select(fluentWait("department"), 0);
		Select(fluentWait("office"), 1);
		click("department");
		Select(fluentWait("adress"), 2);
		Select(fluentWait("brCount"), 2);
		Select(fluentWait("unitNum"), 2);
		Select(fluentWait("neighbour"), 2);
		input("rent", "");
		input("offer", "");
		input("moveInDate", "");
		Select(fluentWait("pAgent"), 2);
		input("pAgentPercent", "");
		Select(fluentWait("agentTwo"), 2);
		Select(fluentWait("manager"), 2);
		Select(fluentWait("closingManager"), 2);
		Select(fluentWait("status"), 2);
		input("numOfApplicants", "");
		input("numOfGuarantor", "");
		Select(fluentWait("firstMonth"), 2);
		Select(fluentWait("lastMonth"), 2);
		Select(fluentWait("security"), 2);
		input("brokerFee", "");
		Select(fluentWait("llCode"), 2);
		input("llPercent", "");
		input("mySpacePercent", "");
		input("notes", "");
*/
	}

	@DataProvider
	public static Object[][] data() {
		return TestUtil.getData("ZohoDb");

	}
}