package performance;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import helpers.Setup;

public class DashboardTest {

	@Test(dependsOnGroups = "afterKuisioner", priority = 3)
	public void pageHistory() throws InterruptedException {
		WebDriver driver = Setup.getDriver();
		Thread.sleep(2000);
		Reporter.log("Pengguna mengunjungi halaman history");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("a[title='History']"))))
				.click();
		boolean check = driver.getCurrentUrl().contains("History");
		assertTrue(check);
	}

	@Test(dependsOnGroups = "mustLogin", priority = 3, dependsOnMethods = "pageHistory")
	public void lockFeature() {
		WebDriver driver = Setup.getDriver();

		Reporter.log("Pengguna mengklik icon Gembok");

		driver.findElement(By.cssSelector("i[class='mdi mdi-lock text-warning']")).click();
		// cek apakah tombol tidak melakukan fungsi apapun
		boolean check = driver.getCurrentUrl().contains("#");
		assertTrue(!check);

	}

	@Test(dependsOnGroups = "mustLogin", priority = 3, dependsOnMethods = "pageHistory",groups = "afterLogout")
	public void logoutFeature() {
		WebDriver driver = Setup.getDriver();

		Reporter.log("Pengguna mengklik icon keluar");
		driver.findElement(By.cssSelector("i[class='mdi mdi-power text-danger']")).click();
		// cek apakah tombol tidak melakukan fungsi apapun
		boolean check = driver.getCurrentUrl().contains("login");

		// Set hasil test menjadi berhasil ketika page pindah halaman dan set menjadi
		// gagal ketika sebaliknya
		assertTrue(check);
	}
}
