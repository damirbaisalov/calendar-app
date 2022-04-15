package com.example.calendar_app.day_detailed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.calendar_app.R

class DayActivity : AppCompatActivity() {

    private lateinit var titleTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var backImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day)
        init()

        val sessionTitle = intent.getStringExtra("day_title")
        val sessionDescription = intent.getStringExtra("day_description")

        titleTextView.text = sessionTitle
        descriptionTextView.text = sessionDescription

        backImageView.setOnClickListener {
            onBackPressed()
        }
    }

    private fun init() {
        titleTextView = findViewById(R.id.day_activity_title)
        descriptionTextView = findViewById(R.id.day_activity_description)
        backImageView = findViewById(R.id.day_activity_back)
    }
}