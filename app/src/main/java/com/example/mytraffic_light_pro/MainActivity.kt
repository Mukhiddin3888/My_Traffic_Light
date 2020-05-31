package com.example.mytraffic_light_pro

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.util.*

class MainActivity : Activity() {

    var myImage: ImageView? = null
    var imageArray: Array<Int> =
        arrayOf(R.drawable.red, R.drawable.yellow, R.drawable.green, R.drawable.yellow1)
    var time: Timer? = null
    var isRun = false
    var counter: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myImage = findViewById(R.id.imageView)
    }

    fun onClickStartStopBtn(view: View) {
        view as ImageButton

        if (!isRun) {
            startStop()
            isRun = true
            view.setImageResource(R.drawable.start)

        } else {
            view.setImageResource(R.drawable.stop)
            myImage?.setImageResource(R.drawable.yellow1)
            isRun = false
            time?.cancel()
            counter = 0
        }
    }

    fun startStop() {
        time = Timer()
        time?.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread(){
                    myImage?.setImageResource(imageArray[counter])
                    counter++
                    if (counter == 4) counter = 0
                }

            }

        }, 0, 1000)
    }
}