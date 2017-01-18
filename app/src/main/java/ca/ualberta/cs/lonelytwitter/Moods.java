package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ima on 1/17/17.
 */

public abstract class Moods {
    private String mood;
    private Date date;

    public Moods(Date date, String mood){
        this.date = date;
        this.setMood(mood);
    }

    public Moods(String mood) {
        this.setMood(mood);
        this.date = new Date(); //current time and date
    }

    public Moods(){
        this.mood = ":)";
    }
    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public abstract String moodStatus();
}
