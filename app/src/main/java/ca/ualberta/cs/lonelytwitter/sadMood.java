package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ima on 1/17/17.
 * sadClass that is used when user needs a static mood of sad.
 */
public class sadMood extends Moods {
    /**
     * Instantiates a new Sad mood.
     * @param date the date
     * @param mood the mood
     */
    public sadMood(Date date, String mood) {
        super(date, mood);
    }

    /**
     * Instantiates a new Sad mood.
     *
     * @param mood the mood
     */
    public sadMood(String mood) {
        super(mood);
    }


    /**
     * A method that always returns i'm sad for mood.
     * @return
     */
    public String moodStatus() {
        return String.format("I'm sad.");
    }
}
