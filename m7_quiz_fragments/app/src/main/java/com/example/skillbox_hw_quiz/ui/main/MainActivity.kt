package com.example.skillbox_hw_quiz.ui.main
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.skillbox_hw_quiz.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }



}