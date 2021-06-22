package com.kasra.atency.utility;


import android.content.Context;

import com.example.bilerplatemvvm.R;
import com.kasra.atency.utility.enums.MyEnums;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import io.sentry.Sentry;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;
import saman.zamani.persiandate.PersianDate;
import saman.zamani.persiandate.PersianDateFormat;

public class MyDateConverts {

    public static PersianCalendar convertDateToPersianDate(String date) {
        PersianCalendar persianDate = new PersianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat(String.valueOf(MyEnums.getTime.BYTIMEZONE), Locale.US);
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(date);
        } catch (ParseException e) {
            Sentry.captureException(e);
        }
        int year = Integer.valueOf(new SimpleDateFormat("yyyy", Locale.US).format(convertedDate.getTime()));
        int month = Integer.valueOf(new SimpleDateFormat("MM", Locale.US).format(convertedDate.getTime()));
        int day = Integer.valueOf(new SimpleDateFormat("dd", Locale.US).format(convertedDate.getTime()));
        persianDate.set(year, month - 1, day);
        return persianDate;
    }

    public static String convertDateToTime(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(String.valueOf(MyEnums.getTime.WITHOUTIMEZONE), Locale.US);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.US);
        Date fromTime = new Date();
        try {
            fromTime = dateFormat.parse(date);
        } catch (ParseException e) {
            Sentry.captureException(e);
        }
        return timeFormat.format(fromTime);
    }

    public static Date convertStringToDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(String.valueOf(MyEnums.getTime.BYTIMEZONE), Locale.US);
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(date);
        } catch (ParseException e) {
            Sentry.captureException(e);
        }
        return convertedDate;
    }

    public static Date convertStringToDateWithoutHour(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(String.valueOf(MyEnums.getTime.WITHOUTHOUR), Locale.US);
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(date);
        } catch (ParseException e) {
            Sentry.captureException(e);
        }
        return convertedDate;
    }

    public static String convertDateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(String.valueOf(MyEnums.getTime.BYTIMEZONE), Locale.US);
        String convertedDate;
        convertedDate = dateFormat.format(date);
        return convertedDate;
    }

    public static String convertDateToSpeechTextWithDayOfWeek(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(String.valueOf(MyEnums.getTime.SPEECHTEXTDATE), Locale.US);
        String convertedDate;
        convertedDate = dateFormat.format(date);
        return convertedDate;
    }

    public static String convertDateToPersianSpeechTextWithDayOfWeek(String date) {
        PersianCalendar persianCalendar = convertDateToPersianDate(date);
        PersianDate pdate = new PersianDate();
        PersianDateFormat pdformater = new PersianDateFormat("l j F Y");
        pdate.setShYear(persianCalendar.getPersianYear());
        pdate.setShMonth(persianCalendar.getPersianMonth());
        pdate.setShDay(persianCalendar.getPersianDay());
        return pdformater.format(pdate);
    }

    public static String convertDateToPersianSpeechText(String date) {
        PersianCalendar persianCalendar = convertDateToPersianDate(date);
        PersianDate pdate = new PersianDate();
        PersianDateFormat pdformater = new PersianDateFormat("j F Y");
        pdate.setShYear(persianCalendar.getPersianYear());
        pdate.setShMonth(persianCalendar.getPersianMonth());
        pdate.setShDay(persianCalendar.getPersianDay());
        return pdformater.format(pdate);
    }

    public static String convertDateToPersianSpeechTextWithoutYear(String date) {
        PersianCalendar persianCalendar = convertDateToPersianDate(date);
        PersianDate pdate = new PersianDate();
        PersianDateFormat pdformater = new PersianDateFormat("j F");
        pdate.setShYear(persianCalendar.getPersianYear());
        pdate.setShMonth(persianCalendar.getPersianMonth());
        pdate.setShDay(persianCalendar.getPersianDay());
        return pdformater.format(pdate);
    }

    public static String convertDateToPersianSpeechTextWithDayOfWeekAndTodayOrYesterday(String date, Context context) {
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());
        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DAY_OF_YEAR, -1);
        Calendar day = Calendar.getInstance();
        day.setTime(MyDateConverts.convertStringToDate(date));

        if (day.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                day.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR)) {
            return context.getResources().getString(R.string.today);
        } else if (day.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                day.get(Calendar.DAY_OF_YEAR) == yesterday.get(Calendar.DAY_OF_YEAR)) {
            return context.getResources().getString(R.string.yesterday);
        } else {
            return MyDateConverts.convertDateToPersianSpeechText(date);
        }
    }

    public static String convertDateToPersianSpeechTextWithoutYearAndTodayOrYesterday(String date, Context context) {
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());
        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DAY_OF_YEAR, -1);
        Calendar day = Calendar.getInstance();
        day.setTime(MyDateConverts.convertStringToDate(date));

        if (day.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                day.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR)) {
            return context.getResources().getString(R.string.today);
        } else if (day.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                day.get(Calendar.DAY_OF_YEAR) == yesterday.get(Calendar.DAY_OF_YEAR)) {
            return context.getResources().getString(R.string.yesterday);
        } else {
            return MyDateConverts.convertDateToPersianSpeechTextWithoutYear(date);
        }
    }
}
