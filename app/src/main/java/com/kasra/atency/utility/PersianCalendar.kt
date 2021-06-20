package com.kasra.bime.utility

import android.content.Context
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