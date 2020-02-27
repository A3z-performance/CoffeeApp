package nl.testchamber.mailordercoffeeshop.pages;

import nl.testchamber.mailordercoffeeshop.R;
import nl.testchamber.mailordercoffeeshop.elements.Element;
import nl.testchamber.mailordercoffeeshop.elements.TextEdit;

import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Класс экрана итогового заказа, с вводом имени и почты и отправкой заказа по почте
 */
public class OrderPage {

    private static final int ID_INGRIDIENTS_DETAIL = R.id.beverage_detail_ingredients;
    private static final int ID_NAME_TEXT_EDIT = R.id.name_text_box;
    private static final int ID_EMAIL_TEXT_EDIT = R.id.email_text_box;
    private static final int ID_SUBMIT_ORDER_BUTTON = R.id.mail_order_button;

    private final Element mIngridientsDetail = new Element("Список ингридиентов", withId(ID_INGRIDIENTS_DETAIL));
    private final TextEdit mNameTextEdit = new TextEdit("Поле вода имени", withId(ID_NAME_TEXT_EDIT));
    private final TextEdit mEmailTextEdit = new TextEdit("Поле вода почты", withId(ID_EMAIL_TEXT_EDIT));
    private final Element mSubmitOrderButton = new Element("Кнопка подтверждения заказа", withId(ID_SUBMIT_ORDER_BUTTON));


    /**
     * ввести имя в поле ввода
     *
     * @param name имя покупателя
     */
    public void setName(String name) {
        mNameTextEdit.fillEditText(name);
    }

    /**
     * ввести почту получателя
     *
     * @param mail почта получателя
     */
    public void setEmail(String mail) {
        mEmailTextEdit.fillEditText(mail);
    }

    /**
     * Получить текствью в котором написаны ингредиенты кофе
     *
     * @return текствью, содержащее описание ингредиентов
     */
    public Element getIngridients() {
        return mIngridientsDetail;
    }

    /**
     * подтвердить заказ и открыть приложение для отправки почты
     */
    public void submitOrder() {
        mSubmitOrderButton.clickAtElement();
    }

}
