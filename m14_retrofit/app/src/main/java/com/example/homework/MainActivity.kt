package com.example.homework

import CatImageModel
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        testFun()

    }

    fun testFun() {
        val plaeyrJson = """
             {
  "username": "jesse",
  "lucky number": 32
}
        """.trimIndent()


        lifecycleScope.launch {
            coroutineScope {
                val moshi = Moshi.Builder().build()
                val jsonAdapter  =
                    moshi.adapter<Player>(Player::class.java)


                val player= jsonAdapter.fromJson(plaeyrJson)



                Log.e("catImage", player.toString())
            }
        }

    }
}