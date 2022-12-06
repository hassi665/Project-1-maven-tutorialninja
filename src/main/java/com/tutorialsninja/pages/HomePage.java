package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {

    By desktops = By.linkText("Desktops");
    By laptopsAndNotebooks = By.linkText("Laptops & Notebooks");
    By components = By.linkText("Components");

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul//li//a"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul//li//a"));
        }
    }

    public void clickOnDesktops() {
        mouseHoverToElement(desktops);
    }

    public void clickOnShowAllDesktopMenu() {
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
    }

    public void clickOnlaptops() {
        mouseHoverToElement(laptopsAndNotebooks);
    }

    public void clickOnComponents() {
        mouseHoverToElement(components);
    }


}
