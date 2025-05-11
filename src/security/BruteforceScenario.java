package security;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class BruteforceScenario {

	@Test(priority = 1, groups = "afterBruteforceScenario")
	public void bruteforceTest() throws InterruptedException, IOException {
		Reporter.log("Lakukan pengetesan bruteforce");
		WebDriver driver;
		driver = Setup.getDriver();
		driver.get(Setup.getWebUrl() + "/login");
		for (int i = 0; i < getEmailCreds().size(); i++) {
			

			inputForm("email", getEmailCreds().get(i));
			inputForm("password", "sjdkashdkjashkjrandom");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(driver
					.findElement(By.cssSelector("button[class='btn btn-primary btn-block waves-effect waves-light']"))));
			btn.click();
			Thread.sleep(1000);

			clearInputForm("email");
			clearInputForm("password");

		}

	}

	protected void inputForm(String inputName, String value) {
		WebDriver driver;
		driver = Setup.getDriver();
		driver.findElement(By.name(inputName)).sendKeys(value);
	}

	protected void clearInputForm(String inputName) {
		WebDriver driver;
		driver = Setup.getDriver();
		driver.findElement(By.name(inputName)).clear();
	}

	private List<String> getEmailCreds() throws IOException {
		String path = Setup.getParentDirectory() + "files\\emailCreds.txt";
		List<String> allLines = Files.readAllLines(Paths.get(path));
		return allLines;
	}
}
