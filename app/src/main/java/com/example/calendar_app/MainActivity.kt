package com.example.calendar_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var calendarView: CalendarView
    private lateinit var textView: TextView
    private lateinit var currentDateTextView: TextView
    private lateinit var button: Button

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
            showToast(text)
        }

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->

            val message = dayOfMonth.toString() + " " + (month+1)
            Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
        }

    }

    private fun init() {
        calendarView = findViewById(R.id.calendar_view)
        textView = findViewById(R.id.text_view)
        currentDateTextView = findViewById(R.id.current_date_text_view)
        button = findViewById(R.id.button)
    }

    private fun getCurrentDate() {
        val selectedDate = calendarView.date
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = selectedDate
        val dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM)
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

    private fun showToast(text: String) {
        Toast.makeText(
            this@MainActivity,
            text,
            Toast.LENGTH_SHORT
        ).show()
    }
}