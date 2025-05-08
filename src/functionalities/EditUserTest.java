package functionalities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class EditUserTest {

	@Test(dependsOnGroups = "mustLogin", priority = 2, groups = "afterEditUser")
	public void updateProfile() throws InterruptedException {
		WebDriver driver = Setup.getDriver();
		
		Reporter.log("Pengguna mengunjungi halaman Edit User ");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// klik avatar di pojok kanan atas
		driver.findElement(By.cssSelector("a[data-toggle='dropdown']")).click();

		// kunjungi halaman profile
		driver.findElement(By.partialLinkText("Profile")).click();

		// hapus gambar yang ada
		js.executeScript("$('.fileinput-remove').trigger('click');");

		// kirim gambar
		driver.findElement(By.id("foto")).sendKeys(Setup.getParentDirectory() + "files\\profile.jpeg");

		// clear input
		driver.findElement(By.name("nim")).clear();
		driver.findElement(By.name("nama")).clear();
		driver.findElement(By.name("no_hp")).clear();

		// update input
		driver.findElement(By.name("nim")).sendKeys("E41212101edited");
		driver.findElement(By.name("nama")).sendKeys("EKA PUTRI YULIANA".toLowerCase());
		driver.findElement(By.name("no_hp")).sendKeys("081225417493");

		// input password lama
		String passwordLama = "jtipolije";
		driver.findElement(By.name("passwordLama")).click();
		driver.findElement(By.name("passwordLama")).clear();
		for (int i = 0; i < passwordLama.length(); i++) {
			driver.findElement(By.name("passwordLama")).sendKeys(passwordLama.charAt(i) + "");
		}

		String passwordBaru = "jtipolije";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		// password harus sama dengan password_confirmation
		js.executeScript("arguments[0].scrollIntoView(true);", passwordElement);
		passwordElement.click();
		passwordElement.clear();
		for (int i = 0; i < passwordBaru.length(); i++) {
			driver.findElement(By.name("password")).sendKeys(passwordBaru.charAt(i) + "");
		}

		driver.findElement(By.name("password_confirmation")).click();
		driver.findElement(By.name("password_confirmation")).sendKeys("jtipolije");

		// Submit Form
		driver.findElement(By.id("btnSubmit")).click();

	}
}
