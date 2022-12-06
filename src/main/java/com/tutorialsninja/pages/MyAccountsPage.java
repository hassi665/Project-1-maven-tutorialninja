package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountsPage extends Utility {

    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By comfirmPassword = By.id("input-confirm");

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }

    public void myAccountClick() {
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
    }

    public void sendFirstName() {
        sendTextToElement(firstName, "Harshid" + getAlphaNumericString(3));
    }

    public void sendLastName() {
        sendTextToElement(lastName, "Prime" + getAlphaNumericString(4));

    }

    public void sendEmail() {
        sendTextToElement(email, "harshid.prime" + getAlphaNumericString(5) + "@gmail.com");

    }

    public void sendTelephone() {
        sendTextToElement(telephone, "07845123678");
    }

    public void sendPassword() {
        sendTextToElement(password, "Prime@123");
    }

    public void sendConfirmPassword() {
        sendTextToElement(comfirmPassword, "Prime@123");
    }

    public void subscribeButton() {
        List<WebElement> radioButtons = driver.findElements(By.xpath("//fieldset[3]//input"));
        for (WebElement e : radioButtons) {
            if (e.getText().equals("Yes")) {
                e.click();
                break;
            }
        }
    }

    public void agreeButton(){
        clickOnElement(By.xpath("//div[@class = 'buttons']//input[@name='agree']"));
    }
    public void continueRegistration(){
        clickOnElement(By.xpath("//div[@class = 'buttons']//input[@value='Continue']"));
    }

    public void continueAfterRegistrationPage(){
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    public void clickOnLogin(){
        clickOnElement(By.xpath("//form[contains(@action,'login')]//input[@type='submit']"));
    }

    public void emailForLogin(){
        sendTextToElement(By.id("input-email"), "jamesbond_007@gmail.com");
    }
    public void passwordLogin(){
        sendTextToElement(By.id("input-password"), "Bond");
    }
}
