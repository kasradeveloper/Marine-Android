package com.base.bime.utility

import android.R.attr.typeface
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import ir.hamsaa.persiandatepicker.Listener
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog


class PersianCalendar {

    companion object{
        fun initCalender(context:Context):PersianDatePickerDialog{
            return PersianDatePickerDialog(context)
                .setPositiveButtonString("باشه")
                .setNegativeButton("بیخیال")
                .setTodayButton("امروز")
                .setTodayButtonVisible(true)
                .setMinYear(1370)
                .setMaxYear(1410)
                .setTitleType(PersianDatePickerDialog.WEEKDAY_DAY_MONTH_YEAR)
                .setShowInBottomSheet(true)

        }
    }
}