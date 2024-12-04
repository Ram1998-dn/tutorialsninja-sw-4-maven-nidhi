package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {

    By desktopsTab = By.linkText("Desktops");
    By laptopsAndNotebooksTab = By.linkText("Laptops & Notebooks");
    By componentsTab = By.linkText("Components");
    By topMenuList = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    By currencyDropdown = By.xpath("//span[contains(text(),'Currency')]");
    By selectPound = By.xpath("//ul[@class = 'dropdown-menu']/li");
    By selectAccountType = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li");


    By myAccount = By.xpath("//span[contains(text(),'My Account')]");
    By confirmationMsgOfLogOut = By.xpath("//h1[text()='Account Logout' ]");
    By btnContinue = By.xpath("//a[contains(text(),'Continue')]");


    public void mouseHoverOnDesktopTab(){
        mouseHoverToElement(desktopsTab);
    }
    public void mouseHoverOnLaptopTab(){
        mouseHoverToElement(laptopsAndNotebooksTab);
    }
    public void mouseHoverOnComponentsTab(){
        mouseHoverToElement(componentsTab);
    }

    public List<WebElement> getTopMenuList(){
        return getWebElements(topMenuList);
    }
    public void clickOnMenuOption(String menu){
        clickOnElement(By.linkText(menu));
    }

    public void mouseHoverOnCurrencyAndClickOn(){
        mouseHoverToElementAndClick(currencyDropdown);
    }

    public void selectCurrencyAsAPound(String option){
        selectByContainsTextFromDropDown(selectPound,option);

    }
    public List<WebElement> getListOfAccountType(){
        return getWebElements(selectAccountType);
    }
    public void clickONmyAccount(){
        clickOnElement(myAccount);
    }
    public Object getConformationMessageForLogout(){
        return clickOnElement(confirmationMsgOfLogOut);
    }
    public void clickONContinueButton(){
        clickOnElement(btnContinue);
    }






}

