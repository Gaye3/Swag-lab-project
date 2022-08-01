package automationTest.Scenario3;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;
import onlineShopping.Utilities.WebDrivers;
import onlineShopping.WebElements.Elements;

public class FilteringProducts {

	@BeforeMethod
	@Parameters({"browser"})
	public void beforeMethod(String browser) {
		Elements.invokeBrowserOpenUrl(browser);
		Elements.setLocators();
		Elements.setUsername("standard_user");
		Elements.setPassword("secret_sauce");
		Elements.getLogin().click();
	}
	
	@Test(dataProvider="data")
	public void tc017(String val,String expected) {
		Elements.getFilterIcon().click();
		Elements.selectFilters(val);
		Assert.assertEquals(expected, Elements.getSelectBoxText().getText());
	}
	
	@DataProvider
	public Object[][] data(){
		return new Object[][] {
			{"az","NAME (A TO Z)"},{"za","NAME (Z TO A)"},{"lohi","PRICE (LOW TO HIGH)"},{"hilo","PRICE (HIGH TO LOW)"}
		};
	}
	
	@AfterMethod
	public void afterMethod() {
		WebDrivers.closeBrowser();
	}
}
