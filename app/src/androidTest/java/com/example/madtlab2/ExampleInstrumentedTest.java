package com.example.madtlab2;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testUIComponentsDisplayCorrectly() {
        // Check that all key UI components are displayed
        onView(withId(R.id.text_input)).check(matches(isDisplayed()));
        onView(withId(R.id.count_spinner)).check(matches(isDisplayed()));
        onView(withId(R.id.count_button)).check(matches(isDisplayed()));
        onView(withId(R.id.result_text)).check(matches(isDisplayed()));
    }

    @Test
    public void testWordCountFunctionality() {
        // Select "Words" in the spinner
        onView(withId(R.id.count_spinner)).perform(click());
        onView(withText("Words")).perform(click());

        // Enter a string and close the keyboard
        onView(withId(R.id.text_input)).perform(typeText("Hello world!"), closeSoftKeyboard());

        // Click the count button
        onView(withId(R.id.count_button)).perform(click());

        // Verify the result is correct
        onView(withId(R.id.result_text)).check(matches(withText("Count: 2")));
    }

    @Test
    public void testCharacterCountFunctionality() {
        // Select "Characters" in the spinner
        onView(withId(R.id.count_spinner)).perform(click());
        onView(withText("Characters")).perform(click());

        // Enter a string and close the keyboard
        onView(withId(R.id.text_input)).perform(typeText("Hello world!"), closeSoftKeyboard());

        // Click the count button
        onView(withId(R.id.count_button)).perform(click());

        // Verify the result is correct
        onView(withId(R.id.result_text)).check(matches(withText("Count: 10"))); // Excludes spaces
    }

    @Test
    public void testEmptyInput_ShowsToastMessage() {
        // Click the count button without entering text
        onView(withId(R.id.count_button)).perform(click());

        // Note: Espresso doesn't directly verify Toast messages, but you can ensure
        // UI behavior is unaffected when the input is empty (e.g., result text stays empty).
        onView(withId(R.id.result_text)).check(matches(withText("")));
    }

    @Test
    public void testSpinnerFunctionality() {
        // Verify the initial spinner selection is "Words"
        onView(withId(R.id.count_spinner)).check(matches(withSpinnerText("Words")));

        // Change spinner selection to "Characters"
        onView(withId(R.id.count_spinner)).perform(click());
        onView(withText("Characters")).perform(click());

        // Verify the spinner text changes to "Characters"
        onView(withId(R.id.count_spinner)).check(matches(withSpinnerText("Characters")));
    }
}
