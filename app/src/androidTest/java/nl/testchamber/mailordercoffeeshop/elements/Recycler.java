package nl.testchamber.mailordercoffeeshop.elements;

import android.view.View;

import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.contrib.RecyclerViewActions;

import org.hamcrest.Matcher;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * класс для работы с UI-обьектом на основе RecyclerView
 */
public class Recycler extends Element {

    public Recycler(String name, Matcher<View> matcher) {
        super(name, matcher);
    }

    /**
     * Кликнуть по элементу с определенным текстом
     *
     * @param text текст в элементе
     */
    public void clickAtItemWithText(String text) {
        getView().perform(RecyclerViewActions.actionOnItem(hasDescendant(withText(text)), click()));
    }


    /**
     * Выполнить скролл до элемента списка в определенной позиции
     *
     * @param position позиция в списке
     */
    public void scrollTo(int position) {
        getView().perform(scrollToPosition(position));
    }
}
