package functionalities;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.QuestionnaireRating;
import helpers.Setup;

public class KuisionerTest {

	private int totalQuestionSequence = 624;

	@Test(dependsOnGroups = { "mustLogin", "afterEditUser" }, priority = 2, groups = "afterKuisioner")
	public void surveyForm() throws InterruptedException {
		WebDriver driver = Setup.getDriver();
		
		
		Reporter.log("Pengguna mengisi kuisioner");
		
		driver.findElement(By.className("ButtonEvaluasi")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Tambah Nama Dosen yang akan dicentang
		List<String> daftarNamaDosen = new ArrayList<String>();

		// Kode Matkul
		List<WebElement> kodeMatkulElement;
		List<String> daftarKodeMatkul = new ArrayList<String>();

		daftarNamaDosen.add("Hermawan Arief P");
		daftarKodeMatkul.add("TIF180701");

		daftarNamaDosen.add("Syamsul Arifin");
		daftarKodeMatkul.add("TIF160701");

		for (String namaDosen : daftarNamaDosen) {
			// cari element
			WebElement labelElement = driver.findElement(By.xpath("//label[contains(text(), '" + namaDosen + "')]"));
			String idDosen = labelElement.getAttribute("for");

			// centang dosen target
			js.executeScript("$('#" + idDosen + "').trigger('click');");
		}

		driver.findElement(By.id("formModal")).submit();

		// sequence pertanyaan ber-id 132 sd 146, 14 total sequence
		// id 132 sd 146 merepresentasikan pertanyaan yang tersedia

		int dosenIncrement = 3081;
		// ulangi mengisi kuisioner sesuai dengan total dosen
		for (int i = 1; i <= daftarNamaDosen.size(); i++) {
			Thread.sleep(1000); // Jeda proses

			// isi kuisioner sesuai sequence
			int startSequence = 132;
			while (startSequence <= 146) {
				checkInputMatchWithCondition(QuestionnaireRating.randomRating(), startSequence, dosenIncrement);
//				System.err.println("Start Seq " + startSequence);
//				System.err.println("dosenInc " + dosenIncrement);
				startSequence++;
			}
			if (i < daftarNamaDosen.size()) {
				driver.findElement(By.partialLinkText("NEXT")).click();
				resetQuestionSequenceTotal(); // reset sequence
			}

			dosenIncrement++;
		}
//		driver.findElement(By.partialLinkText("FINISH"));
		WebElement finishBtn = driver
				.findElement(By.cssSelector("input[class='finish-btn sf-right sf-btn sf-btn-finish']"));

		//Uncomment kode dibawah untuk mengirim kuisioner
//		finishBtn.click(); 
		
		assertTrue(finishBtn.isDisplayed());

	}

	/**
	 * checkInputMatchWithCondition Fungsi digunakan men-cetang input sesuai rating
	 * yang diisi di parameter Pilihan bisa dilihat di
	 * 
	 * @see helpers.QuestionnaireRating
	 * @param rating
	 * @param sequence
	 * @param dosenIncrement
	 */
	private void checkInputMatchWithCondition(QuestionnaireRating rating, int sequence, int dosenIncrement) {
		WebDriver driver = Setup.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		switch (rating) {
		case SANGAT_KURANG:
			setQuestionSequenceTotal(1);
			// logic
			js.executeScript("$('#" + sequence + "-" + getQuestionSequenceTotal() + "-" + dosenIncrement
					+ "').trigger('click');");
			setQuestionSequenceTotal(4);

			break;
		case KURANG_BAIK:
			setQuestionSequenceTotal(2);
			// logic
			js.executeScript("$('#" + sequence + "-" + getQuestionSequenceTotal() + "-" + dosenIncrement
					+ "').trigger('click');");
			setQuestionSequenceTotal(3);
			break;
		case CUKUP:
			setQuestionSequenceTotal(3);
			// logic
			js.executeScript("$('#" + sequence + "-" + getQuestionSequenceTotal() + "-" + dosenIncrement
					+ "').trigger('click');");
			setQuestionSequenceTotal(2);
			break;
		case BAIK:
			setQuestionSequenceTotal(4);
			// logic
			js.executeScript("$('#" + sequence + "-" + getQuestionSequenceTotal() + "-" + dosenIncrement
					+ "').trigger('click');");
			setQuestionSequenceTotal(1);
			break;

		case BAIK_SEKALI:
			setQuestionSequenceTotal(5);
			js.executeScript("$('#" + sequence + "-" + getQuestionSequenceTotal() + "-" + dosenIncrement
					+ "').trigger('click');");
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + rating);
		}
	}

	private int getQuestionSequenceTotal() {
		return totalQuestionSequence;
	}

	private void setQuestionSequenceTotal(int sequence) {
		totalQuestionSequence += sequence;
	}

	private void resetQuestionSequenceTotal() {
		totalQuestionSequence = 624;
	}
}
