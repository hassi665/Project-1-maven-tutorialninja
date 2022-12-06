package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class AccountInfoDetails extends Utility {

    //Details filling for Laptop account

    By firstName = By.id("input-payment-firstname");
    By lastName = By.id("input-payment-lastname");
    By email = By.id("input-payment-email");
    By telephone = By.id("input-payment-telephone");
    By address1 = By.id("input-payment-address-1");
    By city = By.id("input-payment-city");
    By postCode = By.id("input-payment-postcode");


    public void sendFirstName(){
        sendTextToElement(firstName, "Harshid");
    }
    public void sendLastName(){
        sendTextToElement(lastName, "Prime");

    }
    public void sendEmail(){
        sendTextToElement(email, "harshid.prime@gmail.com");

    }
    public void sendTelephone(){
        sendTextToElement(telephone, "07845123678");
    }
    public void sendAddress1(){
        sendTextToElement(address1, "London Street");
    }
    public void sendCityName(){
        sendTextToElement(city, "London");
    }
    public void sendPostCode(){
        sendTextToElement(postCode, "E16NJG");
    }
    public void sendCountry(){
        selectByValueFromDropDown(By.id("input-payment-country"), "222");
    }
    public void sendRegion(){
        selectByValueFromDropDown(By.id("input-payment-zone"), "3559");
    }



}
