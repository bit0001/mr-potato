package com.mathsistor.m.mrpotato;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.app.ActionBar;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by m on 11/6/2016.
 */

@RunWith(AndroidJUnit4.class)
public class LaunchTest {

    @Rule
    public ActivityTestRule<MrPotatoActivity> mrPotatoActivityActivityTestRule =
            new ActivityTestRule<>(MrPotatoActivity.class);

    @Test
    public void testBasicUIIsDisplayed() throws Exception {
        ActionBar supportActionBar = mrPotatoActivityActivityTestRule.getActivity().getSupportActionBar();
        assertThat(supportActionBar.isShowing(), is(false));

        onView(withId(R.id.mr_potato_title)).check(matches(withText("Mr. Potato Head")));
        onView(withId(R.id.mr_potato_body)).check(matches(isDisplayed()));
        onView(withId(R.id.mr_potato_parts)).check(matches(isDisplayed()));
    }

}
