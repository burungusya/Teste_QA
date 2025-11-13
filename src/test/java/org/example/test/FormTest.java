package org.example.test;
import org.openqa.selenium.*;
import org.example.pom.FormPom;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FormTest extends Basic {

    static public String URL = "https://demoqa.com/automation-practice-form";
    static public String FIRST_NAME = "Vladimir";
    static public String LAST_NAME = "Roșca";
    static public String USER_EMAIL = "vivan577221@gmail.com";
    static public String USER_NUMBER = "0069439739";
    static public String DATE_OF_BIRTH = "31 august 2006";

    static public String SUBJECT = "English";
    static public String HOBBY = "Reading";
//    static public String PICTURE_PATH = "C:\\Users\\vivan\\OneDrive\\Desktop\\test1\\images\\Pictura.JPG";
    static public String CURRENT_ADDRESS = "Chișinău, Moldova";
    static public String STATE = "NCR";
    static public String CITY = "Noida";




    @Test
    public void formTest() throws InterruptedException {
        driver.get(URL);
        FormPom form = new FormPom(driver);

        form.closeAdvert();
        form.setFirstName(FIRST_NAME);
        form.setLastName(LAST_NAME);
        form.setUserEmail(USER_EMAIL);
        form.selectGenderMale();
        form.setUserNumber(USER_NUMBER);
        form.setDateOfBirth(DATE_OF_BIRTH);
        form.scrollToEl();


        form.setSubject(SUBJECT);
        form.selectHobbyReading();
//        form.uploadPicture(PICTURE_PATH);
        form.setCurrentAddress(CURRENT_ADDRESS);
        form.selectStateAndCity(STATE, CITY);
        form.submitForm();

        Thread.sleep(3000);
        WebElement actualName= driver.findElement(By.xpath("//table//*[text()='Student Name']/../td[2]"));
        Assert.assertEquals( actualName.getText(), FIRST_NAME + " " +LAST_NAME);



        System.out.println();

    }
}

