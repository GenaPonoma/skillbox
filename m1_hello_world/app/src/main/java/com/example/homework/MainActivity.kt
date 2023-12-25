package com.example.homework

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val remainingSeats = 50
    private var counter = 0
    private var countFreePlaces = remainingSeats

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        standardOutput(binding)

        binding.plusButton.setOnClickListener {
            updateScreenState(binding, it)

        }
        binding.minusButton.setOnClickListener {
            updateScreenState(binding, it)

        }
        binding.resetButton.setOnClickListener {
            counter = 0
            updateScreenState(binding, it)
        }

    }

    @SuppressLint("SetTextI18n")
    private fun updateScreenState(binding: ActivityMainBinding, it: View) {
        when (it) {
            binding.resetButton -> {
                standardOutput(binding)
            }

            binding.plusButton -> {
                it.isActivated = counter < remainingSeats
                if (it.isActivated) {
                    binding.resetButton.visibility = View.INVISIBLE
                    binding.informationMessage.setTextColor(Color.parseColor("#0000ff"))
                    binding.placeCounter.text = counter++.toString()
                    binding.placeCounter.text = counter.toString()
                    countFreePlaces = calcPlaces()
                    binding.informationMessage.text = "Колличество свободных мест: $countFreePlaces"
                }
                if (counter == remainingSeats) {
                    binding.informationMessage.text = "Пассажиров слишком много !"
                    binding.informationMessage.setTextColor(Color.parseColor("#FF0000"))
                    binding.resetButton.visibility = View.VISIBLE
                }
            }

            binding.minusButton -> {
                it.isActivated = counter != 0
                if (it.isActivated) {
                    binding.resetButton.visibility = View.INVISIBLE
                    binding.informationMessage.setTextColor(Color.parseColor("#0000ff"))
                    binding.placeCounter.text = counter--.toString()
                    binding.placeCounter.text = counter.toString()
                    countFreePlaces = calcPlaces()
                    binding.informationMessage.text = "Колличество свободных мест: $countFreePlaces"
                    if (counter == 0) {
                        standardOutput(binding)
                    }
                }
            }
        }
    }

    private fun standardOutput(binding: ActivityMainBinding) {
        binding.resetButton.visibility = View.INVISIBLE
        binding.informationMessage.text = "Все места свободны"
        binding.informationMessage.setTextColor(Color.parseColor("#0aad3f"))
        binding.placeCounter.text = counter.toString()
    }

    private fun calcPlaces(): Int {
        return remainingSeats - counter

    }
}