package com.udacity.gradle.builditbigger;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.jokedemo.JokesterActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

// Reference: https://developer.android.com/training/testing/espresso/setup
// Reference: https://developer.android.com/training/testing/espresso/cheat-sheet
@RunWith(AndroidJUnit4.class)
public class JokeTest {

    @Rule
    public IntentsTestRule<MainActivity> mainActivityActivityTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void clickTellJokeButtonReturnsNonEmptyString(){

        // first match the static button text
        onView(withId(R.id.tell_joke_button))
                .check(matches(withText(R.string.button_text)));

        // click the tell joke button
        onView(withId(R.id.tell_joke_button))
                .perform(click());

        intended(hasComponent(JokesterActivity.class.getName()));

        // check that the joke textview displays
        onView(withId(R.id.joke_textview))
                .check(matches(isDisplayed()));

        // check that the joke textview is not an empty string
        onView(withId(R.id.joke_textview))
                .check(matches(not(withText(""))));

        // check that the joke textview does not contain indication that exception was thrown.
        onView(withId(R.id.joke_textview))
                .check(matches(not(withText("Something went wrong. Check the logs."))));

        // check that the joke textview does not contain the static joke textview text
        onView(withId(R.id.joke_textview))
                .check(matches(not(withText(R.string.missing_joke))));
    }
}