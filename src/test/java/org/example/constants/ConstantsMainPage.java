package org.example.constants;
import org.openqa.selenium.By;
public class ConstantsMainPage {

    public static final By CLOSE_COOKIE_POPUP = By.id("onetrust-accept-btn-handler");
    public static final By CLOSE_GENDER_POPUP = By.className("o-modal__closeButton");
    public static final By SEARCH_AREA_1 = By.className("o-header__search--input");
    public static final By SEARCH_AREA_2 = By.id("o-searchSuggestion__input");
    public static final By CARD = By.className("o-productList__itemWrapper");
    public static final By ADD_TO_BASKET = By.id("addBasket");
    public static final By CARD_NAME = By.className("o-productDetail__description");
    public static final By CARD_PRICE = By.id("priceNew");
    public static final By CARD_SIZE = By.className("m-variation__item");
    public static final By CARD_SIZE_DISABLED = By.className("-disabled");
    public static final By BASKET_BUTTON = By.className("icon-cart");
    public static final By BASKET_PRICE = By.className("m-orderSummary__value");
    public static final By ITEM_COUNT_DROPDOWN = By.id("quantitySelect0-key-0");
    public static final By REMOVE_ITEM_BUTTON = By.className("m-basket__remove");
    public static final By BASKET_EMPTY_TEXT = By.className("m-empty__messageTitle");

}
