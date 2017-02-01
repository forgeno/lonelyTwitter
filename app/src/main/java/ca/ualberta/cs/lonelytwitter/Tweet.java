package ca.ualberta.cs.lonelytwitter;


import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ima on 1/17/17.
 * Tweet class is a super class that implements tweetable
 */
public abstract class Tweet implements Tweetable{
        private Date date;
        private String message;
        private ArrayList<Moods> moodList;
        //private String hiddenString;

    /**
     * Instantiates a new Tweet.
     *
     * @param date    the date
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public Tweet(Date date, String message) throws TweetTooLongException {
            this.date = date;
            this.setMessage(message);
        }

    /**
     * Instantiates a new Tweet.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public Tweet(String message) throws TweetTooLongException {
            this.setMessage(message);
            this.date = new Date(); //current time and date
    }

    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 144) {
            throw new TweetTooLongException();
        } else {
            this.message = message;
        }
    }

    /**
     * Is important boolean.
     *
     * @return the boolean
     */
    public abstract Boolean isImportant();

    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Add mood.
     *
     * @param mood the mood
     */
    public void addMood(Moods mood){
        moodList.add(mood);
    }
    @Override
    public String toString(){
        return date.toString() + " | " + message;

    }
}
