package nl.testchamber.mailordercoffeeshop.screenRobots;

import nl.testchamber.mailordercoffeeshop.R;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class CustomOrderScreenRobot extends BaseScreenRobot {

    private int lessEspressoButton = R.id.less_espresso;
    private int reviewOrderButton =  R.id.review_order;
    private int menuButtonId = R.id.use_menu;
    private int customOrderTitle = R.id.custom_order_title;

    public CustomOrderScreenRobot(){
        getViewInteraction(customOrderTitle).check(matches(withText("Customize your order")));
    }

    public MenuScreenRobot openMenu() {
        clickButton(menuButtonId);
        return new MenuScreenRobot();
    }

    public CustomOrderScreenRobot lessEspresso(){
        clickButton(lessEspressoButton);
        return this;
    }

    public OrderScreenRobot reviewOrder(){
        clickButton(reviewOrderButton);
        return  new OrderScreenRobot();
    }

}
