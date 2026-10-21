
package com.example.wordcounter;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> rule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testWordCounting() {
        onView(withId(R.id.editTextInput))
                .perform(typeText("Hi Martas this is my testing hope this works"));

        onView(withId(R.id.spinnerMetric))
                .perform(click());

        onData(anything())
                .atPosition(1)
                .perform(click());

        onView(withId(R.id.buttonCount))
                .perform(click());

        onView(withId(R.id.textViewResult))
                .check(matches(withText("9")));
    }

    @Test
    public void testInputIsVisible() {
        onView(withId(R.id.editTextInput))
                .check(matches(isDisplayed()));
    }
}
