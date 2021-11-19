package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var player1:EditText
    private lateinit var player2:EditText
    private lateinit var start:Button
    private lateinit var ruls:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        getSupportActionBar()?.hide()

        setContentView(R.layout.activity_main)


        player1 = findViewById(R.id.player1)
        player2 = findViewById(R.id.player2)

        start = findViewById(R.id.start)

        ruls = findViewById(R.id.ruls)




        start.setOnClickListener {

            var playerOne = player1.text.toString()
            var playerSecond = player1.text.toString()

            if(playerOne.isEmpty()){
                Toast.makeText(this,"შეიყვანეთ პირველი მოთამაშის სახელი", Toast.LENGTH_SHORT).show()

            }
            else if(playerSecond.isEmpty()) {
                Toast.makeText(this, "შეიყვანეთ მეორე მოთამაშის სახელი", Toast.LENGTH_SHORT).show()
            }
            else{
                var intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("player1", playerOne)
                intent.putExtra("player2", playerSecond)
                startActivity(intent)
            }
        }

        ruls.setOnClickListener{

            var intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)

        }
    }
}
