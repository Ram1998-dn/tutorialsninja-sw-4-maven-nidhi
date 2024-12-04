package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ProductDetailPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

public class DeskTopPageTest extends BaseTest {
    DesktopsPage desktopsPage = new DesktopsPage();
    HomePage homePage = new HomePage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    ShoppingCartPage shoppingCartPage= new ShoppingCartPage();

    public void  verifyProductArrangeInAlphabeticalOrder(){
        homePage.mouseHoverOnDesktopTab();
        homePage.clickOnMenuOption("Show AllDesktops");

        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : desktopsPage.getListOfProducts()) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);

        desktopsPage.selectSortByZToA("Name (Z - A)");

        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : desktopsPage.getListOfProducts()) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);

        Assert.assertEquals(afterSortByZToAProductsName,originalProductsName,
                "Product not sorted into Z to A order");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        homePage.mouseHoverOnCurrencyAndClickOn();
        homePage.selectCurrencyAsAPound("£Pound Sterling");
        homePage.mouseHoverOnDesktopTab();
        homePage.clickOnMenuOption("Show AllDesktops");
        desktopsPage.selectSortByZToA("Name (A - Z)");
        desktopsPage.clickOnYourSelectedProduct("HP LP3065");
        Assert.assertEquals(productDetailPage.getPageTitle(), "HP LP3065",
                "Product not display");

        productDetailPage.selectDeliveryDate("2024", "November", "27");
        Thread.sleep(200);
        productDetailPage.enterQuantity("1");
        Thread.sleep(2000);
        productDetailPage.clickOnAddToCartButton();
        Thread.sleep(2000);
        Assert.assertTrue(productDetailPage.getProductAddToCartSuccessMessage()
                        .contains("Success: You have added HP LP3065 to your shopping cart!"),
                "Product not added to cart");
        Thread.sleep(2000);
        productDetailPage.clickOnShoppingCart();
        Thread.sleep(2000);
        Assert.assertTrue(shoppingCartPage.getShoppingCartPageTitle().contains("Shopping Cart"));
        Assert.assertEquals(shoppingCartPage.getProductName(), "HP LP3065",
                "Product name not matched");
        Assert.assertTrue(shoppingCartPage.getDeliveryDate().contains("2024-11-27"),
                "Delivery date not matched");
        Assert.assertEquals(shoppingCartPage.getProductModel(), "Product 21",
                "Model not matched");
        Assert.assertEquals(shoppingCartPage.getProductTotalPrice(), "£74.73",
                "Total not matched");

    }








}

