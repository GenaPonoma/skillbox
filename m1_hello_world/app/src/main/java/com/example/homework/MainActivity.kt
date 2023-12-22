package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val remainingSeats = 50;
    var counter = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.placeCounter.text = counter.toString()
        binding.plusButton.setOnClickListener {
            if (counter == 0) {
                binding.placeCounter.text = counter++.toString()
            }else if{

            }
        }
        binding.minusButton.setOnClickListener {
            binding.placeCounter.text = counter--.toString()
        }

    }
}