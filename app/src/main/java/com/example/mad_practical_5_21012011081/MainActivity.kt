package com.example.mad_practical_5_21012011081

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.telecom.Call
import android.util.Log
import android.widget.Button
import android.widget.EditText
import java.net.URI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        implicitintent()
    }
    private fun implicitintent(){
        findViewById<Button>(R.id.button_browse).setOnClickListener {
            Log.i("Click", "MainActivity")
            Intent(Intent.ACTION_VIEW, Uri.parse(findViewById<EditText>(R.id.input_url).toString())).also { startActivity(it) }
        }
        findViewById<Button>(R.id.button_call_log).setOnClickListener {
            Log.i("Click", "MainActivity")
            val number = findViewById<EditText>(R.id.input_phone_no).text.toString().trim()
            Intent(Intent.ACTION_DIAL).setData((Uri.parse("tel$number")))
        }
        findViewById<Button>(R.id.button_call).setOnClickListener {
            Log.i("Click", "MainActivity")
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
        }
        findViewById<Button>(R.id.button_gallery).setOnClickListener {
            Log.i("Click", "MainActivity")
            Intent(Intent.ACTION_VIEW).setType("Image/*").also { startActivity(it) }
        }
        findViewById<Button>(R.id.button_camera).setOnClickListener {
            Log.i("Click", "MainActivity")
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
        }
        findViewById<Button>(R.id.button_alarm).setOnClickListener {
            Log.i("Click", "MainActivity")
            Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
        }

    }
}
