package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.MyAccountsPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountsTest extends BaseTest {

    MyAccountsPage myAccountsPage = new MyAccountsPage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link.
        myAccountsPage.myAccountClick();

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        myAccountsPage.selectMyAccountOptions("Register");

        //1.3 Verify the text “Register Account
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Register Account')]"));
        String expectedMessage = "Register Account";
        Assert.assertEquals(actualMessage, expectedMessage, "Register page not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        //2.1 Click on My Account Link.
        myAccountsPage.myAccountClick();

        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        myAccountsPage.selectMyAccountOptions("Login");

        //2.3 Verify the text “Returning Customer”
        String actualMessage = getTextFromElement(By.xpath("//h2[contains(text(),'Returning Customer')]"));
        String expectedMessage = "Returning Customer";
        Assert.assertEquals( actualMessage, expectedMessage, "Login page not displayed");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link.
        myAccountsPage.myAccountClick();

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        myAccountsPage.selectMyAccountOptions("Register");

        //3.3 Enter First Name
        Thread.sleep(800);
        myAccountsPage.sendFirstName();

        //3.4 Enter Last Name
        myAccountsPage.sendLastName();

        //3.5 Enter Email
        myAccountsPage.sendEmail();

        //3.6 Enter Telephone
        myAccountsPage.sendTelephone();

        //3.7 Enter Password
        myAccountsPage.sendPassword();

        //3.8 Enter Password Confirm
        myAccountsPage.sendConfirmPassword();

        //3.9 Select Subscribe Yes radio button
        myAccountsPage.subscribeButton();

        //3.10 Click on Privacy Policy check box
        myAccountsPage.agreeButton();

        //3.11 Click on Continue button
        Thread.sleep(800);
        myAccountsPage.continueRegistration();

        //3.12 Verify the message “Your Account Has Been Created!”
        String actualMessage =  getTextFromElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        String expectedMessage = "Your Account Has Been Created!";
        Assert.assertEquals( actualMessage, expectedMessage, "Register page not displayed with Sucessfully Message");

        //3.13 Click on Continue button
        Thread.sleep(800);
        myAccountsPage.continueAfterRegistrationPage();

        //3.14 Click on My Account Link.
        myAccountsPage.myAccountClick();

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        myAccountsPage.selectMyAccountOptions("Logout");

        //3.16 Verify the text “Account Logout”
        actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        expectedMessage = "Account Logout";
        Assert.assertEquals( actualMessage, expectedMessage, "Account Logout");

        //3.17 Click on Continue button
        myAccountsPage.continueAfterRegistrationPage();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){

        //4.1 Clickr on My Account Link.
        myAccountsPage.myAccountClick();

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        myAccountsPage.selectMyAccountOptions("Login");

        //4.3 Enter Email address
        myAccountsPage.emailForLogin();

        //4.4 Enter Last Name
     //   myAccountsPage.sendLastName();

        //4.5 Enter Password
        myAccountsPage.passwordLogin();

        //4.6 Click on Login button
        myAccountsPage.clickOnLogin();

        //4.7 Verify text “My Account”
       String actualMessage = getTextFromElement(By.xpath("//h2[contains(text(),'My Account')]"));
       String expectedMessage = "My Account";
        Assert.assertEquals( actualMessage, expectedMessage, "Account Not Login Successfully");

        //4.8 Click on My Account Link.
        myAccountsPage.myAccountClick();

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        myAccountsPage.selectMyAccountOptions("Logout");

        //4.10 Verify the text “Account Logout”
        actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        expectedMessage = "Account Logout";
        Assert.assertEquals(actualMessage, expectedMessage, "Not logged out");

        //4.11 Click on Continue button
        myAccountsPage.continueAfterRegistrationPage();
    }

}

