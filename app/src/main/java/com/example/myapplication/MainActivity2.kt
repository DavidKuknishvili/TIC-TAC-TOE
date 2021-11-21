package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.core.os.HandlerCompat.postDelayed


class MainActivity2 : AppCompatActivity(), View.OnClickListener {

    private lateinit var returnHomePage: Button


    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()

    private lateinit var button1: ImageButton
    private lateinit var button2: ImageButton
    private lateinit var button3: ImageButton
    private lateinit var button4: ImageButton
    private lateinit var button5: ImageButton
    private lateinit var button6: ImageButton
    private lateinit var button7: ImageButton
    private lateinit var button8: ImageButton
    private lateinit var button9: ImageButton

    private var activePlayer = 1



    private lateinit var playerOne:TextView
    private lateinit var playerSecond:TextView

    private lateinit var firstIcon: ImageView
    private lateinit var secondIcon: ImageView


    private lateinit var playerOneScore:TextView
    private lateinit var playertwoscore:TextView

    var secondScore = 0
    var firstScore = 0





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        getSupportActionBar()?.hide()

        setContentView(R.layout.activity_main2)

        playerOne = findViewById(R.id.playerone)
        playerSecond = findViewById(R.id.playersecond)

        playerOne.text = intent?.extras?.getString("player1", "")
        playerSecond.text = intent?.extras?.getString("player2", "")


        playerOneScore = findViewById(R.id.firstscore)
        playertwoscore = findViewById(R.id.secondscore)

        firstIcon = findViewById(R.id.firstIcon)
        secondIcon = findViewById(R.id.secondIcon)


        returnHomePage = findViewById(R.id.returnHomePage)

        returnHomePage.setOnClickListener{

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        init()





    }
    private fun init(){
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)


    }



    override fun onClick(clickedView: View) {
        var buttonNumber = 0

        if(clickedView is ImageButton) {
            when (clickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }
            if (buttonNumber != 0) {
                playgame(clickedView, buttonNumber)

            }

        }
    }


    private fun playgame(clickedView: ImageButton, buttonNumber: Int) {

        if (activePlayer == 1){
            clickedView.setImageResource(R.drawable.x_click)
            firstIcon.setImageResource(R.drawable.dark_x)
            secondIcon.setImageResource(R.drawable.light_o)


            player1.add(buttonNumber)
            activePlayer = 2
        }
        else {
            clickedView.setImageResource(R.drawable.o_click)
            secondIcon.setImageResource(R.drawable.dark_o)
            firstIcon.setImageResource(R.drawable.light_x)


            player2.add(buttonNumber)
            activePlayer = 1
        }
        clickedView.isEnabled = false
        check()


    }





    private fun check() {

        var winnerplayer = 0


//      winner combination
        if (player1.contains(1) && player1.contains(2)  && player1.contains(3)){
            winnerplayer = 1
        }
        else if (player2.contains(1) && player2.contains(2)  && player2.contains(3)){
            winnerplayer = 2
        }


        else if (player1.contains(4) && player1.contains(5)  && player1.contains(6)){
            winnerplayer = 1
        }
        else if (player2.contains(4) && player2.contains(5)  && player2.contains(6)){
            winnerplayer = 2
        }


        else if (player1.contains(7) && player1.contains(8)  && player1.contains(9)){
            winnerplayer = 1
        }
        else if (player2.contains(7) && player2.contains(8)  && player2.contains(9)){
            winnerplayer = 2
        }


        else if (player1.contains(1) && player1.contains(4)  && player1.contains(7)){
            winnerplayer = 1
        }
        else if (player2.contains(1) && player2.contains(4)  && player2.contains(7)){
            winnerplayer = 2
        }


        else if (player1.contains(2) && player1.contains(5)  && player1.contains(8)){
            winnerplayer = 1
        }
        else if (player2.contains(2) && player2.contains(5)  && player2.contains(8)){
            winnerplayer = 2
        }
        else if (player1.contains(3) && player1.contains(6)  && player1.contains(9)){
            winnerplayer = 1
        }
        else if (player2.contains(3) && player2.contains(6)  && player2.contains(9)){
            winnerplayer = 2
        }


        else if (player1.contains(1) && player1.contains(5)  && player1.contains(9)){
            winnerplayer = 1
        }
        else if (player2.contains(1) && player2.contains(5)  && player2.contains(9)){
            winnerplayer = 2
        }

        else if (player1.contains(3) && player1.contains(5)  && player1.contains(7)){
            winnerplayer = 1
        }
        else if (player2.contains(3) && player2.contains(5)  && player2.contains(7)) {
            winnerplayer = 2
        }
        else if (player1.size + player2.size == 9){
            Toast.makeText(this, "ფრე", Toast.LENGTH_SHORT).show()

            Handler().postDelayed({
                reset()
            }, 500)

        }





        if (winnerplayer == 1) {
            firstScore++
            playerOneScore.text = firstScore.toString()
            disableButtons()

            Handler().postDelayed({
                reset()
            }, 500)



            Toast.makeText(this, "გამარჯვებულია ${playerOne.text}", Toast.LENGTH_SHORT).show()

        }
        if (winnerplayer == 2) {
            secondScore++
            playertwoscore.text = secondScore.toString()
            disableButtons()

            Handler().postDelayed({
                reset()
            }, 500)




            Toast.makeText(this, "გამარჯვებულია ${playerSecond.text}", Toast.LENGTH_SHORT).show()

        }








    }

    private fun disableButtons() {
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false

    }


    private fun reset() {

        activePlayer = 1

        player1.clear()
        player2.clear()


        secondIcon.setImageResource(R.drawable.dark_o)
        firstIcon.setImageResource(R.drawable.light_x)

        button1.isEnabled = true
        button1.setImageResource(R.drawable.shape)

        button2.isEnabled = true
        button2.setImageResource(R.drawable.shape)

        button3.isEnabled = true
        button3.setImageResource(R.drawable.shape)

        button4.isEnabled = true
        button4.setImageResource(R.drawable.shape)

        button5.isEnabled = true
        button5.setImageResource(R.drawable.shape)

        button6.isEnabled = true
        button6.setImageResource(R.drawable.shape)

        button7.isEnabled = true
        button7.setImageResource(R.drawable.shape)

        button8.isEnabled = true
        button8.setImageResource(R.drawable.shape)

        button9.isEnabled = true
        button9.setImageResource(R.drawable.shape)
    }

}