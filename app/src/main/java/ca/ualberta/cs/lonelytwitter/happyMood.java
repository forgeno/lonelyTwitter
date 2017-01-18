package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ima on 1/17/17.
 */

public class happyMood extends Moods {
    public happyMood(Date date) {
        super(date,"I'm Happy.");
    }

    public happyMood() {
        super("I'm Happy.");
    }

    public String moodStatus() {
        return String.format("I'm Happy.");
    }
}
