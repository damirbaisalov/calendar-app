package com.example.calendar_app

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.applandeo.materialcalendarview.CalendarDay
import com.applandeo.materialcalendarview.CalendarView
import com.applandeo.materialcalendarview.utils.getMonthsToDate
import com.example.calendar_app.models.Database
import com.example.calendar_app.models.DayData
import java.text.SimpleDateFormat
import java.time.Year
import java.time.temporal.ChronoField
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var calendarView: CalendarView
    private lateinit var button: Button
    private lateinit var list: MutableList<DayData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setLocale()

        init()

//        getCurrentDate()

        button.setOnClickListener {
            val dateFormatDay = SimpleDateFormat("d")
            val dateFormatMonth = SimpleDateFormat("M")
            val date = Date()
//            val text = dateFormatDay.format(calendarView.selectedDates[0]) + " " +dateFormatMonth.format(calendarView.selectedDates[0])
//            for (day in list) {
//                if (day.date==text) {
//                    showToast(day.description)
//                }
//            }

            showToast(calendarView.selectedDates[0].time.toString())
        }

//        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
//
//            val message = dayOfMonth.toString() + " " + (month+1)
//            for (day in list) {
//                if (message==day.date)
//                {
//                    showToast(day.description)
//                }
//            }
//        }

    }

    private fun init() {
        list = Database.dayDatabase
        calendarView = findViewById(R.id.calendar_view)
        calendarView.setHeaderColor(R.color.color_1)
        calendarView.setHeaderLabelColor(R.color.color_2)
        button = findViewById(R.id.button)

        val calendars: List<Calendar> = ArrayList()
        calendarView.selectedDates = calendars

        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val text = "0000-04-15"
        val date = formatter.parse(text)

        val calendar = Calendar.getInstance()
        calendar.set(calendar.get(0), date.month, date.day)


//        val stringDate = "15-Aug"
//        val formatter = SimpleDateFormat("dd-MM")
//        val date = formatter.parse(stringDate)

        val list2 = listOf(
            CalendarDay(calendar).apply {
                labelColor = android.R.color.holo_red_dark
                backgroundResource = R.drawable.bg_gradient
                selectedLabelColor = android.R.color.holo_blue_light
                selectedBackgroundResource = R.drawable.bg_button_gradient
            }
        )

        calendarView.setCalendarDays(list2)
    }

//    private fun changeColorOfDates() {
//        val calendar = Calendar.getInstance()
//        for (day in list) {
//            if (calendarView.date==day.date)
//            {
//                showToast(calendar.get(0).toString())
//                calendarView.dateTextAppearance = R.style.CalenderViewWeekCustomText
//            }
//        }
//
//
//    }

//    private fun getCurrentDate() {
//        val selectedDate = calendarView.date
//        val calendar = Calendar.getInstance()
//        calendar.timeInMillis = selectedDate
//        val dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM)
//        currentDateTextView.text = "${dateFormatter.format(calendar.time)}"
//    }

    private fun setLocale() {

        val locale = Locale("kk")
        val res = resources
        val dm = res.displayMetrics
        val conf = res.configuration
        conf.locale = locale
        res.updateConfiguration(conf, dm)
    }


    private fun showToast(text: String) {
        Toast.makeText(
            this@MainActivity,
            text,
            Toast.LENGTH_SHORT
        ).show()
    }
}