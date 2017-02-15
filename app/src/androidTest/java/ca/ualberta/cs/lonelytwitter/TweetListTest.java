package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by ima on 2/14/17.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2{

    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");

        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another Test Tweet");
        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
        assertEquals(returnedTweet.getDate(), tweet.getDate());
    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Last Tweet");

        tweets.add(tweet);
        tweets.delete(tweet);

        assertFalse(tweets.hasTweet(tweet));
    }

    public void testStrings(){
        assertEquals("'test' should be 'test'", "test", "test");
        assertTrue("'test' should start with 't'","test".startsWith("t"));
    }

    public void testDup(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Dup Tweet");
        //assertFalse(tweets.hasTweet(""));
        try {
            tweets.addTweet(tweet);
            tweets.addTweet(tweet);
            assertTrue(false);
        }
        catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }


    public void testGetTweets(){
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("1");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            assertTrue(false);
        }
        Tweet tweet2 = new NormalTweet("2");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            assertTrue(false);
        }
        Tweet tweet3 = new NormalTweet("3");

        tweets.add(tweet3);
        tweets.add(tweet2);
        tweets.add(tweet1);


        List list = tweets.getTweets();

        assertEquals(list.get(0), tweet1);
        assertEquals(list.get(1), tweet2);
        assertEquals(list.get(2), tweet3);
        //int i;
        //for (i=1;i<tweets.getCount();i++){
         //   assertTrue(tweets.getTweet(i-1).getDate().before(tweets.getTweet(i).getDate()));
        //}
    }

    //public void equalTweet()

    public void testSizeTest(){
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("1");
        tweets.add(tweet1);
        assertEquals(tweets.getCount(), 1);
        tweets.delete(tweet1);
        assertEquals(tweets.getCount(), 0);

    }
    public void testEqualTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("1");
        assertFalse(tweets.hasTweet(tweet1));
        tweets.add(tweet1);
        assertTrue(tweets.hasTweet(tweet1));
    }
}
