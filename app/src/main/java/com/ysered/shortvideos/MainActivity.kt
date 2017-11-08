package com.ysered.shortvideos

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recordVideoButton.setOnClickListener {
            val clazz = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                RecordVideoActivityLollipop::class.java
            else
                RecordVideoActivityJellyBean::class.java
            startActivity(Intent(this, clazz))
        }
    }
}
