package functionalities;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class PrintTest {

	@Test(priority = 2, dependsOnGroups = "afterKuisioner", groups = "afterPrint")
	public void printBukti() throws AWTException {
		WebDriver driver = Setup.getDriver();
		
		Reporter.log("Pengguna mengklik print bukti kuisioner");
		
		driver.get(Setup.getWebUrl() + "/student");
		
		driver.findElement(By.cssSelector("a[data-tm-rule-kuisioner='data-tm-kuisioner-id=6']")).click();
		
		Set<String> windowSet = driver.getWindowHandles();
		
		System.err.println(windowSet.size());
		System.err.println(windowSet.toString());
		
//		driver.close();		
		
		
		assertTrue(windowSet.size() > 1);
		
	}
}
