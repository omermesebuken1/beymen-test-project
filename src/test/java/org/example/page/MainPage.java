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
        logger.info(ReadFromExcel(num)+" search kısmına yazıldı.");
        return this;
    }
    public MainPage ActivateSearchArea()
    {
        logger.info("Search Area aktive ediliyor.");
        Click(SEARCH_AREA_1);
        logger.info("Search Area aktive edildi.");
        return this;
    }
    public MainPage ClearSearchArea()
    {
        logger.info("Search Area temizleniyor.");
        ClearText(SEARCH_AREA_2);
        logger.info("Search Area temizlendi.");
        return this;
    }
    public MainPage WaitPageToOpen(String url)
    {
        logger.info("Sayfanın açılması bekleniyor.");
        WaitPageLoad(url);
        logger.info("Sayfa açıldı");
        return this;
    }
    public MainPage PerformSearch()
    {
        logger.info("Search işlemi gerçekleştiriliyor.");
        SendEnter(SEARCH_AREA_2);
        logger.info("Search işlemi gerçekleşti.");
        return this;
    }
    public MainPage GetCards() throws IOException {
        logger.info("Kartlar alınıyor.");
        FindCards(CARD);
        logger.info("Kartlar alındı.");
        return this;
    }
    public MainPage WriteNameAndPrice() throws IOException {
        logger.info("Kart bilgileri txt dosyasına yazılıyor.");
        WriteToFile(CARD_NAME,CARD_PRICE);
        logger.info("Kart bilgileri txt dosyasına yazıldı.");
        logger.info("Kart bilgileri txt dosyasından alınıyor.");
        GetTextFromFile();
        logger.info("Kart bilgileri txt dosyasından alındı.");
        return this;
    }
    public MainPage AddToBasket(){
        logger.info("Ürün sepete ekleniyor.");
        Click(ADD_TO_BASKET);
        logger.info("Ürün sepete eklendi.");
        return this;
    }
    public MainPage SelectSize(){
        logger.info("Ürün boyutu seçiliyor.");
        FindSizes(CARD_SIZE,CARD_SIZE_DISABLED);
        logger.info("Ürün boyutu seçildi.");
        return this;
    }
    public MainPage GoToBasket() {
        logger.info("Sepete gidiliyor.");
        Click(BASKET_BUTTON);
        logger.info("Sepete gidildi.");
        return this;
    }
    public MainPage WaitSomeTime(long waitTime) throws InterruptedException {

        logger.info(waitTime + " ms  beklenecek.");
        Wait(waitTime);
        logger.info("Bekleme tamamlandı.");
        return this;
    }
    public MainPage ComparePrices() throws IOException
    {
        logger.info("Fiyat karşılaştırması yapılıyor.");
        CompareStrings(BASKET_PRICE);
        logger.info("Fiyat karşılaştırması yapıldı.");
        return this;
    }
    public MainPage MakeItemCount2()
    {
        logger.info("Sepetteki ürün adeti arttırılıyor.");
        IncreaseItemSizeAndCheck(ITEM_COUNT_DROPDOWN);
        logger.info("Sepetteki ürün adeti arttırıldı.");
        return this;
    }
    public MainPage ClearBasket() throws InterruptedException {
        logger.info("Sepetteki ürünler siliniyor.");
        DeleteItemFromBasketAndCheck(REMOVE_ITEM_BUTTON,BASKET_EMPTY_TEXT);
        logger.info("Sepetteki ürünler silindi.");
        return this;
    }

}
