package automationTest.Scenario5;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;
import onlineShopping.Utilities.WebDrivers;
import onlineShopping.WebElements.Elements;

public class PurchasingProducts {
	
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
	public void tc025() {
		Elements.addProdToCart("bike-light").click();
		Elements.getAddToCartIcon().click();
		Elements.getCheckOut().click();
		Elements.setFirstName("Joon");
		Elements.setlastName("Kim");
		Elements.setpostalCode("43567");
		Elements.getContinue().click();
		Elements.getfinish().click();
		Assert.assertEquals("THANK YOU FOR YOUR ORDER", Elements.getSuccessMsg().getText());
	}
	
	@Test
	public void tc026() {
		Elements.addProdToCart("bike-light").click();
		Elements.addProdToCart("backpack").click();
		Elements.addProdToCart("bolt-t-shirt").click();
		Elements.getAddToCartIcon().click();
		Elements.getCheckOut().click();
		Elements.setFirstName("Joon");
		Elements.setlastName("Kim");
		Elements.setpostalCode("43567");
		Elements.getContinue().click();
		Elements.getfinish().click();
		Assert.assertEquals("THANK YOU FOR YOUR ORDER", Elements.getSuccessMsg().getText());
	}
	
	@Test
	public void tc027() {
		Elements.addProdToCart("bike-light").click();
		Elements.getAddToCartIcon().click();
		Elements.getCheckOut().click();
		Elements.getCancelBtn().click();
		Assert.assertEquals("Swag Labs", Elements.driver.getTitle());
	}
	
	//@Test
	public void tc028() {
		Elements.addProdToCart("bike-light").click();
		Elements.getAddToCartIcon().click();
		Elements.getCheckOut().click();
		Elements.setFirstName("Joon");
		Elements.setlastName("Kim");
		Elements.setpostalCode("43567");
		Elements.getContinue().click();
		Elements.getfinish().click();
		Assert.assertEquals("THANK YOU FOR YOUR ORDER", Elements.getSuccessMsg().getText());
	}
		
	@AfterMethod
	public void afterMethod() {
		WebDrivers.closeBrowser();
	}
	
	
}
