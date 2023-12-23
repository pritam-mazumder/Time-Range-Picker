package com.example.timerangepicker

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.timerangepicker.databinding.ActivityMainBinding
import nl.joery.timerangepicker.TimeRangePicker

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.picker.setOnTimeChangeListener(object : TimeRangePicker.OnTimeChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onStartTimeChange(startTime: TimeRangePicker.Time) {
                binding.start.text = "Start time:\n${startTime.hour}:${startTime.minute}"
            }

            override fun onEndTimeChange(endTime: TimeRangePicker.Time) {
                Log.d("TimeRangePicker", "End time: " + endTime.hour)
                binding.end.text = "End time:\n${endTime.hour}:${endTime.minute}"
            }

            override fun onDurationChange(duration: TimeRangePicker.TimeDuration) {
                Log.d("TimeRangePicker", "Duration: " + duration.hour)
                binding.duration.text = "Duration:\n${duration.hour}:${duration.minute}"
            }
        })
    }
}