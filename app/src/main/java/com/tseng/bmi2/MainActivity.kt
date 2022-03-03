package com.tseng.bmi2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tseng.bmi2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var secretNum = (1..100).random()
    var min = 1
    var max = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun bmi(view: View) {
        var weight = binding.edWeight.text.toString().toFloat()
        var height = binding.edHeight.text.toString().toFloat()
        println("Your BMI is ${weight/(height*height)}")
    }

    fun guess(view: View) {
        var inputNum = binding.edNumber.text.toString().toInt()
        if (inputNum < min || inputNum > max) {
            println("Funny?")
            return
        }
        if (inputNum > secretNum) {
            max = inputNum
            println("Try $min ~ $max")
        } else if (inputNum < secretNum) {
            min = inputNum
            println("Try $min ~ $max")
        } else {
            secretNum = (1..100).random()
            println("Well done.")
        }
    }
}