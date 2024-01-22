package ch.paixon.exercise_testing;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTests {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityRule = new ActivityScenarioRule (MainActivity.class);

    @Test
    public void addDoesAdd1OnCounterValue() {
        // Find counterValue-View and check initial state is "0"
        onView(withId(R.id.counterValue)).check(matches(withText("0")));

        // Perform a click on the "Add 1" button
        onView(withId(R.id.buttonAdd)).perform(click());

        // Find the counterValue-View and check whether the new text is "1"
        onView(withId(R.id.counterValue)).check(matches(withText("1")));
    }
}
