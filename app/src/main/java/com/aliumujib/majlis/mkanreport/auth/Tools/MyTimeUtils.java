package com.aliumujib.majlis.mkanreport.auth.Tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Attila on 3/5/2017.
 */

public class MyTimeUtils {
    public static final String DATE_FORMAT = "MMMdd";
    public static final String FULL_DATE_FORMAT = "yyyy/MM/dd";
    public static final String MONTH_FORMAT = "MMM";
    public static final String DAY_FORMAT = "dd";
    public static final String YEAR_FORMAT = "yyyy";
    public static final String TITLE_DATE_FORMAT = "MMMM dd";

    public static final String BIRTHDAY_FORMAT = "MMMdd yyyy";


    public static String formatDate(long date_millis, String format) {
        if (!isCurrentYear(date_millis)) {
            format = "yyyy " + format;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date_millis);
    }

    private static boolean isCurrentYear(long date_millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date_millis);
        Calendar current = Calendar.getInstance();
        return calendar.get(Calendar.YEAR) == current.get(Calendar.YEAR);
    }
}
