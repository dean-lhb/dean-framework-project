package org.deanframework.common.util;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

/**
 * @auther Dean
 */
public class TimeUtil {

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM = "yyyy-MM";
    public static final String yyyyMMdd = "yyyyMMdd";
    public static final String YYYY = "yyyy";
    public static final String MM = "MM";
    public static final String DD = "dd";
    public static final String UTC_TIME_ZONE = "GMT-0";

    public static String getUtcDateTime() {
        return getTime(YYYY_MM_DD_HH_MM_SS, UTC_TIME_ZONE);
    }

    public static String getDateTime() {
        return getTime(YYYY_MM_DD_HH_MM_SS, null);
    }

    public static String getTimeForYearMonthDay() {
        return getTime(YYYY_MM_DD, null);
    }

    public static String getTimeForYearMonth() {
        return getTime(YYYY_MM, null);
    }

    public static String getTimeForYear() {
        return getTime(YYYY, null);
    }

    public static String getTimeForMonth() {
        return getTime(MM, null);
    }

    public static String getTimeForDay() {
        return getTime(DD, null);
    }

    public static String getTime(String format, String timeZone) {
        return getTime(format, System.currentTimeMillis(), timeZone);
    }

    public static String getTime(String format, long timestamp, String timeZone) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setTimeZone(Objects.isNull(timeZone) ? TimeZone.getDefault() : TimeZone.getTimeZone(timeZone));
        return dateFormat.format(timestamp);
    }

    public static String formatToUtcDateTime(long timestamp) {
        return getTime(YYYY_MM_DD_HH_MM_SS, timestamp, UTC_TIME_ZONE);
    }

    public static String formatToDateTime(long timestamp) {
        return getTime(YYYY_MM_DD_HH_MM_SS, timestamp, null);
    }

    public static Date formatToUtcDate(String time) {
        return formatToDate(time, UTC_TIME_ZONE);
    }

    public static Date formatToDate(String time) {
        return formatToDate(time, null);
    }

    public static Date convertDefaultToUtc(String time) {
        return convertTimeZone(time, YYYY_MM_DD_HH_MM_SS, TimeZone.getDefault(), TimeZone.getTimeZone(UTC_TIME_ZONE));
    }

    public static Date convertUtcToDefault(String time) {
        return convertTimeZone(time, YYYY_MM_DD_HH_MM_SS, TimeZone.getTimeZone(UTC_TIME_ZONE), TimeZone.getDefault());
    }

    public static Date getUtcDate() {
        return getDate(UTC_TIME_ZONE);
    }

    public static Date getDate() {
        return getDate(null);
    }

    public static Date getDate(String timeZone) {
        return formatToDate(null, timeZone);
    }

    public static Date formatToDate(String time, String timeZone) {
        DateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        dateFormat.setTimeZone(Objects.isNull(timeZone) ? TimeZone.getDefault() : TimeZone.getTimeZone(timeZone));
        return dateFormat.parse(Objects.isNull(time) ? dateFormat.format(new Date()) : time, new ParsePosition(0));
    }

    public static Date convertTimeZone(String time, String format, TimeZone sourceTimeZone, TimeZone targetTimeZone) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Long sourceTimestamp = dateFormat.parse(time, new ParsePosition(0)).getTime();
        Long sourceTime = sourceTimestamp - sourceTimeZone.getRawOffset();
        Long targetTime = sourceTime + targetTimeZone.getRawOffset();
        Date date = new Date(targetTime);
        return date;
    }

    public static Date addDayOfDate(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, day);
        Date newDate = c.getTime();
        return newDate;
    }

    public static Date subtractDayOfDate(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, c.get(Calendar.DATE) - day);
        Date newDate = c.getTime();
        return newDate;
    }

    public static Date subtractHourOfDate(Date date, int hour) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR, c.get(Calendar.HOUR) - hour);
        Date newDate = c.getTime();
        return newDate;
    }

    public static Date subtractMonthOfDate(Date date, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, c.get(Calendar.MONTH) - month);
        Date newDate = c.getTime();
        return newDate;
    }
}
