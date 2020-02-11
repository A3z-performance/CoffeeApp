package nl.testchamber.mailordercoffeeshop.screenRobots;

import static androidx.test.espresso.Espresso.onView;
import androidx.test.espresso.ViewInteraction;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public abstract class BaseScreenRobot {

    protected void fillEditText(int editTextId, String text) {
        getViewInteraction(editTextId).perform(replaceText(text), closeSoftKeyboard());
    }

    protected void clickButton(int buttonId) {
        getViewInteraction(buttonId).perform(click());
    }

    protected ViewInteraction getViewInteraction(int viewId){
        return onView(withId(viewId));
    }
}
