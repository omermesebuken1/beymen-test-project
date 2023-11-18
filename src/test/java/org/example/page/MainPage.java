package org.example.page;
import org.example.base.BasePage;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static org.example.constants.ConstantsMainPage.*;

public class MainPage extends BasePage{

    private final Logger logger = LogManager.getLogger(MainPage.class);

    public MainPage(WebDriver driver)
    {
        super(driver);
    }
    public MainPage ClosePopUp_1()
    {
        logger.info("Cookie Pop up Kapatılacak.");
        Click(CLOSE_COOKIE_POPUP);
        logger.info("Cookie Pop up Kapatıldı.");
        return this;
    }
    public MainPage ClosePopUp_2()
    {
        logger.info("Gender Pop up Kapatılacak.");
        Click(CLOSE_GENDER_POPUP);
        logger.info("Gender Pop up Kapatıldı.");
        return this;
    }
    public MainPage Search(int num) throws Exception {

        SendKeys(SEARCH_AREA_2,ReadFromExcel(num));
        return this;
    }
    public MainPage ActivateSearchArea()
    {
        Click(SEARCH_AREA_1);
        return this;
    }
    public MainPage ClearSearchArea()
    {
        ClearText(SEARCH_AREA_2);
        return this;
    }
    public MainPage WaitPageToOpen(String url)
    {
        WaitPageLoad(url);
        return this;
    }
    public MainPage PerformSearch()
    {
        SendEnter(SEARCH_AREA_2);
        return this;
    }
    public MainPage GetCards() throws IOException {
        FindCards(CARD);
        return this;
    }
    public MainPage WriteNameAndPrice() throws IOException {
        WriteToFile(CARD_NAME,CARD_PRICE);
        GetFromTextFromFile();
        return this;
    }
    public MainPage AddToBasket(){
        Click(ADD_TO_BASKET);
        return this;
    }
    public MainPage SelectSize(){
        FindSizes(CARD_SIZE,CARD_SIZE_DISABLED);
        return this;
    }
    public MainPage GoToBasket() {
        Click(BASKET_BUTTON);

        return this;
    }
    public MainPage WaitSomeTime(long waitTime) throws InterruptedException {
        Wait(waitTime);
        return this;
    }
    public MainPage ComparePrices() throws IOException
    {
        CompareStrings(BASKET_PRICE);
        return this;
    }
    public MainPage MakeItemCount2()
    {
        IncreaseItemSizeAndCheck(ITEM_COUNT_DROPDOWN);
        return this;
    }
    public MainPage ClearBasket() throws InterruptedException {
        DeleteItemFromBasketAndCheck(REMOVE_ITEM_BUTTON,BASKET_EMPTY_TEXT);
        return this;
    }

}
