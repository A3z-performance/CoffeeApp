package nl.testchamber.mailordercoffeeshop.elements;

import android.view.View;

import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.ViewInteraction;

import static androidx.test.espresso.action.ViewActions.click;

import org.hamcrest.Matcher;

import static androidx.test.espresso.Espresso.onView;

public class Element {

    protected Matcher<View> mMatcher;
    private final String mName;

    /**
     * Конструктор класса
     *
     * @param name    имя элемента
     * @param matcher матчер элемента
     */
    public Element(String name, Matcher<View> matcher) {
        mName = name;
        mMatcher = matcher;
    }

    /**
     * Вернуть обькет ViewInteraction для элемента
     *
     * @return обькет ViewInteraction для элемента
     */
    protected ViewInteraction getView() {
        return onView(mMatcher);
    }

    public void clickAtElement() {
        getView().perform(click());
    }

    /**
     * вернуть имя элемента
     *
     * @return имя элемента
     */
    public String getName() {
        return mName;
    }

    /**
     * Выполнить произвольный ассерт элемента
     *
     * @param assertion проверка для ViewInteraction данного UI-элемента
     */
    public void check(ViewAssertion assertion) {
        getView().check(assertion);
    }

    /**
     * преобразовать обьект к строке
     *
     * @return результат преобразования
     */
    @Override
    public String toString() {
        return getName();
    }
}
