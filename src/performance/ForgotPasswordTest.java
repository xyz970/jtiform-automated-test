package performance;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import helpers.Setup;

public class ForgotPasswordTest {
  
//  @Test(priority = 5,groups = "afterForgotPassword")
  @Test(dependsOnGroups = "afterLogout",priority = 5,groups = "afterForgotPassword")
  public void forgotPassword() throws InterruptedException {
	  WebDriver driver = Setup.getDriver();
	  String emailArray[] = {"","gmail@gmail.com","e41212101@student.polije.ac.id"};
	  driver.findElement(By.partialLinkText("Forgot your password?")).click();
	  for (String email : emailArray) {
		  driver.findElement(By.name("email")).clear();
		  driver.findElement(By.name("email")).sendKeys(email);
		  driver.findElement(By.cssSelector("button[type='submit']")).click();
		  Thread.sleep(2000);
	}
//	  assertTrue(driver.findElements(By.cssSelector("div[class='font-medium text-sm text-green-600 mb-4']")).size() > 0);
	  driver.get(Setup.getWebUrl()+"/login");
	  
  }
}
