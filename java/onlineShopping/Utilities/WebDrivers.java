package onlineShopping.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import onlineShopping.WebElements.Elements;

public class WebDrivers {
	
	public static WebDriver driver;
	
	public static WebDriver invokeBrowsers(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir") + "\\Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.saucedemo.com/");
		return driver;
	}
	
	public static void closeBrowser() {
		driver.quit();
	}
	
}
