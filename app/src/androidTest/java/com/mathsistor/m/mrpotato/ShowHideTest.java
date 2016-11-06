package com.mathsistor.m.mrpotato;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ImageView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class ShowHideTest {

    private static Map<Integer, Integer> imageCheckboxIds;

    static {
        imageCheckboxIds = new HashMap<>();
        imageCheckboxIds.put(R.id.arms, R.id.arms_checkbox);
        imageCheckboxIds.put(R.id.ears, R.id.ears_checkbox);
        imageCheckboxIds.put(R.id.eyebrows, R.id.eyebrows_checkbox);
        imageCheckboxIds.put(R.id.eyes, R.id.eyes_checkbox);
        imageCheckboxIds.put(R.id.glasses, R.id.glasses_checkbox);
        imageCheckboxIds.put(R.id.hat, R.id.hat_checkbox);
        imageCheckboxIds.put(R.id.mouth, R.id.mouth_checkbox);
        imageCheckboxIds.put(R.id.mustache, R.id.mustache_checkbox);
        imageCheckboxIds.put(R.id.nose, R.id.nose_checkbox);
        imageCheckboxIds.put(R.id.shoes, R.id.shoes_checkbox);

    }

    @Rule
    public ActivityTestRule<MrPotatoActivity> mrPotatoActivityActivityTestRule =
            new ActivityTestRule<>(MrPotatoActivity.class);

    @Test
    public void testPartsAreShownAndHiddenWhenCheckingAndUncheckingBox() throws Exception {
        for (Map.Entry<Integer, Integer> entry : imageCheckboxIds.entrySet()) {
            Integer imageId = entry.getKey();
            Integer checkboxId = entry.getValue();

            onView(withId(checkboxId)).perform(click());
            onView(withId(imageId)).check(matches(isDisplayed()));
            onView(withId(checkboxId)).perform(click());
            onView(withId(imageId)).check(matches(not(isDisplayed())));
        }
    }
}
