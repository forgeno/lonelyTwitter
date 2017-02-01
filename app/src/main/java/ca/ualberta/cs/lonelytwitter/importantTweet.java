package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ima on 1/17/17.
 */
public class importantTweet extends Tweet {
    /**
     * Instantiates a new Important tweet.
     * A subclass of Tweet which contains a flag or required boolean to be true
     *
     * @param date    the date
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public importantTweet(Date date, String message) throws TweetTooLongException {
        super(date, message);
    }

    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public importantTweet(String message) throws TweetTooLongException {
        super(message);
    }

    /**
     * A flag where isImportant than
     * @return
     */
    public Boolean isImportant(){
        return Boolean.TRUE;
    }
}
