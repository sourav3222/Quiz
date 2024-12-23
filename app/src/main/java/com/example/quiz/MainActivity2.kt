package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quiz.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val skip = intent.getIntExtra("skip", 0)
        val carrect = intent.getIntExtra("carrect", 0)
        val wrong = intent.getIntExtra("wrong", 0)


        binding.result.text =
            "Skip : $skip\n" + "Carrect Answer : $carrect\n" + "Wrong Answer : $wrong"


    }
}