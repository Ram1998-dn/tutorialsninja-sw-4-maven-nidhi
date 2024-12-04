package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class RegisterAccountPage extends Utility {

    By pageTitle = By.xpath("//h1[contains(text(),'Register Account')]");
    By firstNameField = By.id("input-firstname");
    By lastNameField = By.id("input-lastname");
    By emailField = By.id("input-email");
    By phoneNumber = By.id("input-telephone");
    By passwordField = By.id("input-password");
    By confirmPasswordField = By.id("input-confirm");
    By subScribe = By.xpath("//fieldset[3]//input");
    By privacyPolicy = By.xpath("//div[@class = 'buttons']//input[@name='agree']");
    By continueButton = By.xpath("//div[@class = 'buttons']//input[@value='Continue']");
    By confirmationMessage = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
    By continueConfirmation = By.xpath("//a[contains(text(),'Continue')]");

    public String getRegisterAccountTitle() {
        return getTextFromElement(pageTitle);
    }

    public void enterFirstName(String fName) {
        sendTextToElement(firstNameField, fName);
    }

    public void enterLastName(String lNmae) {
        sendTextToElement(lastNameField, lNmae);
    }

    public void enterEmail(String mail) {
        sendTextToElement(emailField, mail);
    }

    public void enterPhoneNumber(String number) {
        sendTextToElement(phoneNumber, number);
    }

    public void enterPassword(String pass) {
        sendTextToElement(passwordField, pass);
    }

    public void enterConfirmPassword(String cPass) {
        sendTextToElement(confirmPasswordField, cPass);
    }

    public void selectSubscribe(String option) {
        selectByContainsTextFromListOfElements(subScribe, option);
    }

    public void clickOnPrivacyPolicyCheckBox() {
        clickOnElement(privacyPolicy);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public String getAccountRegistrationConformationMessage() {
        return getTextFromElement(confirmationMessage);
    }

    public void clickOnContinueWithConfirmation() {
        clickOnElement(continueConfirmation);
    }
}
