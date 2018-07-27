package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.Gmail;

import java.util.concurrent.TimeUnit;


public class Fixture{

    public static Gmail gmail;
    public static WebDriverWrapper driver;

    private static final String IMPLICIT_WAIT = PropertyLoader.loadProperty("wait.timeout");
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());


    @BeforeSuite
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
        driver = new WebDriverWrapper(new ChromeDriver());
        driver.manage().timeouts().implicitlyWait(Long.parseLong(IMPLICIT_WAIT), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        gmail = new Gmail(driver);
        log.info("<--------- Start tests --------->");
    }

    @AfterSuite
    public static void tearDown() throws Exception {
        log.info("<--------- Finished tests --------->");
        log.info("<--------- Close browser --------->");
        //driver.quit();
    }


}
