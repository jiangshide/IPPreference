package com.example.ippreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.preference.pool.PreferenceParcel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testText = findViewById<TextView>(R.id.testText)
//        testText.text = PreferenceParcel.obtain().stringFromJNI()
    }
}