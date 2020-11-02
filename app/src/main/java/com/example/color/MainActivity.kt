package com.example.color

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

private lateinit var redButton:Button
private lateinit var greenButton:Button
private lateinit var blueButton:Button
private lateinit var name:TextView


class MainActivity : AppCompatActivity(),ColorFragment.Callbacks{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        redButton =findViewById(R.id.red)
        greenButton =findViewById(R.id.green)
        blueButton =findViewById(R.id.blue)
        name=findViewById(R.id.my_name)

        redButton.setOnClickListener{
            sendColor("red")
        }
        greenButton.setOnClickListener{
            sendColor("green")
        }
        blueButton.setOnClickListener{
            sendColor("blue")
        }

    }

fun sendColor(color :String){
    var currentFragment=supportFragmentManager.findFragmentById(R.id.text_fragment)
    supportFragmentManager
        .beginTransaction()
        .replace(R.id.text_fragment,ColorFragment.newInstance(color))
        .commit()

}

    override fun onAddName(Name: String) {
       
        var currentFragment=supportFragmentManager.findFragmentById(R.id.text_fragment1)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.text_fragment1,NewFragment.newInstance(Name))
            .commit()
    }
}