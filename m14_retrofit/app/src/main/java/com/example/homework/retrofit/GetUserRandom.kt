package com.example.homework.retrofit

import com.example.homework.models.User
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = " https://randomuser.me/api/"


val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()
    .create(GetRandomUser::class.java)




interface GetRandomUser {
    @GET(" ")
    suspend fun getRandomUser(): User
}