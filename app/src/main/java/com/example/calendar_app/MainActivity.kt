package com.example.calendar_app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.calendar_app.day_detailed.DayActivity
import com.example.calendar_app.models.Database
import com.example.calendar_app.models.DayData
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var calendarView: MaterialCalendarView
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
            val year = CalendarDay.today().year
            val month = CalendarDay.today().month
            val dayOfMonth = CalendarDay.today().day

            for (day in list) {
                if ((month== day.month.toInt()-1) && (dayOfMonth == day.day.toInt())) {
                    sendData(
                        title = convertDateToString(year, month, dayOfMonth),
                        description = day.description
                    )
                }
            }
        }

        calendarView.setOnDateChangedListener { widget, date, selected ->
            
            if (!selected) {
                widget.setDateSelected(date,true)

                for (day in list) {
                    if ((date.month == day.month.toInt()-1) && (date.day == day.day.toInt())) {
                        sendData(
                            title = convertDateToString(date.year, date.month, date.day),
                            description = day.description
                        )
                    }
                }
            } else {
                widget.setDateSelected(date,false)
                showToast("Күн табылмады")
            }
        }
    }

    private fun init() {
        list = Database.dayDatabase
        calendarView = findViewById(R.id.calendar_view)
        textView = findViewById(R.id.text_view)
        currentDateTextView = findViewById(R.id.current_date_text_view)
        button = findViewById(R.id.button)

        calendarView.selectionMode = MaterialCalendarView.SELECTION_MODE_MULTIPLE
        setDates()
        calendarView.setAllowClickDaysOutsideCurrentMonth(true)
    }

    private fun setDates() {

        for (day in list) {
            for (y in 2015 until 2025) {
                val calendar = Calendar.getInstance()
                val monthInt = day.month.toInt()-1
                val dayInt = day.day.toInt()
                calendar[y, monthInt] = dayInt
                calendarView.setDateSelected(calendar, true)
            }
        }
    }

    private fun getCurrentDate() {
        val selectedDate = CalendarDay.today()
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = selectedDate.date.time
        val dateFormatter = DateFormat.getDateInstance(DateFormat.LONG, Locale("kk"))
        currentDateTextView.text = "${dateFormatter.format(calendar.time)}"
    }

    private fun sendData(title: String, description: String) {

        val intent = Intent(this, DayActivity::class.java)
        intent.putExtra("day_title", title)
        intent.putExtra("day_description", description)
        startActivity(intent)
    }

    private fun convertDateToString(year: Int, month: Int, dayOfYear: Int): String {

        val selectedDate = CalendarDay.from(year, month, dayOfYear)
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = selectedDate.date.time
        val dateFormatter = DateFormat.getDateInstance(DateFormat.LONG, Locale("kk"))

        return "${dateFormatter.format(calendar.time)}"
    }

    private fun setLocale() {

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

        val toast = Toast.makeText(
            this@MainActivity,
            text,
            Toast.LENGTH_SHORT
        )
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }
}