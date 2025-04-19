package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverHelper {

	WebDriver selectedDriver;
	WebDriver chromeDriver;
	WebDriver firefoxDriver;
	WebDriver edgeDriver;

	public WebDriver getSelectedDriver() {
		return selectedDriver;
	}

	public WebDriver setSelectedDriver(DriverChoice driverChoice) {
		switch (driverChoice) {
		case FIREFOX: {
			return firefoxDriver();
		}
		case CHROME:{
			return chromeDriver();
		}
		case MSEDGE:{
			return msEdgeDriver();
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + driverChoice);
		}
	}

	private WebDriver chromeDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}

	private WebDriver firefoxDriver() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}

	private WebDriver msEdgeDriver() {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		return driver;
	}

}


