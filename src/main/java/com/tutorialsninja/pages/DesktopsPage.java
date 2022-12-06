package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utility {

    By desktopPageText = By.xpath("//h2[contains(text(),'Desktops')]");
    By currency = By.xpath("//span[contains(text(),'Currency')]");
    By hPLaptop = By.xpath("//a[contains(text(),'HP LP3065')]");
    By addCart = By.id("button-cart");
    By listOfProducts = By.xpath("//h4/a");
    By sortList = By.xpath("//select[@id='input-sort']");
    By shoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");


    public String getTextFromDesktopPage() {
        return getTextFromElement(desktopPageText);
    }


    public ArrayList beforeSortInOrderList() {
        List<WebElement> products = driver.findElements(listOfProducts);
        ArrayList<String> originalProductList = new ArrayList<>();
        for (WebElement list : products) {
            originalProductList.add(list.getText());
        }
        return originalProductList;
    }

    public ArrayList <String> afterSortInOrderList() {
        Collections.reverse(beforeSortInOrderList());
        List<WebElement> products = driver.findElements(listOfProducts);
        ArrayList<String> afterSortList = new ArrayList<>();
        for (WebElement List1 : products) {
            afterSortList.add(List1.getText());
        }
        return afterSortList;
    }


    public void currencyMenu() {
        clickOnElement(currency);
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }

    public void clickOnHpLaptop() {
        clickOnElement(hPLaptop);
    }

    public void deliveryDatePicker() {
        String year = "2022";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public void quantityAdd() {
        clearTextFromElement(By.xpath("//input[@id='input-quantity']"));
        sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");
    }

    public void addToCart(){
        clickOnElement(addCart);
    }

    public void sortByZtoA(){
        selectByVisibleTextFromDropDown(sortList, "Name (Z - A)");
    }

    public void sortByAtoZ(){
        selectByVisibleTextFromDropDown(sortList, "Name (A - Z)");
    }

    public void clickOnShoppingCart(){
        clickOnElement(shoppingCart);
    }

}
