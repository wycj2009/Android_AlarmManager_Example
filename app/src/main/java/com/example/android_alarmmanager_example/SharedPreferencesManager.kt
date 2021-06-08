package com.example.android_alarmmanager_example

import android.content.Context
import android.content.SharedPreferences

object SharedPreferencesManager {
    private const val PREFERENCES_NAME: String = "configuration_data"
    private const val DEFAULT_VALUE_STRING: String = ""
    private const val DEFAULT_VALUE_BOOLEAN: Boolean = false
    private const val DEFAULT_VALUE_INT: Int = 0

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    //String 값 저장
    //alarmLog
    fun setString(context: Context, key: String, value: String) {
        val prefs: SharedPreferences = getPreferences(context)
        val editor = prefs.edit()
        editor.putString(key, value)
        editor.commit()
    }

    //boolean 값 저장
    fun setBoolean(context: Context, key: String, value: Boolean) {
        val prefs: SharedPreferences = getPreferences(context)
        val editor = prefs.edit()
        editor.putBoolean(key, value)
        editor.commit()
    }

    //int 값 저장
    fun setInt(context: Context, key: String, value: Int) {
        val prefs: SharedPreferences = getPreferences(context)
        val editor = prefs.edit()
        editor.putInt(key, value)
        editor.commit()
    }

    //String 값 로드
    fun getString(context: Context, key: String): String? {
        val prefs: SharedPreferences = getPreferences(context)
        return prefs.getString(key, DEFAULT_VALUE_STRING)
    }

    //boolean 값 로드
    fun getBoolean(context: Context, key: String): Boolean {
        val prefs: SharedPreferences = getPreferences(context)
        return prefs.getBoolean(key, DEFAULT_VALUE_BOOLEAN)
    }

    //int 값 로드
    fun getInt(context: Context, key: String): Int {
        val prefs: SharedPreferences = getPreferences(context)
        return prefs.getInt(key, DEFAULT_VALUE_INT)
    }

    //키 값 삭제
    fun removeKey(context: Context, key: String) {
        val prefs: SharedPreferences = getPreferences(context)
        val edit = prefs.edit()
        edit.remove(key)
        edit.commit()
    }

    //모든 저장 데이터 삭제
    fun clear(context: Context) {
        val prefs: SharedPreferences = getPreferences(context)
        val edit = prefs.edit()
        edit.clear()
        edit.commit()
    }

}