package performance;

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

	@Test(priority = 7)
	public void printBukti() throws AWTException {
		WebDriver driver = Setup.getDriver();
		
		Reporter.log("Pengguna mengklik print bukti kuisioner");
		driver.get(Setup.getWebUrl()+"/login");
		inputForm("email", "e41212101@student.polije.ac.id");
		inputForm("password", "jtipolije");
		driver.findElement(By.cssSelector("button[class='btn btn-primary btn-block waves-effect waves-light']")).click();
		
		driver.findElement(By.cssSelector("a[data-tm-rule-kuisioner='data-tm-kuisioner-id=6']")).click();
//		driver.close();		
		
		
	}
	
	protected void inputForm(String inputName, String value) {
		WebDriver driver;
		driver = Setup.getDriver();
		driver.findElement(By.name(inputName)).sendKeys(value);
	}
}
