package com.example.android_alarmmanager_example

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

object Utils {

    fun updateText(context: Context, str: String) {
        var previousLog: String = SharedPreferencesManager.getString(context, "alarmLog")!!
        previousLog += "\n${str}"
        SharedPreferencesManager.setString(context, "alarmLog", previousLog)
    }

    //모든 이벤트 세팅 (앱 실행 시 or 디바이스 부팅 시)
    fun setAllEvents(context: Context) {
        Utils.setInputWeightNotificationEvent(context, 18, 0, "123") //체중 입력 알림 이벤트 세팅
        Utils.setWarningNotificationEvent(context, 12, 0, "456") //경고 알림 이벤트 세팅
        Utils.setDateChangedEvent(context) //0시 이벤트 세팅
    }

    //0시 이벤트 세팅
    fun setDateChangedEvent(context: Context) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager
        val intent = Intent(context, DateChangedReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT)

        val calendar: Calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 24)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)

        alarmManager!!.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
    }

    //체중 입력 알림 이벤트 세팅
    fun setInputWeightNotificationEvent(context: Context, hour: Int, minute: Int, message: String) {
        val nowDate: LocalDate = LocalDate.now()
        if (LocalDateTime.now().isAfter(LocalDateTime.of(nowDate.year, nowDate.month, nowDate.dayOfMonth, hour, minute))) {
            return
        }

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager
        val intent = Intent(context, InputWeightNotificationReceiver::class.java)
        intent.putExtra("message", message)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT)

        val calendar: Calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minute)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)

        alarmManager!!.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
    }

    //체중 입력 알림 이벤트 취소
    fun cancelInputWeightNotificationEvent(context: Context) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager
        val intent = Intent(context, InputWeightNotificationReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_NO_CREATE)
        alarmManager!!.cancel(pendingIntent)
    }

    //경고 알림 이벤트 세팅
    fun setWarningNotificationEvent(context: Context, hour: Int, minute: Int, message: String) {
        val nowDate: LocalDate = LocalDate.now()
        if (LocalDateTime.now().isAfter(LocalDateTime.of(nowDate.year, nowDate.month, nowDate.dayOfMonth, hour, minute))) {
            return
        }

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager
        val intent = Intent(context, WarningNotificationReceiver::class.java)
        intent.putExtra("message", message)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT)

        val calendar: Calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minute)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)

        alarmManager!!.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
    }

    //경고 알림 이벤트 취소
    fun cancelWarningNotificationEvent(context: Context) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager
        val intent = Intent(context, WarningNotificationReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_NO_CREATE)
        alarmManager!!.cancel(pendingIntent)
    }

}