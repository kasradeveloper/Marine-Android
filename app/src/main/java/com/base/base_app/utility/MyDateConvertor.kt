package com.base.base_app.utility

import ir.hamsaa.persiandatepicker.util.PersianCalendar
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MyDateConvertor {
    companion object{
        private val dateFormat:String="yyyy-MM-dd'T'HH:mm:ss"
        fun convertDateToPersianDate(date: String?): PersianCalendar {
            val persianDate = PersianCalendar()
            val dateFormat = SimpleDateFormat(
                dateFormat,
                Locale.US
            )
            var convertedDate = Date()
            try {
                convertedDate = dateFormat.parse(date)
            } catch (e: ParseException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
            val year =
                Integer.valueOf(SimpleDateFormat("yyyy", Locale.US).format(convertedDate.time))
            val month =
                Integer.valueOf(SimpleDateFormat("MM", Locale.US).format(convertedDate.time))
            val day = Integer.valueOf(SimpleDateFormat("dd", Locale.US).format(convertedDate.time))
            persianDate[year, month - 1] = day
            return persianDate
        }

        fun convertDateToTime(date: String?): String? {
            val dateFormat = SimpleDateFormat(
                java.lang.String.valueOf(dateFormat),
                Locale.US
            )
            val timeFormat = SimpleDateFormat("HH:mm", Locale.US)
            var fromTime: Date? = Date()
            try {
                fromTime = dateFormat.parse(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return timeFormat.format(fromTime)
        }

        fun convertStringToDate(date: String?): Date? {
            val dateFormat = SimpleDateFormat(
                java.lang.String.valueOf(dateFormat),
                Locale.US
            )
            var convertedDate: Date? = Date()
            try {
                convertedDate = dateFormat.parse(date)
            } catch (e: ParseException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
            return convertedDate
        }



        fun convertDateToString(date: Date?): String? {
            val dateFormat = SimpleDateFormat(
                java.lang.String.valueOf(dateFormat),
                Locale.US
            )
            return dateFormat.format(date)
        }


    }
}