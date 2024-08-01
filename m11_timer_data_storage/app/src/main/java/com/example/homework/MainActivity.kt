package com.example.homework

import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val repository = Repository(applicationContext)
        binding.editText.setText(repository.getText())
        binding.saveButton.setOnClickListener {
                repository.saveText(binding.editText.text.toString())
            Toast.makeText(this, "Текст сохранен", Toast.LENGTH_SHORT).show()
        }
        binding.clearButton.setOnClickListener {
            repository.clearText()
            Toast.makeText(this, "Текст удален", Toast.LENGTH_SHORT).show()
        }
    }
}