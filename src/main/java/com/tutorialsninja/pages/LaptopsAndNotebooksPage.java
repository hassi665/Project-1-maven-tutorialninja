package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

  //  By sortList = By.xpath("//select[@id='input-sort']");

    By laptopPageText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By product = By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[2]/a");
    By successMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By verifyNextCustomer = By.xpath("//h2[contains(text(),'New Customer')");




    public String getTextFromLaptopPage(){
        return getTextFromElement(laptopPageText);
    }

    public void sortByHighToLow(){
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        // Select sort by Price (High > Low)
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
    }

    public void selectMac(){
        clickOnElement(By.linkText("MacBook"));
    }

    public void quantityAdd() {
        clearTextFromElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");}

    public void qtyUpdate(){
        clickOnElement(By.xpath("//button[contains(@data-original-title, 'Update')]"));
    }

    public void checkOut(){
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
    }

    public void guestCheckout(){
        clickOnElement(By.xpath("//input[@value='guest']"));
    }

    public void continueGuestCheckout(){
        clickOnElement(By.id("button-account"));
    }
    public void continueGuestPayment(){
        clickOnElement(By.id("button-guest"));
    }

    public void typeComment(){
        sendTextToElement(By.name("comment"), "Please deliver me this product on time.");
    }
    public void agreeCheck(){
        clickOnElement(By.xpath("//input[@type='checkbox']"));
    }
    public void continuePayment(){
        clickOnElement(By.id("continueGuestPayment"));
    }
    public String getProductName() {
        return getTextFromElement(product);
    }

    public String getsuccessMessageAfterClickingAddToCartButton() {
        return getTextFromElement(successMessage);
    }

    public String verifyNewCustomer(){
        return getTextFromElement(verifyNextCustomer);
    }

    public void continueLastStep(){
        clickOnElement(By.id("button-payment-method"));
    }
}
