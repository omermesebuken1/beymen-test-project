package org.example.test;

import org.example.base.BaseTest;
import org.example.page.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainPageTest extends BaseTest {

    MainPage mainPage;

    @Before
    public void Before()
    {
        mainPage = new MainPage(GetWebDriver());
    }

    @Test
    public void BeymenSearchProductTest() throws Exception {

        mainPage.

                WaitPageToOpen("https://www.beymen.com/").
                ClosePopUp_1().
                ClosePopUp_2().
                ActivateSearchArea().
                ClearSearchArea().
                Search(0).
                WaitSomeTime(500).
                ClearSearchArea().
                Search(1).
                PerformSearch().
                GetCards().
                WriteNameAndPrice().
                SelectSize().
                AddToBasket().
                WaitSomeTime(5000).
                GoToBasket().
                ComparePrices().
                MakeItemCount2().
                WaitSomeTime(1000).
                ClearBasket();

    }

    @After
    public void After()
    {
        TearDown();
    }
}
