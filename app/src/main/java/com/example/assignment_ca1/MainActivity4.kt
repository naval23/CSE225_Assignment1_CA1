package com.example.assignment_ca1

import android.app.NotificationManager
import android.app.RemoteInput
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {
    lateinit var notificationManager : NotificationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        var txtView = findViewById<TextView>(R.id.tv)

        var inp = MainActivity3()

        var bundle: Bundle = RemoteInput.getResultsFromIntent(intent)
        if(bundle != null)
            txtView.setText(bundle.getString(inp.myKey))

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.cancel(inp.notificationId)

    }
}