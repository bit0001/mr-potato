package com.mathsistor.m.mrpotato;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.app.ActionBar;

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
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class LaunchTest {

    @Rule
    public ActivityTestRule<MrPotatoActivity> mrPotatoActivityActivityTestRule =
            new ActivityTestRule<>(MrPotatoActivity.class);

    @Test
    public void testBasicUIIsDisplayed() throws Exception {
        ActionBar supportActionBar = mrPotatoActivityActivityTestRule.getActivity().getSupportActionBar();
        int[] ids = {
                R.id.arms,
                R.id.ears,
                R.id.eyebrows,
                R.id.eyes,
                R.id.glasses,
                R.id.hat,
                R.id.mouth,
                R.id.mustache,
                R.id.nose,
                R.id.shoes
        };

        assertThat(supportActionBar.isShowing(), is(false));
        onView(withId(R.id.mr_potato_title)).check(matches(withText("Mr. Potato Head")));
        onView(withId(R.id.mr_potato_parts)).check(matches(isDisplayed()));
        onView(withId(R.id.body)).check(matches(isDisplayed()));

        for (int id: ids) {
            onView(withId(id)).check(matches(not(isDisplayed())));
        }
    }



}
