package com.tutorialsninja.testsuite;

import com.google.common.base.Verify;
import com.tutorialsninja.pages.AccountInfoDetails;
import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaptopsAndNotebooksTest extends BaseTest {

    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    HomePage homePage = new HomePage();
    DesktopsPage desktopsPage = new DesktopsPage();
    AccountInfoDetails accountInfoDetails = new AccountInfoDetails();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){

        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.clickOnlaptops();
        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show All Laptops & Notebooks");
        //1.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.sortByHighToLow();
        //1.4 Verify the Product price will arrange in High to Low order.

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        homePage.clickOnlaptops();
        clickOnElement(By.linkText("Laptops & Notebooks"));

        //2.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show All Laptops & Notebooks");

        //Change currency to GBP
        desktopsPage.currencyMenu();

        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.sortByHighToLow();

        //2.4 Select Product “MacBook”
        laptopsAndNotebooksPage.selectMac();

        //2.5 Verify the text “MacBook”
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'MacBook')]"));
        String expectedMessage = "MacBook";
        Assert.assertEquals( actualMessage, expectedMessage, "Wrong Product Selected");

        //2.6 Click on ‘Add To Cart’ button
        desktopsPage.addToCart();

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Assert.assertEquals(laptopsAndNotebooksPage.getsuccessMessageAfterClickingAddToCartButton(), "Success: You have added MacBook to your shopping cart!\n" +
                "×");

        //2.8 Click on link “shopping cart” display into success message
        desktopsPage.clickOnShoppingCart();

        //2.9 Verify the text "Shopping Cart"
       String actualMessage1 = getTextFromElement(By.xpath("//h1[contains(text(),' (0.00kg)')]"));
        String expectedMessage1 = "Shopping Cart  (0.00kg)";
        Assert.assertEquals( actualMessage1, expectedMessage1, "Wrong cart Updated");

        //2.10 Verify the Product name "MacBook"
        String actualMessage2 = laptopsAndNotebooksPage.getProductName();
        String expectedMessage2 = "MacBook";
        Assert.assertEquals( actualMessage2, expectedMessage2, "Wrong cart Updated");

        //2.11 Change Quantity "2"
        laptopsAndNotebooksPage.quantityAdd();

        //2.12 Click on “Update” Tab
        laptopsAndNotebooksPage.qtyUpdate();

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String actualMessage3 = getTextFromElement(By.xpath("//body/div[@id='checkout-cart']/div[1]"));
        String expectedMessage3 = "Success: You have modified your shopping cart!\n" + "×";
        Assert.assertEquals( actualMessage3, expectedMessage3, "Shopping Cart modified");

        //2.14 Verify the Total £737.45
        String actualMessage4 = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]"));
        String expectedMessage4 = "£737.45";
        Assert.assertEquals( actualMessage4, expectedMessage4, "Wrong Price Displayed");

        //2.15 Click on “Checkout” button
        Thread.sleep(1000);
        laptopsAndNotebooksPage.checkOut();

        //2.16 Verify the text “Checkout”
        Thread.sleep(1000);
        String actualMessage5 = getTextFromElement(By.xpath("//a[contains(text(),'Checkout')]"));
        String expectedMessage5 = "Checkout";
        Assert.assertEquals( actualMessage5, expectedMessage5, "Checkout page not display");

        //2.17 Verify the Text “New Customer”
//        String actualMessage6 = getTextFromElement(By.xpath("//h2[contains(text(),'New Customer')"));
//        String expectedMessage6 = "New Customer";
//        Assert.assertEquals( actualMessage6, expectedMessage6, "New Customer can not verify");
        Thread.sleep(1000);
       //Assert.assertEquals(laptopsAndNotebooksPage.verifyNewCustomer(), "New Customer");

        //2.18 Click on “Guest Checkout” radio button
        Thread.sleep(1000);
        laptopsAndNotebooksPage.guestCheckout();

        //2.19 Click on “Continue” tab
        Thread.sleep(1000);
        laptopsAndNotebooksPage.continueGuestCheckout();

        //2.20 Fill the mandatory fields
        accountInfoDetails.sendFirstName();
        accountInfoDetails.sendLastName();
        accountInfoDetails.sendEmail();
        accountInfoDetails.sendTelephone();
        accountInfoDetails.sendAddress1();
        accountInfoDetails.sendCityName();
        accountInfoDetails.sendPostCode();
        accountInfoDetails.sendCountry();
        accountInfoDetails.sendRegion();

        //2.21 Click on “Continue” Button
        laptopsAndNotebooksPage.continueGuestPayment();

        //2.22 Add Comments About your order into text area
        laptopsAndNotebooksPage.typeComment();

        //2.23 Check the Terms & Conditions check box
        laptopsAndNotebooksPage.agreeCheck();

        //2.24 Click on “Continue” button
        Thread.sleep(800);
        laptopsAndNotebooksPage.continueLastStep();

        //2.25 Verify the message “Warning: Payment method required!”
        actualMessage = getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        expectedMessage = "Warning: Payment method required!\n" + "×";
        Assert.assertEquals( actualMessage, expectedMessage, "New Customer can not verify");
    }














}
