package com.crew92.doordie.content.api.utils;

import org.springframework.format.datetime.DateFormatter;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtils {

    private static final DateFormat DATE_FORMAT_KOREAN = DateFormat.getDateInstance(DateFormat.FULL);

    public static String toString(Date date) {
        return DATE_FORMAT_KOREAN.format(date);
    }

}
