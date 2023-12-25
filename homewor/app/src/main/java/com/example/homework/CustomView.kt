package com.example.homework

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

class CustomView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    LinearLayout(context, attrs) {
    init {
        inflate(context, R.layout.activity_main, this)
    }
}