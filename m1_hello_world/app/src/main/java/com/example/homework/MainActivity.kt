package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val remainingSeats = 50;
    private var counter = 0;
    private var countFreePlaces = remainingSeats
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (counter == 0) binding.informationMessage.text = "Все места свободны"
        binding.placeCounter.text = counter.toString()
        binding.plusButton.setOnClickListener {
            binding.placeCounter.text = counter++.toString()
            binding.placeCounter.text = counter.toString()
            countFreePlaces = сalculateAvailableSeats()
            binding.informationMessage.text = "Колличество свободных мест: $countFreePlaces"
        }
        binding.minusButton.setOnClickListener {
            binding.placeCounter.text = counter--.toString()
            binding.placeCounter.text = counter.toString()
            countFreePlaces = сalculateAvailableSeats()
            binding.informationMessage.text = "Колличество свободных мест: $countFreePlaces"
        }

    }

    private fun сalculateAvailableSeats(): Int {
        return remainingSeats - counter

    }
}