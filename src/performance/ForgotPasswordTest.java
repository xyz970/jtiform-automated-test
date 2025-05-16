package performance;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import helpers.Setup;

public class ForgotPasswordTest {
  
  @Test(dependsOnGroups = "afterLogout",priority = 5,groups = "afterForgotPassword")
  public void forgotPassword() {
	  WebDriver driver = Setup.getDriver();
	  driver.findElement(By.partialLinkText("Forgot your password?")).click();
	  driver.findElement(By.name("email")).sendKeys("e41212101@student.polije.ac.id");
	  driver.findElement(By.cssSelector("button[type='submit']")).click();
//	  assertTrue(driver.findElements(By.cssSelector("div[class='font-medium text-sm text-green-600 mb-4']")).size() > 0);
	  driver.get(Setup.getWebUrl()+"/login");
	  
  }
}
