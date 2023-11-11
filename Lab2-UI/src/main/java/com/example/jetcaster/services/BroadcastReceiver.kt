package com.example.jetcaster.services

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi


class BroadcastReceiver : BroadcastReceiver() {


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onReceive(context: Context, intent: Intent) {
        if(intent.action == "android.intent.action.DOWNLOAD_COMPLETE") {
            val id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1L)
            if(id != -1L) {
                println("DESCARGA CON ID $id FINALIZADA")
                val toast = Toast.makeText(context, "DESCARGA CON ID $id FINALIZADA", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }
}