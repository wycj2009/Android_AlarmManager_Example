package com.example.android_alarmmanager_example

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import java.time.LocalDateTime

class InputWeightNotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Utils.updateText(context, "InputWeightNotificationReceiver : " + LocalDateTime.now().toString())
    }

}