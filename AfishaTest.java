package ru.gb.Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AfishaTest {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    Actions actions;


    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser(){
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        actions = new Actions(webDriver);
        webDriver.get("https://www.afisha.ru/");
    }

    @Test
    void newYearTest() throws InterruptedException {
        actions.moveToElement(webDriver.findElement(By.xpath("//a[.='ДЕТИ']"))).perform();
        webDriver.findElement(By.xpath("//div[@data-test='HEADER-MENU']//a[.='Ёлки']")).click();
        Thread.sleep(3000);
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("new_year_for_kids"));
    }

    @Test
    void clubTest() throws InterruptedException {
        ((JavascriptExecutor)webDriver).executeScript("let element = document.evaluate(\"//div[@class='_3PwQh']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n" +
                "element.singleNodeValue.remove()");
        Thread.sleep(5000);
        actions.moveToElement(webDriver.findElement(By.xpath("//a[.='КОНЦЕРТЫ']"))).perform();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-test='HEADER-MENU']//a[.='Клубы Москвы']")));
        webDriver.findElement(By.xpath("//div[@data-test='HEADER-MENU']//a[.='Клубы Москвы']")).click();
        Thread.sleep(3000);
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("club"));
    }

    @AfterEach
    void tearDown(){
        webDriver.quit();
    }
}
