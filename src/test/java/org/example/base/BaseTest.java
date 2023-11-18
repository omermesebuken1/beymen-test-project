package org.example.base;

import org.example.page.MainPage;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseTest {

    static WebDriver webDriver = null;

    private final Logger logger = LogManager.getLogger(BaseTest.class);

    @Before
    public void SetUp()
    {
        try {
            System.setProperty("webdriver.chrome.driver","/Users/omermesebuken/Desktop/Drivers/chromedriver-mac-arm64/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("disable-notifications");
            options.addArguments("disable-popup-blocking");
            SetWebDriver(new ChromeDriver(options));
            GetWebDriver().navigate().to("https://www.beymen.com");
        } catch (Exception e) {

            logger.fatal("Error is " + e);
        }
    }

    public static WebDriver GetWebDriver()
    {
        return webDriver;
    }

    public static void SetWebDriver(WebDriver webDriver)
    {
        BaseTest.webDriver = webDriver;
    }

    public void TearDown()
    {
        GetWebDriver().quit();
    }






}
