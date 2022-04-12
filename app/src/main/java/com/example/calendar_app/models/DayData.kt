package com.example.calendar_app.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DayData(
    var id: String,
    var date: String,
    var description: String
): Parcelable