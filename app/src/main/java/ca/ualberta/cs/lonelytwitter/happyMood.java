package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ima on 1/17/17.
 * This is subclass of Moods where Moods is an abstract class.
 * A static mood class that is always "happy"
 * @author ima
 * @version 1.0
 */

public class happyMood extends Moods {
    /**
     *Sets a Mood object to be of "happy" mood.
     * @param date
     */
    public happyMood(Date date) {
        super(date,"I'm Happy.");
    }
    /**
     *Sets a Mood object to be of "happy" mood while not requiring a date to set.
     */

    public happyMood() {
        super("I'm Happy.");
    }

    /**
     * Another method that requires no pramaters but returns a string for mood.
     * @return String "I'm Happy"
     */
    public String moodStatus() {
        return String.format("I'm Happy.");
    }
}
