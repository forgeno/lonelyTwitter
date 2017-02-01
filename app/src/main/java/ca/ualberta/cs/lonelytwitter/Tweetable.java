package ca.ualberta.cs.lonelytwitter;

import android.provider.ContactsContract;

import java.util.Date;

/**
 * Created by ima on 1/17/17.
 */
public interface Tweetable {
    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage();

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate();
}
