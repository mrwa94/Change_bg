package com.example.change_bg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout








class MainActivity : AppCompatActivity() {

    lateinit var constraint: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et = findViewById<TextView>(R.id.et)
        val button = findViewById<Button>(R.id.btn)
        constraint = findViewById(R.id.constr)

        button.setOnClickListener {
            val tmp = et.text.toString()
            if(tmp.isNotEmpty()){
                if (tmp == "Day"){
                    DayOrNight.day = true
                    DayOrNight.night = false
                    Background.changeBackground(constraint)
                }
                else if(tmp == "Night"){
                    DayOrNight.day = false
                    DayOrNight.night = true
                    Background.changeBackground(constraint)
                }
                else
                    Toast.makeText(this, "Enter Day or Night", Toast.LENGTH_LONG).show()
            }
        }


    }
}


class Background{
    companion object{

        fun changeBackground(ctx: ConstraintLayout){
            if(DayOrNight.day){
                ctx.setBackgroundResource(R.drawable.img3)
            }else{
                ctx.setBackgroundResource(R.drawable.img2)
            }
        }
    }
}

class DayOrNight{
    companion object{
        var day = false
        var night = false
    }
}