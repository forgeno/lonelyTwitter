package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.in;

/**
 * Created by ima on 2/14/17.
 */

public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    private Integer i = 0;
    private Integer counter = 0;
    private Integer counter2 = 0;
    public void add (Tweet tweet){
        tweets.add(tweet);
    }

    public boolean hasTweet (Tweet tweet){
        return tweets.contains(tweet);
    }
    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }
    public Tweet getTweet(int index){
        return tweets.get(index);
    }
    public void addTweet(Tweet tweet) throws IllegalArgumentException {
        if (tweets.contains(tweet)){
            //Do Something!
            throw new IllegalArgumentException();
        }
        tweets.add (tweet);
    }

    public List getTweets(){
        List list = tweets;
        Collections.sort(list);
        return list;
    }

    public int getCount (){
        return tweets.size();
    }

}
