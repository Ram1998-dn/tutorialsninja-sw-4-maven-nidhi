package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.text.Utilities;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    By laptopAndNotBookTitle = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By listOfProductPrice = By.xpath("//p[@class ='price']");
    By sortingProducts = By.id("input-sort");

    public String getTitleOfLaptopAndNotBooks() {
        return getTextFromElement(laptopAndNotBookTitle);
    }

    public List<WebElement> getListOfProductsPrice() {
        return getWebElements(listOfProductPrice);
    }


    public void selectSortByZToA(String option) {
        selectByVisibleTextFromDropDown(sortingProducts, option);
    }

    public void clickOnYourSelectedProduct(String productName) {

        clickOnElement(By.linkText(productName));
    }

}

