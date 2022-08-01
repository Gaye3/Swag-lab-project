package automationTest.Scenario1;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;
import onlineShopping.Utilities.WebDrivers;
import onlineShopping.WebElements.Elements;

public class LoginFuntionality {
	
	//We can extend LoginPage class or create static methods to access LoginPage objects and methods
	
	@BeforeMethod
	@Parameters({"browser"})
	public void beforeMethod(String browser) {
		Elements.invokeBrowserOpenUrl(browser);
		Elements.setLocators();
	}
	
	@Test
	public void tc001() {
		Elements.setUsername("standard_user");
		Elements.setPassword("secret_sauce");
		Elements.getLogin().click();
		Assert.assertEquals("Swag Labs", Elements.driver.getTitle());
	}
	
	@Test
	public void tc002() {
		Elements.setUsername("standard_user");
		Elements.setPassword("secret");
		Elements.getLogin().click();
		Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", Elements.getErrorMsg());
	}
	
	@Test
	public void tc003() {
		Elements.setUsername("standard");
		Elements.setPassword("secret_sauce");
		Elements.getLogin().click();
		Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", Elements.getErrorMsg());
	}
	
	@Test
	public void tc004() {
		Elements.setUsername("");
		Elements.setPassword("");
		Elements.getLogin().click();
		Assert.assertEquals("Epic sadface: Username is required", Elements.getErrorMsg());
	}
	
	@Test
	public void tc005() {
		String type = Elements.getPassword().getAttribute("type");
		Assert.assertEquals("password",type);
	}
	
	@Test
	public void tc008() {
		Elements.setUsername("standard_user");
		Elements.setPassword("secret_sauce");
		Elements.getLogin().sendKeys(Keys.ENTER);
		Assert.assertEquals("Swag Labs", Elements.driver.getTitle());
	}
	
	@Test
	public void tc011() {
		Elements.setUsername("standard_user");
		Elements.setPassword("secret_sauce");
		Elements.getLogin().click();
		Elements.driver.navigate().back();
		Assert.assertEquals("Swag Labs", Elements.driver.getTitle());
	}
	
	@AfterMethod
	public void afterMethod() {
		WebDrivers.closeBrowser();
	}
}
