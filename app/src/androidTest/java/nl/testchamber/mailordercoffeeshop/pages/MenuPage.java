package nl.testchamber.mailordercoffeeshop.pages;

import nl.testchamber.mailordercoffeeshop.R;
import nl.testchamber.mailordercoffeeshop.elements.Recycler;

import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Класс страницы со списком кофе
 */
public class MenuPage {

    private static final int ID_COFFEE_RECYCLER = R.id.beverage_recycler_view;

    private final Recycler mCoffeeList = new Recycler("Список кофе", withId(ID_COFFEE_RECYCLER));

    /**
     * выбрать кофе по названию из списка
     *
     * @param coffee название кофе
     */
    public void chooseCoffee(String coffee) {
        mCoffeeList.clickAtItemWithText(coffee);
    }

    /**
     * @return список кофе
     */
    public Recycler listCoffee() {
        return mCoffeeList;
    }
}
