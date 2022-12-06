package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {

    HomePage homePage = new HomePage();
    DesktopsPage desktopsPage = new DesktopsPage();

    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();

    ComponentsPage componentsPage = new ComponentsPage();

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        //1.1 Mouse hover on “Desktops” Tab and click
        homePage.clickOnDesktops();
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        homePage.selectMenu("Show All Desktops");
        //1.3 Verify the text ‘Desktops’
        String expectedText = "Desktops";
        String actualText = desktopsPage.getTextFromDesktopPage();
        Assert.assertEquals(actualText, expectedText, "Desktops page not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.clickOnlaptops();
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        homePage.selectMenu("Show All Laptops & Notebooks");
        //2.3 Verify the text ‘Laptops & Notebooks’
        String expectedText = "Laptops & Notebooks";
        String actualText = laptopsAndNotebooksPage.getTextFromLaptopPage();
        Assert.assertEquals(actualText, expectedText, "Laptop&Notebooks page not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        homePage.clickOnComponents();
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        homePage.selectMenu("Show All Components");
        //3.3 Verify the text ‘Components
        String expectedText = "Components";
        String actualText = componentsPage.getTextFromComponentPage();
        Assert.assertEquals(actualText, expectedText, "Desktops page not displayed");
    }



}
