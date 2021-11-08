package com.michael.myproject.test

import android.app.Application
import android.content.res.Configuration
import android.util.Log

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("tmp", "masuk onCreate")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("tmp", "masuk onConfigurationChanged")
    }
}