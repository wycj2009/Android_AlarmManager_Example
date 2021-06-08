package com.example.android_alarmmanager_example

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import java.time.LocalDateTime

class DateChangedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        //0시마다 초기화 해야할것들 다 초기화

        Utils.setAllEvents(context) //모든 이벤트 세팅 (앱 실행 시 or 디바이스 부팅 시)

        Utils.updateText(context, "DateChangedReceiver : " + LocalDateTime.now().toString())
    }

}