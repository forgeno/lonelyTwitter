package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

import io.searchbox.annotations.JestId;

public abstract class Tweet implements Tweetable, Comparable<Tweet> {
    private String message;
    private Date date;
    @JestId
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    @Override
    public String toString(){
        return message;
    }

    public abstract Boolean isImportant();


    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140){
            //Do Something!
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public int compareTo(Tweet o) {
        return getDate().compareTo(o.getDate());
    }


}
