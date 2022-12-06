package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends BaseTest {

    HomePage homePage = new HomePage();
    DesktopsPage desktopsPage = new DesktopsPage();

    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();


    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        // 1.1 Mouse hover on Desktops Tab.and click
        homePage.clickOnDesktops();
        //1.2 Click on “Show All Desktops”
        homePage.clickOnShowAllDesktopMenu();
        //1.3 Select Sort By position "Name: Z to A"
        desktopsPage.sortByZtoA();
        //1.4 Verify the Product will arrange in Descending order
        Assert.assertEquals(desktopsPage.beforeSortInOrderList(), desktopsPage.afterSortInOrderList(), "Product not sorted into Z to A order");
        System.out.println(desktopsPage.beforeSortInOrderList());
        System.out.println(desktopsPage.afterSortInOrderList());
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        desktopsPage.currencyMenu();
        //2.1 Mouse hover on Desktops Tab. and click
        homePage.clickOnDesktops();
        //2.2 Click on “Show All Desktops”
        homePage.clickOnShowAllDesktopMenu();
        //2.3 Select Sort By position "Name: A to Z"
        desktopsPage.sortByAtoZ();
        //2.4 Select product “HP LP3065”
        desktopsPage.clickOnHpLaptop();
        //2.5 Verify the Text "HP LP3065"
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'HP LP3065')]"));
        String expectedMessage = "HP LP3065";
        Assert.assertEquals( actualMessage, expectedMessage, "Wrong Product Displayed");

        //2.6 Select Delivery Date "2022-11-30"
        desktopsPage.deliveryDatePicker();
        //2.7.Enter Qty "1” using Select class.
        desktopsPage.quantityAdd();
        //2.8 Click on “Add to Cart” button
        desktopsPage.addToCart();
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
//        actualMessage = getTextFromElement(By.xpath("//body/div[@id='product-product']/div[1]"));
//        expectedMessage = "Success: You have added HP LP3065 to your shopping cart!\n" + "×";
//        Assert.assertEquals( actualMessage, expectedMessage, "Wrong Product Displayed");
        Assert.assertEquals(laptopsAndNotebooksPage.getsuccessMessageAfterClickingAddToCartButton(), "Success: You have added HP LP3065 to your shopping cart!\n" + "×");

        //2.10 Click on link “shopping cart” display into success message
        desktopsPage.clickOnShoppingCart();

        //2.11 Verify the text "Shopping Cart"
        Thread.sleep(800);
        String actualMessage1 = getTextFromElement(By.xpath("//h1[contains(text(),' (1.00kg)')]"));
        String expectedMessage1 = "Shopping Cart  (1.00kg)";
        Assert.assertEquals( actualMessage1, expectedMessage1, "Page not displayed");

        //2.12 Verify the Product name "HP LP3065"
        Thread.sleep(800);
        String actualMessage2 = getTextFromElement(By.xpath("//td[@class='text-left']/a[1]"));
        String expectedMessage2 = "HP LP3065";
        Assert.assertEquals( actualMessage2, expectedMessage2, "Wrong Product Displayed");

        //2.13 Verify the Delivery Date "2022-11-30"
        Thread.sleep(800);
        String actualMessage3 = getTextFromElement(By.xpath("//small[contains(text(),'Delivery Date: 2022-11-30')]"));
        String expectedMessage3 = "Delivery Date: 2022-11-30";
        Assert.assertEquals( actualMessage3, expectedMessage3, "Wrong Delivery Date");

        //2.14 Verify the Model "Product21"
        Thread.sleep(800);
        String actualMessage4 = getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]"));
        String  expectedMessage4 = "Product 21";
        Assert.assertEquals( actualMessage4, expectedMessage4, "Wrong Product Displayed");

        //2.15 Verify the Todat "£74.73"
        Thread.sleep(800);
        String actualMessage5 = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]"));
        String expectedMessage5 = "£74.73";
        Assert.assertEquals( actualMessage5, expectedMessage5, "Wrong Price");

    }

}
