package com.example.homework

import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
        binding.textResult.text = repository.getText()
        binding.editText.addTextChangedListener(object: TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                binding.textResult.text = s.toString()
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    binding.textResult.text = s.toString()

            }

            override fun afterTextChanged(s: Editable?) {
                binding.textResult.text = s.toString()

            }
        })


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