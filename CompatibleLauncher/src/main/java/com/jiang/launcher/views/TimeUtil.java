package com.jiang.launcher.views;

import android.text.format.Time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * The type Time util.
 */
public final class TimeUtil {

    private TimeUtil() throws InstantiationException {
        throw new InstantiationException("This class is not created for instantiation");
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public static String getTime() {
        String date = getFormattedDate();
        return date.substring(11, date.length() - 3);

    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public static String getDate() {
        String date = getFormattedDate();
        return date.substring(0, 11);
    }

    private static String getFormattedDate() {

        Time time = new Time();
        time.setToNow();
        DateFormat.getDateInstance();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(c.getTime());
    }
}