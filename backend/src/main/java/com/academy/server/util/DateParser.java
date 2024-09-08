package com.academy.server.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class DateParser {
    public Date parseDateFromMDY(String inputStringDate, String format) {
        SimpleDateFormat inputFormat = new SimpleDateFormat(format);
        Date parsedDate = null;
        try {
            parsedDate = inputFormat.parse(inputStringDate);
        } catch (ParseException e) {
            return null;
        }
        return new Date(parsedDate.getTime());
    }
}
