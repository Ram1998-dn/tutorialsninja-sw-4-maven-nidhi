package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utility {
    By desktopTitle = By.xpath("//h2[normalize-space()='Desktops']");
    By listOfProduct = By.xpath("//h4/a");
    By sortingProducts = By.id("input-sort");

    public String getTitleOfDesktops() {
        return getTextFromElement(desktopTitle);
    }

    public List<WebElement> getListOfProducts() {
        return getWebElements(listOfProduct);
    }


    public void selectSortByZToA(String option) {

        selectByVisibleTextFromDropDown(sortingProducts, option);
    }

    public void clickOnYourSelectedProduct(String productName) {

        clickOnElement(By.linkText(productName));
    }

}



