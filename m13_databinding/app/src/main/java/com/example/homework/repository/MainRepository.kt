package com.example.homework.repository

import kotlinx.coroutines.delay

class MainRepository {
    suspend fun dataSearch(text: String): String {
        delay(2000)
        return text
    }
}