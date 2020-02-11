package nl.testchamber.mailordercoffeeshop.screenRobots;

import androidx.test.espresso.contrib.RecyclerViewActions;

import nl.testchamber.mailordercoffeeshop.R;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MenuScreenRobot extends BaseScreenRobot {

    private int recyclerId = R.id.beverage_recycler_view;

    public MenuScreenRobot() {
        getViewInteraction(recyclerId).check(matches(isDisplayed()));
    }

    public OrderScreenRobot chooseCoffee(String coffee){
        getViewInteraction(recyclerId).perform(RecyclerViewActions.actionOnItem(hasDescendant(withText(coffee)), click()));
        return new OrderScreenRobot();
    }
}
