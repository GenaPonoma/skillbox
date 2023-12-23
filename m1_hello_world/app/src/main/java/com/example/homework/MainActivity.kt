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

        if (counter == 0) {
            binding.resetButton.visibility = View.INVISIBLE
            binding.informationMessage.text = "Все места свободны"
            binding.informationMessage.setTextColor(Color.parseColor("#0aad3f"))
            binding.placeCounter.text = counter.toString()
        }


        binding.plusButton.setOnClickListener {
            it.isActivated = counter < remainingSeats
            if (it.isActivated) {
                binding.resetButton.visibility = View.INVISIBLE
                binding.informationMessage.setTextColor(Color.parseColor("#0000ff"))
                binding.placeCounter.text = counter++.toString()
                binding.placeCounter.text = counter.toString()
                countFreePlaces = сalck()
                binding.informationMessage.text = "Колличество свободных мест: $countFreePlaces"
            }
            if (counter == remainingSeats) {
                binding.informationMessage.text = "Пассажиров слишком много !"
                binding.informationMessage.setTextColor(Color.parseColor("#FF0000"))
                binding.resetButton.visibility = View.VISIBLE


            }


        }
        binding.minusButton.setOnClickListener {

            it.isActivated = counter != 0
            if (it.isActivated) {
                binding.resetButton.visibility = View.INVISIBLE
                binding.informationMessage.setTextColor(Color.parseColor("#0000ff"))
                binding.placeCounter.text = counter--.toString()
                binding.placeCounter.text = counter.toString()
                countFreePlaces = сalck()
                binding.informationMessage.text = "Колличество свободных мест: $countFreePlaces"
                if (counter == 0) {
                    binding.informationMessage.text = "Все места свободны"
                    binding.informationMessage.setTextColor(Color.parseColor("#0aad3f"))
                }

            }

        }
        binding.resetButton.setOnClickListener {
            counter = 0
            binding.resetButton.visibility = View.INVISIBLE
            binding.informationMessage.text = "Все места свободны"
            binding.informationMessage.setTextColor(Color.parseColor("#0aad3f"))
            binding.placeCounter.text = counter.toString()
        }

    }

    private fun сalck(): Int {
        return remainingSeats - counter

    }
}