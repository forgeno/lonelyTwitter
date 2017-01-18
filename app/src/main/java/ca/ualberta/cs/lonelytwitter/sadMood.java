package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ima on 1/17/17.
 */

public class sadMood extends Moods {
    public sadMood(Date date, String mood) {
        super(date, mood);
    }

    public sadMood(String mood) {
        super(mood);
    }

    public String moodStatus() {
        return String.format("I'm sad.");
    }
}
