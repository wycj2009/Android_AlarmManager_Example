package com.example.android_alarmmanager_example

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    lateinit var activityMainButton1: Button
    lateinit var activityMainTextView1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityMainButton1 = findViewById(R.id.activity_main_button_1)
        activityMainTextView1 = findViewById(R.id.activity_main_textview_1)

        activityMainTextView1.text = SharedPreferencesManager.getString(this, "alarmLog")

        activityMainButton1.setOnClickListener {
            Utils.setAllEvents(this) //모든 이벤트 세팅 (앱 실행 시 or 디바이스 부팅 시)

            Utils.updateText(this, "registed : " + LocalDateTime.now())
        }
    }

}