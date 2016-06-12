package com.davicaetano.dagtest;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.davicaetano.dagtest.ui.main.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class CalculatorIntegrationTest {
    @Rule public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void TestSimpleSum(){
        float n1 = 13;
        float n2 = 20;
        float r1 = n1 + n2;
        onView(withId(R.id.first_EditText))
                .perform(typeText(Float.toString(n1)));
        onView(withId(R.id.second_EditText))
                .perform(typeText(Float.toString(n2)));
        onView(withId(R.id.spinner))
                .perform(click());
        onData(allOf(is(instanceOf(String.class)),is("+"))).perform(click());
        onView(withId(R.id.ok_button))
                .perform(click());
        onView(withId(R.id.result_editText))
                .check(ViewAssertions.matches(withText(String.valueOf(r1))));
    }
}
