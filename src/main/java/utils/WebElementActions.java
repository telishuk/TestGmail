package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class WebElementActions {

    private WebDriver driver;
    public static WebDriverWait waitForElement;
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());


    public WebElementActions(WebDriver driver) {
        this.driver = driver;
        waitForElement = new WebDriverWait(driver, 10);
    }

    public void openPage(String siteUrl){
        driver.get(siteUrl);
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public void clearField(String clearLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        driver.findElement(Readouts.ui(clearLocator)).clear();
        log.info("Clear field " + clearLocator);
    }

    public void clickButton(String buttonLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        driver.findElement(Readouts.ui(buttonLocator)).click();
        log.info("Click on button " + buttonLocator);
    }

    public void clickLink(String linkLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        driver.findElement(Readouts.ui(linkLocator)).click();
        log.info("Click on link " + linkLocator);
    }

    public void clickElement(String elementLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        driver.findElement(Readouts.ui(elementLocator)).click();
        log.info("Click element " + elementLocator);
    }

    public void input(String inputLocator, String inputData) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        driver.findElement(Readouts.ui(inputLocator)).clear();
        driver.findElement(Readouts.ui(inputLocator)).sendKeys(inputData);
        log.info("Input in " + inputLocator + ", value " +  "'" + inputData + "'");
    }

    public void inputAndClickEnter(String inputLocator, String inputData) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        driver.findElement(Readouts.ui(inputLocator)).clear();
        driver.findElement(Readouts.ui(inputLocator)).sendKeys(inputData);
        driver.findElement(Readouts.ui(inputLocator)).sendKeys(Keys.ENTER);
        log.info("Input in " + inputLocator + ", value " + "'" + inputData + "'");
    }

    public boolean isElementPresent(String elementLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        List<WebElement> list = driver.findElements(Readouts.ui(elementLocator));
        if (list.size() == 0){
           log.warn("Element '" + elementLocator + "' is NOT Displayed Present!");
           return false;
        }else {
            log.info("Element '" + elementLocator + "' is Present");
            return list.get(0).isDisplayed();
        }
    }

    public String getElementsText(String elementsLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
       // return driver.findElements(Readouts.ui(elementsLocator)).toString();
        return driver.findElement(Readouts.ui(elementsLocator)).getText();
    }

    public void selectFromList(String listLocator, String listValue) throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        new Select(driver.findElement(Readouts.ui(listLocator))).selectByValue(listValue);
        log.info("ListLocator " + listLocator + ", value - " + listValue);
    }

    public void waitForElementPresent(String elementLocator) throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        log.info("*Start TO* Wait For Element _" + elementLocator + "_ Present");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(Readouts.ui(elementLocator)));
    }

    public void waitForElementToBeClickable(String elementLocator) throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        log.info("*Start TO* Wait For Element _" + elementLocator + "_ To Be Clickable");
        waitForElement.until(ExpectedConditions.elementToBeClickable(Readouts.ui(elementLocator)));
    }

}
