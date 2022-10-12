package ru.gb.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import ru.gb.lesson7.AdditionalLogger;
import ru.gb.lesson7.JunitExtension;

import java.io.ByteArrayInputStream;

@Story("Добавление в корзину")
public class BuySummerDressesTest {
    WebDriver driver;
    MainPage mainPage;

    @RegisterExtension
    JunitExtension testWatcher = new JunitExtension();

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new AdditionalLogger()).decorate(new ChromeDriver());
        mainPage = new MainPage(driver);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    @Feature("Корзина")
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
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry log: logs) {
            Allure.addAttachment("Элемент лога браузера", log.getMessage());
        }

        testWatcher.setScreenshot(new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        driver.quit();
    }
}
