package nl.testchamber.mailordercoffeeshop.pages;

import nl.testchamber.mailordercoffeeshop.R;
import nl.testchamber.mailordercoffeeshop.elements.Element;

import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Класс главного экрана приложения
 */
public class CustomOrderPage {

    private static final int ID_LESS_ESPRESSO_BUTTON = R.id.less_espresso;
    private static final int ID_REVIEW_ORDER_BUTTON = R.id.review_order;
    private static final int ID_MENU_BUTTON = R.id.use_menu;
    private static final int ID_CUSTOM_ORDER_TITLE = R.id.custom_order_title;

    private final Element mLessEspressoBtn = new Element("Кнопка минус эспрессо", withId(ID_LESS_ESPRESSO_BUTTON));
    private final Element mReviewOrderBtn = new Element("Кнопка Просмотр заказа", withId(ID_REVIEW_ORDER_BUTTON));
    private final Element mMenuBtn = new Element("Кнопка Просмотр заказа", withId(ID_MENU_BUTTON));
    private final Element mCustomOrderTitle = new Element("Кнопка Просмотр заказа", withId(ID_CUSTOM_ORDER_TITLE));


    /**
     * Открыть меню с кофе
     */
    public void openMenu() {
        mMenuBtn.clickAtElement();
    }

    /**
     * уменьшить количество эспрессо в заказе
     */
    public void lessEspresso() {
        mLessEspressoBtn.clickAtElement();
    }

    /**
     * посмотреть заказ
     */
    public void reviewOrder() {
        mReviewOrderBtn.clickAtElement();
    }

}
