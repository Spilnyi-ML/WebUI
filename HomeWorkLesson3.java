package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWorkLesson3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver webDriver1 = new ChromeDriver();
        webDriver1.get("https://spb.hh.ru/");

        webDriver1.findElement(By.xpath("//a[@data-page-analytics-event='login_button_header.desktop']")).click();
        webDriver1.findElement(By.xpath("//button[@data-qa='expand-login-by-password']")).click();
        webDriver1.findElement(By.xpath("//input[@data-qa='login-input-username']")).sendKeys("89219577517");
        webDriver1.findElement(By.xpath("//input[@data-qa='login-input-password']")).sendKeys("12345");
        webDriver1.findElement(By.xpath("//button[@data-qa='account-login-submit']")).click();

        Thread.sleep(5000);
        webDriver1.quit();

        WebDriver webDriver2 = new ChromeDriver();
        webDriver2.get("https://spb.hh.ru/");
        webDriver2.findElement(By.id("a11y-search-input")).sendKeys("QA-Engineer");
        webDriver2.findElement(By.xpath("//button[@data-qa='search-button']")).click();

        Thread.sleep(5000);
        webDriver2.quit();
    }
}
