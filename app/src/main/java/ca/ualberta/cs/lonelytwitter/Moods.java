package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ima on 1/17/17.
 * Superclass for happyMood and sadMood in which future moods will also be based
 * off of. Provides framework.
 */
public abstract class Moods {
    private String mood;
    private Date date;

    /**
     * Instantiates a new Moods.
     *
     * @param date the date
     * @param mood the mood
     */
    public Moods(Date date, String mood){
        this.date = date;
        this.setMood(mood);
    }

    /**
     * Instantiates a new Moods.
     *
     * @param mood the mood
     */
    public Moods(String mood) {
        this.setMood(mood);
        this.date = new Date(); //current time and date
    }

    /**
     * Instantiates a new Moods.
     */
    public Moods(){
        this.mood = ":)";
    }

    /**
     * Gets mood.
     *
     * @return the mood
     */
    public String getMood() {
        return mood;
    }

    /**
     * Sets mood.
     *
     * @param mood the mood
     */
    public void setMood(String mood) {
        this.mood = mood;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
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
     * Mood status string.
     *
     * @return the string
     */
    public abstract String moodStatus();
}
