package avito_intership;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class verifyPaginationNavigation {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://makarovartem.github.io/frontend-avito-tech-test-assignment/");

        List<WebElement> cardsFirstPage = driver.findElements(By.xpath("//div[@class='ant-card-body']//h1"));
        String firstCardsFirstPage = cardsFirstPage.get(0).getText();

        driver.findElement(By.cssSelector("li.ant-pagination-next")).click();
        Thread.sleep(2000);

        List<WebElement> cardsSecondPage = driver.findElements(By.xpath("//div[@class='ant-card-body']//h1"));
        String firstCardsSecondPage = cardsSecondPage.get(0).getText();

        Assert.assertNotEquals(firstCardsFirstPage, firstCardsSecondPage, "Название первой карточки не изменилось при переходе на следующую страницу");

        driver.close();
    }

}
