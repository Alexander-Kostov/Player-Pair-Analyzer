package com.academy.server.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class DateParser {
    private static final String STANDARD_FORMAT = "yyyy-MM-dd";
    private static final String[] POSSIBLE_FORMATS = {
            "M/d/yyyy",        // 1/7/2024
            "MM/dd/yyyy",      // 01/07/2024
            "yyyy-MM-dd",      // 2024-10-03 (Standard)
            "yyyy-MM-dd",      // 1998-09-07
            "dd/MM/yyyy",      // 07/09/1998
            "yyyy-MM-ddXXX",   // 1999-03-22+01:00
            "yyyyMMdd",        // 19990322
            "yyyy-M-d",        // 1999-3-22
            "dd.MM.yyyy.",     // 22.03.1999.
    };

    public Date parse(String inputDateStr) {
        Date date = parseDate(inputDateStr);

        if (date == null) {
            System.out.println("Date format not recognized for date: " + inputDateStr);
        }

        return date;
    }

    private Date parseDate(String inputDateStr) {
        for (String format : POSSIBLE_FORMATS) {
            SimpleDateFormat inputFormat = new SimpleDateFormat(format);
            try {
                return inputFormat.parse(inputDateStr);
            } catch (ParseException e) {
                continue;
            }
        }
        return null;
    }

    public String formatToStandardDate(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat targetFormat = new SimpleDateFormat(STANDARD_FORMAT);
        return targetFormat.format(date);
    }
}
