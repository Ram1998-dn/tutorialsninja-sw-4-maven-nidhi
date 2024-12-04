package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.pages.RegisterAccountPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MyAccountsPageTest extends BaseTest {

    HomePage homePage = new HomePage();
    RegisterAccountPage register = new RegisterAccountPage();
    LoginPage loginPage = new LoginPage();
    MyAccountPage myAccountPage = new MyAccountPage();

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = homePage.getListOfAccountType();
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = homePage.getListOfAccountType();
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        homePage.clickONmyAccount();
        selectMyAccountOptions("Register");
        Assert.assertEquals(register.getRegisterAccountTitle(), "Register Account",
                "Register page not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        homePage.clickONmyAccount();
        selectMyAccountOptions("Login");
        Assert.assertEquals(loginPage.getLoginPageTitle(), "Returning Customer",
                "Login page not displayed");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        homePage.clickONmyAccount();
        selectMyAccountOptions("Register");

        register.enterFirstName("prime" + getAlphaNumericString(4));
        register.enterLastName("test" + getAlphaNumericString(4));
        register.enterEmail("prime" + getAlphaNumericString(4) + "@gmail.com");
        register.enterPhoneNumber("07988112233");
        register.enterPassword("test123");
        register.enterConfirmPassword("test123");
        register.selectSubscribe("Yes");
        register.clickOnPrivacyPolicyCheckBox();
        register.clickOnContinueButton();
        Assert.assertEquals(register.getAccountRegistrationConformationMessage(),
                "Your Account Has Been Created!", "Your Account Not Created!");
        register.clickOnContinueWithConfirmation();

        homePage.clickONmyAccount();
        selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccountPage.getMyAccountPageTitle(),
                "Account Logout", "Not logged out");
        homePage.clickONContinueButton();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        homePage.clickONmyAccount();
        selectMyAccountOptions("Login");

        loginPage.enterEmail("prime1233@gmail.com");
        loginPage.enterPassword("test1234");
        loginPage.clickOnLogInButton();
        Assert.assertEquals(myAccountPage.getMyAccountPageTitle(), "My Account",
                "My Account Is not Matched!");
        homePage.clickONmyAccount();
        selectMyAccountOptions("Logout");
        Assert.assertEquals(homePage.getConformationMessageForLogout(),
                "Account Logout", "Not logged out");
        homePage.clickONContinueButton();

    }
}
