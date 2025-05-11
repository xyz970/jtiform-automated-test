package helpers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Setup {
	
	private static WebDriver driver;
	private static DriverChoice driverChoice;
	Setup setup;

    public static WebDriver getDriver() {
        return driver;
    }
    
    public static DriverChoice getActiveDriver() {
    	return driverChoice;
    }
   

    @BeforeSuite
    public void beforeSuite() {
    	System.out.print("Testing Dimulai");
    	DriverChoice dChoice = DriverChoice.CHROME; 
		DriverHelper driverHelper = new DriverHelper();
		driver = driverHelper.setSelectedDriver(dChoice);
		driverChoice = dChoice;
    }

    @AfterSuite
    public void afterSuite() throws InterruptedException {
    	System.out.print("Testing Selesai");
        driver.quit();
    }
	
	
	public static String getParentDirectory() {
		String parentDir = "C:\\mydata\\testing\\testng-jtiform\\";
		return parentDir;
	}
	
	public static String getWebUrl() {
		return "http://project-jti.polije.ac.id/jtiform";
	}
}
