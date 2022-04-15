package com.example.calendar_app.models

import android.os.Parcelable
import com.prolificinteractive.materialcalendarview.CalendarDay
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DayData(
    var id: String,
    var date: String,
    var month: String,
    var day: String,
    var description: String
): Parcelable