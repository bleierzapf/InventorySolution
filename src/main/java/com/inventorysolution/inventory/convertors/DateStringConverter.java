package com.inventorysolution.inventory.convertors;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateStringConverter {
    public Timestamp stringToDatetimeConverter (String stringDateTime) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/YY hh:mm", Locale.ENGLISH);
        Timestamp dateInString = (Timestamp) format.parse(stringDateTime);
        return dateInString;
    }
}
