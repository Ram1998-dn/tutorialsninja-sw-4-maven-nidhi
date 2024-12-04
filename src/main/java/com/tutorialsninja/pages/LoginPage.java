package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {

    By loginPageTitle = By.xpath("//h2[contains(text(),'Returning Customer')]");

    By emailField = By.id("input-email");
    By passwordField = By.id("input-password");
    By loginButton = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");

    public String getLoginPageTitle(){
        return getTextFromElement(loginPageTitle);
    }

    public void enterEmail(String mail) {
        sendTextToElement(emailField, mail);
    }

    public void enterPassword(String pass) {
        sendTextToElement(passwordField, pass);
    }

    public void clickOnLogInButton() {
        clickOnElement(loginButton);
    }
}
