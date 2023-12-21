package com.example.homework
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import com.example.homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var occupiedPlaces: Int = 0
    private val maxPlaces: Int =50;
    private var numberAvailableSeats =0

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.placeCounter.text = occupiedPlaces.toString()
        binding.resetButton.isEnabled = false
        binding.setPlusButton.setOnClickListener {

            binding.placeCounter.text = occupiedPlaces++.toString()
            if (occupiedPlaces==0) {
//                binding.conclusion.setTextColor(R.color.green)
                binding.conclusion.text = "Все места свободны"
            }
            else if (occupiedPlaces < maxPlaces && occupiedPlaces != 0) {
                binding.conclusion.text = "Осталось мест : $numberAvailableSeats"
//                binding.conclusion.setTextColor(R.color.blue)
            } else if (occupiedPlaces == 50) {

//                binding.conclusion.setTextColor(R.color.red)
                binding.resetButton.isEnabled = true
                binding.resetButton.visibility = VISIBLE
                binding.setPlusButton.isEnabled = false
            }


        }


    }


}