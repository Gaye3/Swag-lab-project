package automationTest.Scenario4;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;
import onlineShopping.Utilities.WebDrivers;
import onlineShopping.WebElements.Elements;

public class AddToCart {
	
	@BeforeMethod
	@Parameters({"browser"})
	public void beforeMethod(String browser) {
		Elements.invokeBrowserOpenUrl(browser);
		Elements.setLocators();
		Elements.setUsername("standard_user");
		Elements.setPassword("secret_sauce");
		Elements.getLogin().click();
	}
	
	@Test
	public void tc021() {
		Elements.selectProduct("0").click();
		Elements.waitSomeTime(2);
		Elements.addProdToCart("bike-light").click();
		Assert.assertEquals("1", Elements.getCartCount().getText());
	}
	
	@Test
	public void tc022() {
		Elements.selectProduct("0").click();
		Elements.waitSomeTime(2);
		Elements.addProdToCart("bike-light").click();
		Elements.removeProd("bike-light").click();
	}
	
	@Test
	public void tc023() {
		Elements.addProdToCart("bike-light").click();
		Elements.getAddToCartIcon().click();
		Elements.removeProd("bike-light").click();
	}
	
	@Test
	public void tc024() {
		Elements.addProdToCart("bike-light").click();
		Elements.addProdToCart("backpack").click();
		Assert.assertEquals("2", Elements.getCartCount().getText());
	}
		
	@AfterMethod
	public void afterMethod() {
		WebDrivers.closeBrowser();
	}
	
}
