package com.example.diego.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun bClick(view: View)
    {
        val bSelected = view as Button
        var cellID = 0
        when(bSelected.id)
        {
            R.id.bu1->cellID = 1
            R.id.bu2->cellID = 2
            R.id.bu3->cellID = 3
            R.id.bu4->cellID = 4
            R.id.bu5->cellID = 5
            R.id.bu6->cellID = 6
            R.id.bu7->cellID = 7
            R.id.bu8->cellID = 8
            R.id.bu9->cellID = 9
        }

        //Toast.makeText(this, "ID:" + cellID, Toast.LENGTH_SHORT).show()

        playGame(cellID, bSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun playGame(cellID:Int, bSelected:Button)
    {
        if(activePlayer==1)
        {
            bSelected.text="X"
            bSelected.setBackgroundResource(R.color.blue)
            player1.add(cellID)
            activePlayer = 2
            autoPlay()
        }

        else
        {
            bSelected.text="O"
            bSelected.setBackgroundResource(R.color.darkgreen)
            player2.add(cellID)
            activePlayer = 1
        }


        bSelected.isEnabled=false
        checkWinner()
    }

    fun checkWinner()
    {
        var winner = -1

        //row 1
        if(player1.contains(1)&&player1.contains(2)&&player1.contains(3))
            winner = 1
        if(player2.contains(1)&&player2.contains(2)&&player2.contains(3))
            winner = 2

        //row 2
        if(player1.contains(4)&&player1.contains(5)&&player1.contains(6))
            winner = 1
        if(player2.contains(4)&&player2.contains(5)&&player2.contains(6))
            winner = 2

        //row 3
        if(player1.contains(7)&&player1.contains(8)&&player1.contains(9))
            winner = 1
        if(player2.contains(7)&&player2.contains(8)&&player2.contains(9))
            winner = 2

        //column 1
        if(player1.contains(1)&&player1.contains(4)&&player1.contains(7))
            winner = 1
        if(player2.contains(1)&&player2.contains(4)&&player2.contains(7))
            winner = 2

        //column 2
        if(player1.contains(2)&&player1.contains(5)&&player1.contains(8))
            winner = 1
        if(player2.contains(2)&&player2.contains(5)&&player2.contains(8))
            winner = 2


        //column 3
        if(player1.contains(3)&&player1.contains(6)&&player1.contains(9))
            winner = 1
        if(player2.contains(3)&&player2.contains(6)&&player2.contains(9))
            winner = 2

        //Parallel 1
        if(player1.contains(1)&&player1.contains(5)&&player1.contains(9))
            winner = 1
        if(player2.contains(1)&&player2.contains(5)&&player2.contains(9))
            winner = 2

        //Parallel 2
        if(player1.contains(3)&&player1.contains(5)&&player1.contains(7))
            winner = 1
        if(player2.contains(3)&&player2.contains(5)&&player2.contains(7))
            winner = 2

        if(winner != -1)
        {
            if(winner == 1)
                Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_SHORT).show()

            else
                Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_SHORT).show()

            winner = 2
        }
    }

    fun autoPlay()
    {
        var emptyCell = ArrayList<Int>()
        for(cellId in 1..9)
        {
            if(!(player1.contains(cellId) || player2.contains(cellId)))
                emptyCell.add(cellId)
        }

        val r = Random()
        val randIndex = r.nextInt(emptyCell.size -0)+0
        val cellId = emptyCell[randIndex]

        var bSelected:Button?
        when (cellId)
        {
            1->bSelected=bu1
            2->bSelected=bu2
            3->bSelected=bu3
            4->bSelected=bu4
            5->bSelected=bu5
            6->bSelected=bu6
            7->bSelected=bu7
            8->bSelected=bu8
            9->bSelected=bu9
            else->bSelected=bu1
        }

        playGame(cellId, bSelected)
    }

}
















