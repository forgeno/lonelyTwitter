package ca.ualberta.cs.lonelytwitter;


import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ima on 1/17/17.
 */

public abstract class Tweet implements Tweetable{
        private Date date;
        private String message;
        private ArrayList<Moods> moodList;
        //private String hiddenString;

        public Tweet(Date date, String message) throws TweetTooLongException {
            this.date = date;
            this.setMessage(message);
        }

        public Tweet(String message) throws TweetTooLongException {
            this.setMessage(message);
            this.date = new Date(); //current time and date
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 144) {
            throw new TweetTooLongException();
        } else {
            this.message = message;
        }
    }
    public abstract Boolean isImportant();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addMood(Moods mood){
        moodList.add(mood);
    }
    @Override
    public String toString(){
        return date.toString() + " | " + message;

    }
}
