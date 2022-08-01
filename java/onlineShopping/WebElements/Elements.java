package onlineShopping.WebElements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import onlineShopping.Utilities.WebDrivers;

public class Elements{
	
	public static WebDriver driver;
	static Properties prop;
	
	public static WebDriver invokeBrowserOpenUrl(String browserName) {
		driver = WebDrivers.invokeBrowsers(browserName);
		return driver;
	}
	
	public static void waitSomeTime(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void setLocators() {
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\Locators.properties");
			prop = new Properties();
			prop.load(file);
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void setUsername(String name) {
		 driver.findElement(By.id(prop.getProperty("username_Id"))).sendKeys(name);
	}
	
	public static WebElement getUsername() {
		 return driver.findElement(By.id(prop.getProperty("username_Id")));
	}
	
	public static void setPassword(String password) {
		 driver.findElement(By.id(prop.getProperty("password_Id"))).sendKeys(password);
	}
	
	public static WebElement getPassword() {
		 return driver.findElement(By.id(prop.getProperty("password_Id")));
	}
	
	public static WebElement getLogin() {
		 return driver.findElement(By.id(prop.getProperty("login_Id")));
	}
	
	public static String getErrorMsg() {
		return driver.findElement(By.xpath(prop.getProperty("errorMsg_Xpath"))).getText();
	}
	
	//------------------------------------------------------
	public static WebElement getFilterIcon() {
		return driver.findElement(By.xpath(prop.getProperty("filterIcon_Xpath")));
	}
	
	public static WebElement getAddToCartIcon() {
		return driver.findElement(By.xpath(prop.getProperty("addToCartIcon_Xpath")));
	}
	
	public static WebElement getHamburgerIcon() {
		return driver.findElement(By.id(prop.getProperty("hamburgerIcon_Id")));
	}
	
	public static WebElement getAboutUs() {
		return driver.findElement(By.id(prop.getProperty("aboutUs_Id")));
	}
	
	public static WebElement getLogout() {
		return driver.findElement(By.id(prop.getProperty("logout_Id")));
	}
	
	public static WebElement getBackToProducts() {
		return driver.findElement(By.id(prop.getProperty("backProd_Id")));
	}
	public static void selectFilters(String value) {
		Select select = new Select(Elements.getFilterIcon());
		select.selectByValue(value);
	}
	
	public static WebElement getSelectBoxText() {
		return driver.findElement(By.xpath(prop.getProperty("selectBox_Xpath")));
	}
	
	public static WebElement selectProduct(String prodNum) {
		return driver.findElement(By.xpath("//*[@id='item_"+prodNum+"_title_link']/div"));
	}
	
	public static WebElement addProdToCart(String prodName) {
		return driver.findElement(By.id("add-to-cart-sauce-labs-"+prodName));
	}
	
	public static WebElement getCartCount() {
		return driver.findElement(By.xpath(prop.getProperty("cartCount_Xpath")));
	}
	
	public static WebElement removeProd(String prodName) {
		return driver.findElement(By.id("remove-sauce-labs-"+prodName));
	}
	
	//--------------------------------------------------------------------------
	
	public static WebElement getContinueShopping() {
		return driver.findElement(By.id(prop.getProperty("continue_Id")));
	}
	
	public static WebElement getCheckOut() {
		return driver.findElement(By.id(prop.getProperty("checkout_Id")));
	}
	
	public static void setFirstName(String name) {
		driver.findElement(By.id(prop.getProperty("firstname_Id"))).sendKeys(name);
	}
	
	public static void setlastName(String name) {
		driver.findElement(By.id(prop.getProperty("lastname_Id"))).sendKeys(name);
	}
	
	public static void setpostalCode(String code) {
		driver.findElement(By.id(prop.getProperty("postal_Id"))).sendKeys(code);
	}
	
	public static WebElement getCancelBtn() {
		return driver.findElement(By.id(prop.getProperty("cancel_Id")));
	}
	
	public static WebElement getContinue() {
		return driver.findElement(By.id(prop.getProperty("continue_Id")));
	}
	
	public static WebElement getfinish() {
		return driver.findElement(By.id(prop.getProperty("finish_Id")));
	}
	
	public static WebElement getbackHome() {
		return driver.findElement(By.id(prop.getProperty("backProd_Id")));
	}
	
	public static WebElement getSuccessMsg() {
		return driver.findElement(By.xpath(prop.getProperty("successMsg_Xpath")));
	}
	
	
}
 