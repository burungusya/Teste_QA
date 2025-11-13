package org.example.test;
import org.example.pom.LoginPom;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Basic {
    static public String URL ="https://demoqa.com/login";
    static public String USER_NAME = "Gabi";
    static public String PASSWORD = "Parola1$";

    @Test
    public void loginTest ()  throws InterruptedException {
        logger.info ("Start formTest");
        driver.get(URL);

        LoginPom loginPom = new LoginPom(driver);
        loginPom.setUserName(USER_NAME);
        loginPom.setPassword(PASSWORD);
        String title = loginPom.clickLogin();
        Assert.assertEquals(title, USER_NAME);
        logger.info ("Finish formTest");

        Thread.sleep(1000);

    }

}
