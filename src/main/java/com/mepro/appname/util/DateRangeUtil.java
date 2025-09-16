package com.mepro.appname.util;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateRangeUtil {
    private static final Logger logger = LoggerFactory.getLogger(DateRangeUtil.class);
    public static String[] splitDateRange(String rangeStr) {
        if (rangeStr == null || !rangeStr.contains(" - ")) {
            throw new IllegalArgumentException("Format date range tidak valid");
        }

        String[] parts = rangeStr.split(" - ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Format date range tidak valid");
        }

        return new String[]{parts[0].trim(), parts[1].trim()};
    }
    
}
