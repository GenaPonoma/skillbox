package com.example.skillbox_hw_quiz.ui.main
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.example.skillbox_hw_quiz.HelloFragment
import com.example.skillbox_hw_quiz.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }



}