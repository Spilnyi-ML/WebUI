package ru.gb.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuySummerDressesTest {
    WebDriver driver;
    MainPage mainPage;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    void buySummerDressTest() throws InterruptedException {
        mainPage.clickSignInButton()
                .login("SpilnyiML@test.test", "12345")
                .navigationBlock.hoverWomenMenuAndClickSummerDresses()
                .selectSize("M")
                .selectColor("Yellow")
                .selectComposition("Viscose")
                .selectStyle("Casual")
                .selectProperty("Maxi Dress")
                .selectAvailability("In stock")
                .selectManufacturer("Fashion Manufacturer")
                .selectCondition("New")
                .moveLeftPriceSliderElement(10)
                .moveRightPriceSliderElement(-5)
                .addToCartByName("Printed")
                .checkTotalSumma("$30.98");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
