package main.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {

    public static Date stringToDate_Date(String a) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date t = ft.parse(a);
        return t;
    }

    public static Date stringToDate_Time(String a) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat("HH:mm");
        Date t = ft.parse(a);
        return t;
    }

    public static Date stringToDate_DateTime(String a) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date t = ft.parse(a);
        return t;
    }

    public static String dateToString_Date(Date t) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        return ft.format(t);
    }

    public static String dateToString_Time(Date t) {
        SimpleDateFormat ft = new SimpleDateFormat ("HH:mm");
        return ft.format(t);
    }

    public static String dateToString_DateTime(Date t) {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm");
        return ft.format(t);
    }
}
