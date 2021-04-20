package com.example.uidesignandroidstudio

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        /**
         * REMOVE THE APP BAR
         * */
        val bar = supportActionBar
        bar?.hide()

        val message = intent.getStringExtra("MESSAGE")
        val text = findViewById<TextView>(R.id.textView4)

            text.text = message
    }

}