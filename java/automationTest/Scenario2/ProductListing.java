package automationTest.Scenario2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;
import onlineShopping.Utilities.WebDrivers;
import onlineShopping.WebElements.Elements;

public class ProductListing {

	@BeforeMethod
	@Parameters({"browser"})
	public void beforeMethod(String browserN) {
		Elements.invokeBrowserOpenUrl(browserN);
		Elements.setLocators();
		Elements.setUsername("standard_user");
		Elements.setPassword("secret_sauce");
		Elements.getLogin().click();
	}
	
	@Test(dataProvider = "data")
	public void tc013(String prodNum) {
		Assert.assertEquals(true, Elements.selectProduct(prodNum).isDisplayed());
	}
	
	@Test(dataProvider = "data")
	public void tc014(String prodNum) {
		Elements.selectProduct(prodNum).click();
		Assert.assertEquals(true, Elements.getBackToProducts().isDisplayed());
	}
	
	@DataProvider
	public Object[][] data(){
		return new Object[][] {
				{"0"},{"1"},{"2"},{"3"},{"4"}
		};
	}
	
	@Test
	public void tc015() {
		Elements.waitSomeTime(5);
		Elements.getHamburgerIcon().click();
		Elements.waitSomeTime(2);
		Elements.getAboutUs().click();
		Elements.waitSomeTime(2);
		Assert.assertEquals("Cross Browser Testing, Selenium Testing, Mobile Testing | Sauce Labs", Elements.driver.getTitle());
	}
	
	@Test
	public void tc016() {
		Elements.waitSomeTime(5);
		Elements.getHamburgerIcon().click();
		Elements.waitSomeTime(2);
		Elements.getLogout().click();
		Elements.waitSomeTime(2);
		Assert.assertEquals("Swag Labs", Elements.driver.getTitle());
	}
	
	@AfterMethod
	public void afterMethod() {
		WebDrivers.closeBrowser();
	}
}
