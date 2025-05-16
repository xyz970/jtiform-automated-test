package performance;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class LoginTest {

	/**
	 * User melakukan login tanpa input field Email dan Password, dan tidak menandai checkbox Remember Me
	 */
	@Test(priority = 1,dependsOnGroups = "afterBruteforceScenario")
	public void loginEmptyInputWithUnchecked() {
		WebDriver driver;
		driver = Setup.getDriver();
		driver.get(Setup.getWebUrl()+"/login");
		inputForm("email", "");
		inputForm("password", "");
		driver.findElement(By.cssSelector("button[class='btn btn-primary btn-block waves-effect waves-light']")).click();
		Reporter.log("User melakukan login tanpa input field Email dan Password, dan tidak menandai checkbox Remember Me");
//		assertWhenNotRedirected();
	}
	
	/**
	 * User melakukan login tanpa input field Email dan Password, dan menandai checkbox Remember Me
	 */
	@Test(priority = 1,dependsOnMethods = "loginEmptyInputWithUnchecked")
	public void loginEmptyInputWithChecked() {
		WebDriver driver;
		driver = Setup.getDriver();
		driver.get(Setup.getWebUrl()+"/login");
		inputForm("email", "");
		inputForm("password", "");
		driver.findElement(By.className("custom-control-label")).click();
		driver.findElement(By.cssSelector("button[class='btn btn-primary btn-block waves-effect waves-light']")).click();
		Reporter.log("User melakukan login tanpa input field Email dan Password, dan menandai checkbox Remember Me");
//		assertWhenNotRedirected();
	}
	
	/**
	 * User melakukan login dengan input field Email dan mengosongkan field Password, serta tidak menandai checkbox Remember Me
	 */
	@Test(priority = 1,dependsOnMethods = "loginEmptyInputWithChecked")
	public void loginOnlyEmailInputWithUnChecked() {
		WebDriver driver;
		driver = Setup.getDriver();
		driver.get(Setup.getWebUrl()+"/login");
		inputForm("email", "e41212101@student.polije.ac.id");
		inputForm("password", "");
		driver.findElement(By.cssSelector("button[class='btn btn-primary btn-block waves-effect waves-light']")).click();
		Reporter.log("User melakukan login dengan input field Email dan mengosongkan field Password, serta tidak menandai checkbox Remember Me");
//		assertWhenNotRedirected();
	}
	
	/**
	 * User melakukan login dengan input field Email dan mengosongkan field Password, serta tidak menandai checkbox Remember Me
	 */
	@Test(priority = 1,dependsOnMethods = "loginOnlyEmailInputWithUnChecked")
	public void loginOnlyEmailInputWithChecked() {
		WebDriver driver;
		driver = Setup.getDriver();
		driver.get(Setup.getWebUrl()+"/login");
		inputForm("email", "e41212101@student.polije.ac.id");
		inputForm("password", "");
		driver.findElement(By.className("custom-control-label")).click();
		driver.findElement(By.cssSelector("button[class='btn btn-primary btn-block waves-effect waves-light']")).click();
		Reporter.log("User melakukan login dengan input field Email dan mengosongkan field Password, serta tidak menandai checkbox Remember Me");
//		assertWhenNotRedirected();
	}
	
	
	/**
	 * User melakukan login dengan input field Password dan mengosongkan field Email, serta tidak menandai checkbox Remember Me
	 */
	@Test(priority = 1,dependsOnMethods = "loginOnlyEmailInputWithChecked")
	public void loginOnlyPasswordInputWithUnchecked() {
		WebDriver driver;
		driver = Setup.getDriver();
		driver.get(Setup.getWebUrl()+"/login");
		inputForm("email", "");
		inputForm("password", "jtipolije");
		driver.findElement(By.cssSelector("button[class='btn btn-primary btn-block waves-effect waves-light']")).click();
		Reporter.log("User melakukan login dengan input field Password dan mengosongkan field Email, serta tidak menandai checkbox Remember Me");
//		assertWhenNotRedirected();
	}
	
	/**
	 *  User melakukan login dengan input field Password dan mengosongkan field Email, serta menandai checkbox Remember Me
	 */
	@Test(priority = 1,dependsOnMethods = "loginOnlyPasswordInputWithUnchecked")
	public void loginOnlyPasswordInputWithChecked() {
		WebDriver driver;
		driver = Setup.getDriver();
		driver.get(Setup.getWebUrl()+"/login");
		inputForm("email", "");
		inputForm("password", "jtipolije");
		driver.findElement(By.className("custom-control-label")).click();
		driver.findElement(By.cssSelector("button[class='btn btn-primary btn-block waves-effect waves-light']")).click();
		Reporter.log("User melakukan login dengan input field Password dan mengosongkan field Email, serta menandai checkbox Remember Me");
//		assertWhenNotRedirected();
	}
	
	/**
	 * User melakukan login dengan input field Email dan Password menggunakan data yang tidak sesuai (invalid), dan tidak menandai checkbox Remember Me
	 */
	@Test(priority = 1,dependsOnMethods = "loginOnlyPasswordInputWithChecked")
	public void loginInvalidInputWithUnchecked() {
		WebDriver driver;
		driver = Setup.getDriver();
		driver.get(Setup.getWebUrl()+"/login");
		inputForm("email", "ekputri21@gmail.com");
		inputForm("password", "ekaputri21");
		driver.findElement(By.cssSelector("button[class='btn btn-primary btn-block waves-effect waves-light']")).click();
		Reporter.log("User melakukan login dengan input field Email dan Password menggunakan data yang tidak sesuai (invalid), dan tidak menandai checkbox Remember Me");
//		assertWhenNotRedirected();
	}
	
	/**
	 * User melakukan login dengan input field Email dan Password menggunakan data yang tidak sesuai (invalid), dan menandai checkbox Remember Me
	 */
	@Test(priority = 1,dependsOnMethods = "loginInvalidInputWithUnchecked")
	public void loginInvalidInputWithChecked() {
		WebDriver driver;
		driver = Setup.getDriver();
		driver.get(Setup.getWebUrl()+"/login");
		inputForm("email", "ekputri21@gmail.com");
		inputForm("password", "ekaputri21");
		driver.findElement(By.className("custom-control-label")).click();
		driver.findElement(By.cssSelector("button[class='btn btn-primary btn-block waves-effect waves-light']")).click();
		Reporter.log("User melakukan login dengan input field Email dan Password menggunakan data yang tidak sesuai (invalid), dan menandai checkbox Remember Me");
//		assertWhenNotRedirected();
	}
	
	
	
	
	/**
	 * User melakukan login dengan input field Email dan Password menggunakan data yang sesuai (valid), dan menandai checkbox Remember Me
	 */
	@Test(priority = 1,dependsOnMethods = "loginInvalidInputWithChecked")
	public void loginValidInputWithChecked() {
		WebDriver driver;
		driver = Setup.getDriver();
		driver.get(Setup.getWebUrl()+"/login");
		inputForm("email", "e41212101@student.polije.ac.id");
		inputForm("password", "jtipolije");
		driver.findElement(By.className("custom-control-label")).click();
		driver.findElement(By.cssSelector("button[class='btn btn-primary btn-block waves-effect waves-light']")).click();
		Reporter.log("User melakukan login dengan input field Email dan Password menggunakan data yang sesuai (valid), dan menandai checkbox Remember Me");
		
	}
	
	/**
	 * User melakukan login dengan input field Email dan Password menggunakan data yang sesuai (valid), dan tidak menandai checkbox Remember Me
	 */
	@Test(groups = "mustLogin",priority = 1,dependsOnMethods = "loginValidInputWithChecked")
	public void loginValidInputWithUnchecked() {
		WebDriver driver;
		driver = Setup.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("i[class='mdi mdi-power text-danger']"))));
		logout.click();
//		driver.findElement(By.cssSelector("i[class='mdi mdi-power text-danger']")).click();
		inputForm("email", "e41212101@student.polije.ac.id");
		inputForm("password", "jtipolije");
		driver.findElement(By.cssSelector("button[class='btn btn-primary btn-block waves-effect waves-light']")).click();
		Reporter.log("User melakukan login dengan input field Email dan Password menggunakan data yang sesuai (valid), dan tidak menandai checkbox Remember Me");
	}
	
	
	protected void inputForm(String inputName, String value) {
		WebDriver driver;
		driver = Setup.getDriver();
		driver.findElement(By.name(inputName)).sendKeys(value);
	}
	
	protected void assertWhenNotRedirected() {
		WebDriver driver;
		driver = Setup.getDriver();
		assertTrue(driver.getCurrentUrl().equals(Setup.getWebUrl()+"/login"));
	}
	
}
