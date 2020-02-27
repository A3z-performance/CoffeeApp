package nl.testchamber.mailordercoffeeshop.elements;

import android.view.View;

import org.hamcrest.Matcher;

import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;

public class TextEdit extends Element {

    public TextEdit(String name, Matcher<View> matcher){
        super(name, matcher);
    }

    public void fillEditText(String text) {
        getView().perform(replaceText(text), closeSoftKeyboard());
    }
}
