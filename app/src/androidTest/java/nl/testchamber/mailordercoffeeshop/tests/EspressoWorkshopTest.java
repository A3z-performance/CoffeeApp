package nl.testchamber.mailordercoffeeshop.tests;

import android.content.Intent;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;


import nl.testchamber.mailordercoffeeshop.MainActivity;
import nl.testchamber.mailordercoffeeshop.R;
import nl.testchamber.mailordercoffeeshop.pages.CustomOrderPage;
import nl.testchamber.mailordercoffeeshop.pages.MenuPage;
import nl.testchamber.mailordercoffeeshop.pages.OrderPage;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;
import static nl.testchamber.mailordercoffeeshop.matchers.TextInTextViewMatcher.hasValueEqualTo;

/**
 * <p>
 * Открыт главный экран приложения
 * </p>
 * <p>
 * 1. В верхней части экрана нажать "MENU"
 * </p><p>
 * Появился список(recycler) кофе
 * </p><p>
 * 2. Выбрать из списка кофе, например "Breve"
 * </p><p>
 * Появился экран заказа, с указанием ингредиентов выбранного кофе, с полями ввода имени и почты
 * </p><p>
 * 3. Ввести имя и почту, нажать кнопку "submit order"
 * </p><p>
 * Вызван Intent на отправку письма
 * </p>
 */

@RunWith(AndroidJUnit4.class)
public class EspressoWorkshopTest {

    private CustomOrderPage mCustomOrderPage;
    private MenuPage mMenuPage;
    private OrderPage mOrderPage;

    private static final String coffee = "Breve";
    private static final String ingredients = "Ingredients:\n2 shots of Espresso\\nHalf & half";
    private static final String buyerName = "Andrew";
    private static final String buyerMail = "example@gmail.com";

    @Rule
    public IntentsTestRule<MainActivity> intentTestRule = new IntentsTestRule<>(MainActivity.class);


    @Before
    public void initPages() {
        mCustomOrderPage = new CustomOrderPage();
        mMenuPage = new MenuPage();
        mOrderPage = new OrderPage();
        onView(withId(R.id.close_button)).perform(click());
    }

    @Test
    public void sendMailIntentTest() {

        // Шаг 1. В верхней части экрана нажать "MENU"
        mCustomOrderPage.openMenu();
        mMenuPage.listCoffee().check(matches(isDisplayed()));

        // Шаг 2. Выбрать из списка кофе "Breve"
        mMenuPage.chooseCoffee(coffee);
        mOrderPage.getIngridients().check(matches(hasValueEqualTo(ingredients)));

        // Шаг 3. Ввести имя и почту, нажать кнопку "submit order"
        mOrderPage.setName(buyerName);
        mOrderPage.setEmail(buyerMail);
        mOrderPage.submitOrder();


        intended(allOf(hasAction(Intent.ACTION_SENDTO), hasData("mailto:")));

    }


    /**
     * Ниже опциональные тесты на проверку верного отображения toast messages
     */

    @Test
    public void toastWithLessThenZeroEspresso() {
        String toastMsg = "You can't order less than zero espresso shots";
        mCustomOrderPage.lessEspresso();
        onView(withText(toastMsg))
                .inRoot(withDecorView(not(is(intentTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));

    }

    @Test
    public void orderZeroEspressoToast() {
        String toastMsg = "A minimum of 1 Espresso shot is required for each order";
        mCustomOrderPage.reviewOrder();
        onView(withText(toastMsg))
                .inRoot(withDecorView(not(is(intentTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }


}

