package com.wdeo3601.jfabulous

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.wdeo3601.jfabulous.widget.JFabulousView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jFabulousView = findViewById<JFabulousView>(R.id.j_fabulous_view)
        jFabulousView.setCurrentFabulousCount(5000)
        jFabulousView.setSelect(true)
    }
}
