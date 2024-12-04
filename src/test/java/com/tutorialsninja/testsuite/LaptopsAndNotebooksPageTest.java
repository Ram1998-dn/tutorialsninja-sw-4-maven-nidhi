package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.pages.ProductDetailPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPageTest extends BaseTest {

    HomePage homePage = new HomePage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){

        homePage.mouseHoverOnLaptopTab();
        homePage.clickOnMenuOption("Show AllLaptops & Notebooks");

        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : laptopsAndNotebooksPage.getListOfProductsPrice()) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);

        laptopsAndNotebooksPage.selectSortByZToA("Price (High > Low)");

        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : laptopsAndNotebooksPage.getListOfProductsPrice()) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        System.out.println(afterSortByPrice);

        Assert.assertEquals(afterSortByPrice, originalProductsPrice, "Product not sorted by price High to Low");

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        homePage.mouseHoverOnCurrencyAndClickOn();
        homePage.selectCurrencyAsAPound("£Pound Sterling");

        homePage.mouseHoverOnLaptopTab();
        homePage.clickOnMenuOption("Show AllLaptops & Notebooks");
       laptopsAndNotebooksPage.selectSortByZToA("Price (High > Low)");
        laptopsAndNotebooksPage.clickOnYourSelectedProduct("MacBook");
        Assert.assertEquals(productDetailPage.getPageTitle(), "MacBook",
                "Product not display");
        Thread.sleep(200);
        productDetailPage.clickOnAddToCartButton();
        Thread.sleep(200);
        Assert.assertTrue(productDetailPage.getProductAddToCartSuccessMessage()
                        .contains("Success: You have added MacBook to your shopping cart!"),
                "Product not added to cart");
        Thread.sleep(5000);
        productDetailPage.clickOnShoppingCart();
        Thread.sleep(5000);
        Assert.assertTrue(shoppingCartPage.getShoppingCartPageTitle().contains("Shopping Cart"));
        Assert.assertEquals(shoppingCartPage.getProductName(), "MacBook",
                "Product name not matched");
        shoppingCartPage.changeQuantity("2");
        shoppingCartPage.clickOnUpdateButton();
        Assert.assertTrue(shoppingCartPage.getProductUpdateSuccessMessage().contains("Success: You have modified your shopping cart!"),
                "Cart not modified");
        Assert.assertEquals(shoppingCartPage.getProductTotalPrice(), "£737.45",
                "Total not matched");
    }

}
