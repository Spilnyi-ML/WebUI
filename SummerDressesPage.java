package ru.gb.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SummerDressesPage extends BaseView{
    public SummerDressesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Size']/ancestor::div[@class='layered_filter']//a")
    private List<WebElement> sizesList;
    public SummerDressesPage selectSize(String size) {
        webDriverWait.until(d -> sizesList.size() > 0);
        sizesList.stream().filter(s -> s.getText().contains(size)).findFirst().get().click();
        return this;
    }

    @FindBy(xpath = "//span[.='Color']/ancestor::div[@class='layered_filter']//a")
    private List<WebElement> colorList;
    public SummerDressesPage selectColor(String color) {
        webDriverWait.until(d -> colorList.size() > 0);
        colorList.stream().filter(s -> s.getText().contains(color)).findFirst().get().click();
        return this;
    }

    @FindBy(xpath = "//span[.='Compositions']/ancestor::div[@class='layered_filter']//a")
    private List<WebElement> compositionsList;
    public SummerDressesPage selectComposition(String composition) {
        webDriverWait.until(d -> compositionsList.size() > 0);
        compositionsList.stream().filter(s -> s.getText().contains(composition)).findFirst().get().click();
        return this;
    }

    @FindBy(xpath = "//span[.='Styles']/ancestor::div[@class='layered_filter']//a")
    private List<WebElement> stylesList;
    public SummerDressesPage selectStyle(String style) {
        webDriverWait.until(d -> stylesList.size() > 0);
        stylesList.stream().filter(s -> s.getText().contains(style)).findFirst().get().click();
        return this;
    }

    @FindBy(xpath = "//span[.='Properties']/ancestor::div[@class='layered_filter']//a")
    private List<WebElement> PropertiesList;
    public SummerDressesPage selectProperty(String Property) {
        webDriverWait.until(d -> PropertiesList.size() > 0);
        PropertiesList.stream().filter(s -> s.getText().contains(Property)).findFirst().get().click();
        return this;
    }

    @FindBy(xpath = "//span[.='Availability']/ancestor::div[@class='layered_filter']//a")
    private List<WebElement> AvailabilityList;
    public SummerDressesPage selectAvailability(String Availability) {
        webDriverWait.until(d -> AvailabilityList.size() > 0);
        AvailabilityList.stream().filter(s -> s.getText().contains(Availability)).findFirst().get().click();
        return this;
    }

    @FindBy(xpath = "//span[.='Manufacturer']/ancestor::div[@class='layered_filter']//a")
    private List<WebElement> ManufacturerList;
    public SummerDressesPage selectManufacturer(String Manufacturer) {
        webDriverWait.until(d -> ManufacturerList.size() > 0);
        ManufacturerList.stream().filter(s -> s.getText().contains(Manufacturer)).findFirst().get().click();
        return this;
    }

    @FindBy(xpath = "//span[.='Condition']/ancestor::div[@class='layered_filter']//a")
    private List<WebElement> ConditionList;
    public SummerDressesPage selectCondition(String Condition) {
        webDriverWait.until(d -> ConditionList.size() > 0);
        ConditionList.stream().filter(s -> s.getText().contains(Condition)).findFirst().get().click();
        return this;
    }

    @FindBy(xpath = "//div[contains(@class, 'slider')]//a[1]")
    private WebElement leftPriceSliderElement;
    public SummerDressesPage moveLeftPriceSliderElement(int pixelCount) {
        actions.clickAndHold(leftPriceSliderElement)
                .moveByOffset(pixelCount, 0)
                .perform();
        return this;
    }

    @FindBy(xpath = "//div[contains(@class, 'slider')]//a[2]")
    private WebElement rightPriceSliderElement;
    public SummerDressesPage moveRightPriceSliderElement(int pixelCount) {
        actions.clickAndHold(rightPriceSliderElement)
                .moveByOffset(pixelCount, 0)
                .perform();
        return this;
    }

    @FindBy(xpath = "//div[@class='product-container']")
    private List<WebElement> dressesList;

    private static final String addToCartButtonXpathLocator = "//span[.='Add to cart']";
    @FindBy(xpath = addToCartButtonXpathLocator)
    private WebElement addToCartButton;

    public SuccessBlock addToCartByName(String summerDressName) throws InterruptedException {
        actions.moveToElement(dressesList.stream().filter(d -> d.getText().contains(summerDressName)).findFirst().get())
                .perform();
        dressesList.stream().filter(d -> d.getText().contains(summerDressName)).findFirst().get().findElement(
                By.xpath(addToCartButtonXpathLocator)).click();
        return new SuccessBlock(driver);
    }
}