package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AfishaExamples {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.afisha.ru/spb/");

        WebElement inputSearch = webDriver.findElement(By.xpath("//input[@placeholder='Событие, актер, место']"));
        inputSearch.sendKeys("Брат");

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Брат']")));

        webDriver.findElement(By.xpath("//div[.='Брат']")).click();
        Thread.sleep(5000);
        webDriver.quit();

    }
}
