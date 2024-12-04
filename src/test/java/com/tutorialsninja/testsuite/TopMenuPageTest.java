package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopsPage desktopsPage = new DesktopsPage();
   LaptopsAndNotebooksPage notebooksPage = new LaptopsAndNotebooksPage();
    ComponentsPage componentsPage = new ComponentsPage();

    public void selectMenu(String menu) {
        homePage.clickOnMenuOption(menu);

    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        homePage.mouseHoverOnDesktopTab();
        Thread.sleep(2000);
        selectMenu("Show AllDesktops");
        Assert.assertEquals(desktopsPage.getTitleOfDesktops(), "Desktops",
                "Not navigate to Desktop page");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.mouseHoverOnComponentsTab();
        selectMenu("Show AllLaptops & Notebooks");
        Assert.assertEquals(notebooksPage.getTitleOfLaptopAndNotBooks(),
                "Laptops & Notebooks", "Not navigate to Laptops and Notebooks page");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.mouseHoverOnComponentsTab();
        selectMenu("Show AllComponents");
        Assert.assertEquals(componentsPage.getPageTitleOfComponentsTab(), "Components",
                "Not navigate to Components page");
    }



}
