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
import nl.testchamber.mailordercoffeeshop.screenRobots.CustomOrderScreenRobot;

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

@RunWith(AndroidJUnit4.class)
public class EspressoWorkshopTest {

    @Rule
    public IntentsTestRule<MainActivity> intentTestRule = new IntentsTestRule<>(MainActivity.class);


    @Before
    public void closeInfoScreen() {
        onView(withId(R.id.close_button)).perform(click());
    }

    @Test
    public void toastWithLessThenZeroEspresso() {
        String toastMsg = "You can't order less than zero espresso shots";
        new CustomOrderScreenRobot().lessEspresso();
        onView(withText(toastMsg))
                .inRoot(withDecorView(not(is(intentTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));

    }

    @Test
    public void orderZeroEspressoToast(){
        String toastMsg = "A minimum of 1 Espresso shot is required for each order";
        new CustomOrderScreenRobot().reviewOrder();
        onView(withText(toastMsg))
                .inRoot(withDecorView(not(is(intentTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

    @Test
    public void sendMailIntentTest() {
        String coffee = "Breve";
        String buyerName = "Andrew";
        String buyerMail = "example@gmail.com";

        new CustomOrderScreenRobot()
                .openMenu()
                .chooseCoffee(coffee)
                .setName(buyerName)
                .setEmail(buyerMail)
                .submitOrder();

        intended(allOf(hasAction(Intent.ACTION_SENDTO), hasData("mailto:")));

    }

}

