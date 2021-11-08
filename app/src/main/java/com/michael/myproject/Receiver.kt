package com.michael.myproject

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.lang.Exception

class Receiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val runnable = PushHandler(context?.applicationContext)
        Thread(runnable).start()
    }

    class PushHandler(private val context: Context?) : Runnable {
        override fun run() {
            try {
                context?.run {
                    startActivity(Intent(this, SecondActiivty::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
//                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    })
//                    startActivities(arrayOf(Intent(this, SecondActiivty::class.java).apply {
//                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
////                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
//                    }))
                }
            } catch (e: Exception) {
                Log.e("tmp", "Caught exception while performing the push ")
            }
        }
    }
}