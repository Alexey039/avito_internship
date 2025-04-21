package avito_internship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class shouldOpenGameCard {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://makarovartem.github.io/frontend-avito-tech-test-assignment/");
		driver.findElement(By.xpath("(//div[@class='ant-card-body'])[1]")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Game Page");
		Assert.assertEquals(driver.findElement(By.className("ant-btn")).getText(), "Back to Main");
		driver.close();
	}
}
