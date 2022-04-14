package com.example.calendar_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.calendar_app.models.Database
import com.example.calendar_app.models.DayData
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var calendarView: CalendarView
    private lateinit var textView: TextView
    private lateinit var currentDateTextView: TextView
    private lateinit var button: Button
    private lateinit var list: MutableList<DayData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setLocale()

        init()

        getCurrentDate()

        button.setOnClickListener {
            val dateFormatDay = SimpleDateFormat("d")
            val dateFormatMonth = SimpleDateFormat("M")
            val date = Date()
            val text = dateFormatDay.format(date) + " " +dateFormatMonth.format(date)
            for (day in list) {
                if (day.date==text) {
                    showToast(day.description)
                }
            }
        }

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->

            val message = dayOfMonth.toString() + " " + (month+1)
            for (day in list) {
                if (message==day.date)
                {
                    showToast(day.description)
                }
            }
        }

    }

    private fun init() {
        list = Database.dayDatabase
        calendarView = findViewById(R.id.calendar_view)
        textView = findViewById(R.id.text_view)
        currentDateTextView = findViewById(R.id.current_date_text_view)
        button = findViewById(R.id.button)
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

    private fun getCurrentDate() {
        val selectedDate = calendarView.date
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = selectedDate
        val dateFormatter = DateFormat.getDateInstance(DateFormat.LONG, Locale("kk"))
        currentDateTextView.text = "${dateFormatter.format(calendar.time)}"
    }

    private fun setLocale() {

//        val language = "kk"
//        val locale = Locale(language)
//        Locale.setDefault(locale)
//        val config = Configuration()
//        config.locale = locale
//        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        val locale = Locale("kk")
        val res = resources
        val dm = res.displayMetrics
        val conf = res.configuration
        conf.locale = locale
        res.updateConfiguration(conf, dm)
    }

    private fun changeStatusBarMode(id: Int) {
        val window: Window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = ContextCompat.getColor(this, id)
    }

    private fun showToast(text: String) {
        Toast.makeText(
            this@MainActivity,
            text,
            Toast.LENGTH_SHORT
        ).show()
    }
}