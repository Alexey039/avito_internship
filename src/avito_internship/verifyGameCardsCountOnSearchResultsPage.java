package avito_internship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class verifyGameCardsCountOnSearchResultsPage {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://makarovartem.github.io/frontend-avito-tech-test-assignment/");

        List<WebElement> gameCardsCount10 = driver.findElements(By.cssSelector(".ant-list-item"));
        assertEquals(gameCardsCount10.size(), 10);

        driver.findElement(By.cssSelector(".ant-pagination-options")).click();
        driver.findElement(By.id("rc_select_3_list_1")).click();
        Thread.sleep(2000);

        List<WebElement> gameCardsCount20 = driver.findElements(By.cssSelector(".ant-list-item"));
        assertEquals(gameCardsCount20.size(), 20);

        driver.findElement(By.cssSelector(".ant-pagination-options")).click();
        driver.findElement(By.id("rc_select_3_list_2")).click();
        Thread.sleep(2000);

       List<WebElement> gameCardsCount50 = driver.findElements(By.cssSelector(".ant-list-item"));
       try {
           assertEquals(gameCardsCount50.size(), 50);
       } catch (AssertionError error) {
           System.out.println("Ошибка: Количество отображаемых игровых карточек на странице при выборе режима “50 на странице” составляет " + gameCardsCount50.size());
       }

      // if (gameCardsCount50.size() != 50) {
        //    System.out.println("Ошибка: Количество отображаемых игровых карточек на странице при выборе режима “50 на странице”. составляет " + gameCardsCount50.size());
       // }



        driver.findElement(By.cssSelector(".ant-pagination-options")).click();
        driver.findElement(By.id("rc_select_3_list_3")).click();
        Thread.sleep(2000);

        List<WebElement> gameCardsCount100 = driver.findElements(By.cssSelector(".ant-list-item"));
        assertEquals(gameCardsCount100.size(), 100);

       driver.close();
    }
}
