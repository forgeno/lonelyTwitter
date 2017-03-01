package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testTweet(){
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");

        solo.clickOnButton("Save");

        solo.clearEditText((EditText) solo.getView(R.id.body));

        assertTrue(solo.waitForText("Test Tweet!"));
        solo.clickOnButton("Search");
        assertFalse(solo.searchText("Test Tweet!"));

    }
    public void testClickTweetList(){
        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
        solo.clickOnButton("Search");

        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");
        solo.waitForText("Test Tweet");

        final ListView oldTweetList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetList.getItemAtPosition(0);
        assertEquals("Test Tweet!", tweet.getMessage());

        solo.clickInList(0); //Clicks on first item in list
        solo.assertCurrentActivity("Wrong Activity",EditTweetActivity.class);
        assertTrue(solo.waitForText("TextView"));

        solo.goBack();
        solo.assertCurrentActivity("Wrong Activity",EditTweetActivity.class);


    }

    public void testUIPass(){
        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
        solo.clickOnButton("Search");

        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");
        solo.waitForText("Test Tweet");

        final ListView oldTweetList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetList.getItemAtPosition(0);
        assertEquals("Test Tweet!", tweet.getMessage());

        solo.clickInList(0); //Clicks on first item in list
        solo.assertCurrentActivity("Wrong Activity",EditTweetActivity.class);
        assertTrue(solo.waitForText("Test Tweet!"));

        solo.goBack();
        solo.assertCurrentActivity("Wrong Activity",EditTweetActivity.class);


    }
}