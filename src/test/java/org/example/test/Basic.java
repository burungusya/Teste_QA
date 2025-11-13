package org.example.test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Basic {
    public static final Logger logger = LogManager.getLogger(FormTest.class);
    static public WebDriver driver;

    @BeforeClass
    public void beforeTest() {
        logger.info("Start beforeTest");
        driver = Driver.getRemoteDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterTest() {
        driver.quit();
        logger.info("Finish afterTest");
    }

}