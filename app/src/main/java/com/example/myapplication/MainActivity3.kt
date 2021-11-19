package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button

class MainActivity3 : AppCompatActivity() {

    private lateinit var returnHomePage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        getSupportActionBar()?.hide()

        setContentView(R.layout.activity_main3)

        returnHomePage = findViewById(R.id.returnHomePage)

        returnHomePage.setOnClickListener{

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}