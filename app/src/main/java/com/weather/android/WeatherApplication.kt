package com.weather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

// 给Weather项目提供一种全局获取Context的方式

class WeatherApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        const val TOKEN = "kr7vt3BNhgZ58cIz"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}