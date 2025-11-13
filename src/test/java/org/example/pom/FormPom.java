package org.example.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v137.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPom {

    public static WebDriver driver;
    public static JavascriptExecutor js;

    @FindBy(xpath = "//*[@id='firstName']")
    WebElement firstName;

    @FindBy(xpath = "//*[@id='lastName']")
    WebElement lastName;

    @FindBy(xpath = "//*[@id='userEmail']")
    WebElement userEmail;

    @FindBy(xpath = "//label[@for='gender-radio-2']") // Male
    WebElement genderMale;

    @FindBy(xpath = "//*[@id='userNumber']")
    WebElement userNumber;

    @FindBy(xpath = "//*[@id='dateOfBirthInput']")
    WebElement dateOfBirthInput;

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']") // Reading
    WebElement hobbyReading;

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "react-select-3-input") // State
    WebElement stateInput;

    @FindBy(id = "react-select-4-input") // City
    WebElement cityInput;

    @FindBy(id = "submit")
    WebElement submitButton;



    public FormPom(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor)driver;
        PageFactory.initElements(driver, this);
    }
    public void setLastName(String lastNameParam){
        lastName.clear();
        lastName.sendKeys(lastNameParam);
    }
    public void setFirstName(String firstNameParam) {
        firstName.clear();
        firstName.sendKeys(firstNameParam);
    }
    public void setUserEmail(String userEmailParam) {
        userEmail.clear();
        userEmail.sendKeys(userEmailParam);
    }

    public void selectGenderMale() {
        genderMale.click();
    }

    public void setUserNumber(String userNumberParam) {
        userNumber.clear();
        userNumber.sendKeys(userNumberParam);
    }

    public void setDateOfBirth(String dateOfBirthInputParam) {
        dateOfBirthInput.sendKeys(Keys.CONTROL + "a");
        dateOfBirthInput.sendKeys(dateOfBirthInputParam);
        dateOfBirthInput.sendKeys(Keys.ENTER);
    }

    public void setSubject(String subjectParam) {
        subjectsInput.sendKeys(subjectParam);
        subjectsInput.sendKeys(Keys.ENTER);
    }

    public void selectHobbyReading() {
        hobbyReading.click();
    }

   /* public void setHobbies(String hobbyParam){
        WebElement hobby = driver.findElement(By.xpath() );
    }*/

    public void uploadPicture(String filePathParam) {
        uploadPicture.sendKeys(filePathParam);
    }

    public void setCurrentAddress(String addressParam) {
        currentAddress.clear();
        currentAddress.sendKeys(addressParam);
    }

    public void selectStateAndCity(String stateParam, String cityParam) {
        Actions actions = new Actions(driver);
        actions.moveToElement(stateInput).click().sendKeys(stateParam).sendKeys(Keys.ENTER).perform();
        actions.moveToElement(cityInput).click().sendKeys(cityParam).sendKeys(Keys.ENTER).perform();
    }

    public void submitForm() {
        submitButton.sendKeys(Keys.ENTER);
    }

    public void closeAdvert() {
        try {
            js.executeScript("var elem = document.evaluate(\"//*[@id='adplus-anchor']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                    "elem.parentNode.removeChild(elem);");
        } catch (Exception ignored) {}
        try {
            js.executeScript("var elem = document.evaluate(\"//footer\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                    "elem.parentNode.removeChild(elem);");
        } catch (Exception ignored) {}
    }

    public void scrollToEl(){
        scrollToElement(userNumber);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
