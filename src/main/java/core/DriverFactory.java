package core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private WebDriver driver = null;
	

	public WebDriver getDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();			
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(Config.getProperty("pageLoadTimeout"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(Config.getProperty("implicitWait"))));
		return driver;
	}
	
	
	public void quitDriver() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
}
