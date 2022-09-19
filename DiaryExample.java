package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class DiaryExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://diary.ru/user/login");

        Cookie authCookie = new Cookie("_identity_", "57269678cd0cd108a9949f889cb120b75f7caf48b29597bfbf8445c2961ede2aa%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3572590%2C%22Hxyie5w-uUrQpD_migg4th72jgISa6XD%22%2C2592000%5D%22%3B%7D");
        webDriver.manage().addCookie(authCookie);

        webDriver.navigate().refresh();

        webDriver.findElement(By.id("writeThisDiary")).click();
        String postTitle = "Title" + new Random().nextInt(100);
        webDriver.findElement(By.id("postTitle")).sendKeys(postTitle);

        webDriver.switchTo().frame(webDriver.findElement(By.id("message_ifr")));
        webDriver.findElement(By.id("tinymce")).sendKeys("text");

        webDriver.switchTo().parentFrame();
        webDriver.findElement(By.id("rewrite")).click();

        List<WebElement> titles = webDriver.findElements(By.xpath("//a[@class='title']"));
        titles.stream().filter(p -> p.getText().equals(postTitle)).findFirst().get().click();

        Thread.sleep(5000);
        webDriver.quit();

    }
}
