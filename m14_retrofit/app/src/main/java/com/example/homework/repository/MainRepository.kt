package com.example.homework.repository


import com.example.homework.models.User
import com.example.homework.retrofit.retrofit

class MainRepository {
    suspend fun getUsers(): User {
        return retrofit.getRandomUser()
    }

}