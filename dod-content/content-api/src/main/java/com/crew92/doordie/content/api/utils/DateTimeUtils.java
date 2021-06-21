package com.crew92.doordie.content.api.utils;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtils {

    private DateTimeUtils() {
    }

    private static final DateFormat DATE_FORMAT_KOREAN = DateFormat.getDateInstance(DateFormat.FULL, Locale.KOREA);

    public static String toString(Date date) {
        return DATE_FORMAT_KOREAN.format(date);
    }

}
