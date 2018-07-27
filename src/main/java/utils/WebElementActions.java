package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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


    /*
     *Clear field
     */
    public void clearField(String clearLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        driver.findElement(Readouts.ui(clearLocator)).clear();
        log.info("Clear field " + clearLocator);
    }

    /*
     *Click a button
     */
    public void clickButton(String buttonLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        driver.findElement(Readouts.ui(buttonLocator)).click();
        log.info("Click on button " + buttonLocator);
    }


    /*
     *Click a link
     */
    public void clickLink(String linkLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        driver.findElement(Readouts.ui(linkLocator)).click();
        log.info("Click on link " + linkLocator);
    }

    /*
     *Click a element
     */
    public void clickElement(String elementLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        driver.findElement(Readouts.ui(elementLocator)).click();
        log.info("Click element " + elementLocator);
    }


    /*
     *Insert value into text input HTML field
     */
    public void input(String inputLocator, String inputData) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        driver.findElement(Readouts.ui(inputLocator)).clear();
        driver.findElement(Readouts.ui(inputLocator)).sendKeys(inputData);
        log.info("Input in " + inputLocator + ", value " +  "'" + inputData + "'");
    }

    /*
     *Insert value into text input HTML field and click ENTER for field witch use "value" in the xpath expression
     */
    public void inputAndClickEnter(String inputLocator, String inputData) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        driver.findElement(Readouts.ui(inputLocator)).clear();
        driver.findElement(Readouts.ui(inputLocator)).sendKeys(inputData);
        driver.findElement(Readouts.ui(inputLocator)).sendKeys(Keys.ENTER);
        log.info("Input in " + inputLocator + ", value " + "'" + inputData + "'");
    }

    /*
     *Method is used to check that elements is present on page
     */
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

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /*
     *This method is used to agree messages on pop-up windows
     */
    public boolean isAlertPresent(){
        boolean alertPresence = false;
        try{
            Alert alert = driver.switchTo().alert();
            alertPresence = true;
            alert.accept();
        }catch (NoAlertPresentException ex){
            ex.printStackTrace();
            return alertPresence;
        }
        return alertPresence;
    }

    /*
     *This method is used to get text on pop-up windows
     */
    public String getAlertText(){
        String alertText;
        try{
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            alert.accept();
            log.info("Alert text " + alertText);
        }catch (NoAlertPresentException ex){
           alertText = "Alert is not found";
           ex.printStackTrace();
           log.info("Alert is not found " + alertText);
        }
        return alertText;
    }

    /*
     *Move element and click
     */
    public void moveToElementAndClick(String moveToLocator, String clickToElement) throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        WebElement webElement = driver.findElement(Readouts.ui(moveToLocator));

        Actions actions = new Actions (driver);
        actions.moveToElement(webElement);
        actions.perform(); // always need
        clickButton(clickToElement);

        log.info("Moved to element " + moveToLocator + " and clicked on " + clickToElement);

    }

    /*
     *Method is refresh page
     */
    public void refreshPage(){
        driver.navigate().refresh();
    }

    /*
     *Methods for pressing the keypad buttons
     */
    public  void pressSpaceKey(String inputLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        driver.findElement(Readouts.ui(inputLocator)).sendKeys(Keys.SPACE);
    }

    public  void pressEnterKey(String inputLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        driver.findElement(Readouts.ui(inputLocator)).sendKeys(Keys.ENTER);
    }

    public  void pressEscapeKey(String inputLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        driver.findElement(Readouts.ui(inputLocator)).sendKeys(Keys.ESCAPE);
    }

    public  void pressPageUpKey(String inputLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        driver.findElement(Readouts.ui(inputLocator)).sendKeys(Keys.PAGE_UP);
    }

    public  void pressPageDownKey(String inputLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        driver.findElement(Readouts.ui(inputLocator)).sendKeys(Keys.PAGE_DOWN);
    }

    public  void pressCtrlKey(String inputLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        driver.findElement(Readouts.ui(inputLocator)).sendKeys(Keys.CONTROL);
    }

    public  void pressShiftKey(String inputLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        driver.findElement(Readouts.ui(inputLocator)).sendKeys(Keys.SHIFT);
    }

    /*
     *This method is used to do Focus to Element
     * Use Actions class
     */
    public void doFocusToElement(String focusElementLocator) throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        new Actions(driver).moveToElement(getElement(focusElementLocator)).perform();
        log.info("Focus in to element" + focusElementLocator);
    }

    /*
     *This method is used to do Focus to Element and Click
     * Use Actions class
     */
    public void doFocusToElementAndClick(String focusElementLocator, String elementLocator) throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        new Actions(driver).moveToElement(getElement(focusElementLocator)).perform();
        log.info("Focus in to element" + focusElementLocator);
        driver.switchTo();
        if (isElementPresent(elementLocator)){
            clickButton(elementLocator);
        }
    }

    /**
     * This method is used to wait for getting responce from all AJAX requests
     */
    public boolean waitForAjaxResponse(int timeoutSeconds) throws InterruptedException{
        if (driver instanceof JavascriptExecutor){
            JavascriptExecutor jsDriver = (JavascriptExecutor) driver;

            for (int i =0; i < timeoutSeconds; i++){
                Long numberOfConnections = (Long) jsDriver.executeScript("return jQuery.activ");
                if (numberOfConnections instanceof  Long){
                    log.debug("Number or active jQuery Ajax calls is < " + numberOfConnections + " >");
                    if (numberOfConnections == 0)
                        break;
                }
                //stay(1);
            }
            return false;
        }else {
            log.info("WebElementsActions Driver : < " + driver + " > can't execute JavaScript");
            return false;
        }
    }

    public WebElement getElement(String elementLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        return driver.findElement(Readouts.ui(elementLocator));
    }

    public List<WebElement> getElements(String elementsLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        return driver.findElements(Readouts.ui(elementsLocator));
    }

    public String getElementsText(String elementsLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
       // return driver.findElements(Readouts.ui(elementsLocator)).toString();
        return driver.findElement(Readouts.ui(elementsLocator)).getText();
    }

    public String getValueOfElement(String valueLocator) throws InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, NoSuchLocatorException {
        return driver.findElement(Readouts.ui(valueLocator)).getAttribute("Value");
    }

    /*
     * Select value from drop-dawn list
     */
    public void selectFromList(String listLocator, String listValue) throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        new Select(driver.findElement(Readouts.ui(listLocator))).selectByValue(listValue);
        log.info("ListLocator " + listLocator + ", value - " + listValue);
    }

    public void sleep(long millis){
        try{
            log.info("*Start TO* Wait " + millis + "milliseconds");
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * An expectation for checking that an element is present on the DOM of a page and visible.
     * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
     * Advantages of this method over isElementPresent(By elementLocator); is that it expects the appearance of an element.
     */
    public void waitForElementPresent(String elementLocator) throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        log.info("*Start TO* Wait For Element _" + elementLocator + "_ Present");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(Readouts.ui(elementLocator)));
    }

    public void waitForElementDisappear(String elementLocator) throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        log.info("*Start TO* Wait For Element _" + elementLocator + "_ Present");
        waitForElement.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(Readouts.ui(elementLocator))));
    }

    /**
     * An expectation for checking that an element is present on the DOM of a
     * page. This does not necessarily mean that the element is visible.
     *
     * @param elementLocator used to find the element
     */
    public void waitForPresenceOfElementLocated(String elementLocator) throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        log.info("*Start TO* Wait For Presence Of Element Located _" + elementLocator + "_");
        waitForElement.until(ExpectedConditions.presenceOfElementLocated(Readouts.ui(elementLocator)));
    }

    /**
     * An expectation for checking an element is visible and enabled such that you
     * can click it.
     *
     * @param elementLocator used to find the element
     */
    public void waitForElementToBeClickable(String elementLocator) throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        log.info("*Start TO* Wait For Element _" + elementLocator + "_ To Be Clickable");
        waitForElement.until(ExpectedConditions.elementToBeClickable(Readouts.ui(elementLocator)));
    }

    /**
     * An expectation for checking that an element is becomes invisible, but stay on the DOM.
     */
    public void waitForInvisibilityOfElement(String elementLocator) throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        log.info("*Start TO* Wait For Invisibility Of Element _" + elementLocator + "_ ");
        waitForElement.until(ExpectedConditions.invisibilityOfElementLocated(Readouts.ui(elementLocator)));
    }

    /**
     * Wait for invisibility Of Element on page specified time
     */
    public void waitForInvisibilityOfElement(String elementLocator, int timeoutInS) throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInS);

        log.info("*Start TO* Wait For Element Not Visible _" + elementLocator + "_");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(Readouts.ui(elementLocator)));
    }

    /**
     * Wait for invisibility Of Element on page
     */
    public void waitForElementNotVisible(String elementLocator) throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        log.info("*Start TO* Wait For Element Not Visible _" + elementLocator + "_");
        waitForElement.until(ExpectedConditions.invisibilityOfElementLocated(Readouts.ui(elementLocator)));
    }


}
